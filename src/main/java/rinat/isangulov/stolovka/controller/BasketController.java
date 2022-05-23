package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.entity.Order;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.DishRepository;
import rinat.isangulov.stolovka.repository.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BasketController {

    private static ArrayList<Dish> DISH_REPOSITORY = new ArrayList<>();
    private static final Map<Long, Dish> DISH_REPOSITORY_MAP = new HashMap<>();

    private static final ArrayList<Dish> ORDER_REPOSITORY = new ArrayList<>();
    private static final Map<String, ArrayList<Dish>> ORDER_REPOSITORY_MAP = new HashMap<>();

    private static int count = 0;


    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/basket")
    public String basketForm(@AuthenticationPrincipal User currentUser, Model model) {

        Order order = orderRepository.findOrderByCode("01");
        if (order != null) {
            model.addAttribute("totalSum", order.getCost());
        }

        model.addAttribute("dishes", DISH_REPOSITORY);
        return "basket";
    }

    @PostMapping("/addDishToBasket")
    public String dishSave(@RequestParam Long dishId, Model model) {
        Dish dish = dishRepository.findDishById(dishId);

        if (DISH_REPOSITORY_MAP.containsKey(dishId)) {
            int i = dish.getCount();
            dish.setCount(i++);
            DISH_REPOSITORY_MAP.put(dishId, dish);
            DISH_REPOSITORY.clear();
            DISH_REPOSITORY = new ArrayList<>(DISH_REPOSITORY_MAP.values());
        } else {
            DISH_REPOSITORY_MAP.put(dishId, dish);
            DISH_REPOSITORY.add(dish);
        }

        float totalSum = 0;
        for (int i = 0; i < DISH_REPOSITORY.size(); i++) {
            totalSum += Float.parseFloat(DISH_REPOSITORY.get(i).getPrice());
        }

        Order order = orderRepository.findOrderByCode("01");
        if (order == null) {
            order = new Order();

            order.setCode("01");
        }
        order.setCost(String.valueOf(totalSum));
        order.setActive(true);
        orderRepository.save(order);

        model.addAttribute("dishes", DISH_REPOSITORY);
        return "redirect:/";
    }

    @PostMapping("/addOrder")
    public String addOrder(Model model) {
        ORDER_REPOSITORY.addAll(DISH_REPOSITORY);
        DISH_REPOSITORY.clear();
        DISH_REPOSITORY_MAP.clear();

        String pattern = "hhmmss-ddMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        count++;
        String orderCode = "A-0" + Integer.toString(count) + "-" + date;

        ORDER_REPOSITORY_MAP.put(orderCode, ORDER_REPOSITORY);

        String orderStatus = "Обрабатывается...";

        model.addAttribute("dishes", ORDER_REPOSITORY);
        model.addAttribute("orderCode", orderCode);
        model.addAttribute("orderStatus", orderStatus);
        return "orderAccept";
    }

}
