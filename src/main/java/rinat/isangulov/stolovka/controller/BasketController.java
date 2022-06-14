package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinat.isangulov.stolovka.entity.*;
import rinat.isangulov.stolovka.repository.DishRepository;
import rinat.isangulov.stolovka.repository.OrderDishesRepository;
import rinat.isangulov.stolovka.repository.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BasketController {

    private static final String BASKET_CODE = "Basket";
    private static ArrayList<Dish> DISH_REPOSITORY = new ArrayList<>();
    private static final Map<Long, Dish> DISH_REPOSITORY_MAP = new HashMap<>();

    private static final ArrayList<Dish> ORDER_REPOSITORY = new ArrayList<>();
    private static final Map<String, ArrayList<Dish>> ORDER_REPOSITORY_MAP = new HashMap<>();

    private static int count = 0;


    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDishesRepository orderDishesRepository;

    @GetMapping("/basket")
    public String basketForm(@AuthenticationPrincipal User currentUser, Model model) {
        List<Order> currentUserOrdersFromDbList = orderRepository.findAllByUser(currentUser);
        for (Order order : currentUserOrdersFromDbList) {
            if (order == null) {
                model.addAttribute("message", "Корзина пуста");
            } else {
                if (order.getCode().equals(BASKET_CODE)) {
                    List<OrderDishes> orderDishes = orderDishesRepository.findAllByOrderId(order.getId());
                    ArrayList<Dish> dishes = new ArrayList<>();
                    //HashMap<Dish, String> dishesMap = new HashMap<>();

                    for (OrderDishes ordDish : orderDishes) {
                        dishes.add(dishRepository.findDishById(ordDish.getDishId()));
                        //dishesMap.put(dishRepository.findDishById(ordDish.getDishId()), String.valueOf(ordDish.getCount()));
                    }
                    model.addAttribute("dishes", dishes);
                    //model.addAttribute("dishesMap", dishesMap);
                }
            }
        }
        return "basket";
    }

    @PostMapping("/addDishToBasket")
    public String dishSave(@AuthenticationPrincipal User currentUser, @RequestParam Long dishId, Model model) {
        Dish dish = dishRepository.findDishById(dishId);

        List<Order> ordersFromDb = orderRepository.findAllByUser(currentUser);

        Order newOrder = new Order();
        if (ordersFromDb.isEmpty()) {
            newOrder.setCode(BASKET_CODE);
            newOrder.setActive(false);
            newOrder.setCost(dish.getPrice());
            newOrder.setUser(currentUser);
            newOrder.setActive(false);
            orderRepository.save(newOrder);
            addDishToOrderDishes(currentUser, dish, newOrder);
        } else {
            for (Order order : ordersFromDb) {
                if (order.getCode().equals(BASKET_CODE)) {
                    addDishToOrderDishes(currentUser, dish, order);
                }
            }
        }

        return "redirect:/";
    }

    private void addDishToOrderDishes(User currentUser, Dish dish, Order order) {
        boolean newDishFlag = true;
        Long userBasketOrderId = getUserBasketOrderId(currentUser);
        if (userBasketOrderId != null) {
            List<OrderDishes> orderDishesList = orderDishesRepository.findAllByOrderId(userBasketOrderId);
            for (OrderDishes ordDish : orderDishesList) {
                if (ordDish.getDishId().equals(dish.getId())) {
                    OrderDishes orderDishes2 = orderDishesRepository.findOrderDishesById(ordDish.getId());
                    int count = ordDish.getCount();
                    orderDishes2.setCount(++count);
                    orderDishesRepository.save(orderDishes2);
                    newDishFlag = false;
                    break;
                }
            }
        } else {
            System.out.println("Сюда не должно попасть))");
        }
        if (newDishFlag) {
            OrderDishes orderDishes = new OrderDishes();
            orderDishes.setDishId(dish.getId());
            orderDishes.setOrderId(order.getId());
            orderDishes.setCount(1);
            //TODO вычислять стоимость всего заказа
            //orderDishes.setCost();
            orderDishesRepository.save(orderDishes);
        }
    }

    private Long getUserBasketOrderId(User user) {
        List<Order> currentUserOrdersFromDb = orderRepository.findAllByUser(user);
        for (Order order : currentUserOrdersFromDb) {
            if (order != null && order.getCode().equals(BASKET_CODE)) {
                return order.getId();
            }
        }

        return null;
    }

    @PostMapping("/addOrder")
    public String addOrder(@AuthenticationPrincipal User currentUser, Model model) {

        String pattern = "hhmmss-ddMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        count++;
        String orderCode = "A-0" + Integer.toString(count) + "-" + date;

        ORDER_REPOSITORY_MAP.put(orderCode, ORDER_REPOSITORY);

        String orderStatus = "Обрабатывается";

        model.addAttribute("dishes", ORDER_REPOSITORY);
        model.addAttribute("orderCode", orderCode);
        model.addAttribute("orderStatus", orderStatus);
        Order order = orderRepository.findOrderByCode("01");
        if (order != null) {
            order.setCost("0");
            order.setActive(true);
            orderRepository.save(order);
        }
        currentUser.setCount(0);
        return "orderAccept";
    }

}
