package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDishesRepository orderDishesRepository;

    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/basket")
    public String basketForm(@AuthenticationPrincipal User currentUser, Model model) {
        List<Order> currentUserOrdersFromDbList = orderRepository.findAllByUser(currentUser);
        for (Order order : currentUserOrdersFromDbList) {
            if (order == null) {
                model.addAttribute("message", "Корзина пуста");
            } else {
                if (order.getCode().equals(BASKET_CODE)) {
                    addDishesFromOrderToModel(order, model);
                }
            }
        }
        return "basket";
    }

    private void addDishesFromOrderToModel(Order order, Model model) {
        List<OrderDishes> orderDishes = orderDishesRepository.findAllByOrderId(order.getId());
        ArrayList<Dish> dishes = new ArrayList<>();
        ArrayList<Integer> dishesCount = new ArrayList<>();

        for (OrderDishes ordDish : orderDishes) {
            dishes.add(dishRepository.findDishById(ordDish.getDishId()));
            dishesCount.add(ordDish.getCount());
        }

        model.addAttribute("dishes", dishes);
        model.addAttribute("dishesCount", dishesCount);
        model.addAttribute("orderTotalCost", getOrderTotalCostFromDb());
    }

    @PostMapping("/addDishToBasket")
    public String dishSave(@AuthenticationPrincipal User currentUser, @RequestParam Long dishId) {
        Dish dish = dishRepository.findDishById(dishId);
        List<Order> ordersFromDb = orderRepository.findAllByUser(currentUser);

        boolean hasBasket = false;
        // если у пользователя нет заказов, то создается корзина, иначе добавление в существующую корзину
        if (ordersFromDb.isEmpty()) {
            addDishToOrderDishes(currentUser, dish, createBasketOrder(dish));
        } else {
            for (Order order : ordersFromDb) {
                if (order.getCode().equals(BASKET_CODE)) {
                    addDishToOrderDishes(currentUser, dish, order);
                    hasBasket = true;
                    break;
                }
            }
        }
        if (!hasBasket) {
            addDishToOrderDishes(currentUser, dish, createBasketOrder(dish));
        }

        return "redirect:/";
    }

    private Order createBasketOrder(Dish dish) {
        Order order = new Order();
        order.setCode(BASKET_CODE);
        order.setActive(false);
        order.setCost(dish.getPrice());
        order.setUser(getCurrentUser());
        order.setActive(false);
        order.setStatus("NEW");

        orderRepository.save(order);
        return order;
    }

    private void addDishToOrderDishes(User currentUser, Dish dish, Order order) {
        boolean newDishFlag = true;
        Long userBasketOrderId = getUserBasketOrderId(currentUser);
        if (userBasketOrderId != null) {
            List<OrderDishes> orderDishesList = orderDishesRepository.findAllByOrderId(userBasketOrderId);
            for (OrderDishes ordDish : orderDishesList) {
                // если блюдо уже добавлено в корзину, то увеличивается его количество
                if (ordDish.getDishId().equals(dish.getId())) {
                    OrderDishes orderDishes2 = orderDishesRepository.findOrderDishesById(ordDish.getId());
                    int count = ordDish.getCount();
                    orderDishes2.setCount(++count);
                    orderDishes2.setCost(dish.getPrice() * count);
                    orderDishesRepository.save(orderDishes2);
                    newDishFlag = false;
                    break;
                }
            }
        }

        if (newDishFlag) {
            // новое блюдо в заказе
            OrderDishes orderDishes = new OrderDishes();
            orderDishes.setDishId(dish.getId());
            orderDishes.setOrderId(order.getId());
            orderDishes.setCount(1);
            orderDishes.setCost(dish.getPrice());
            orderDishesRepository.save(orderDishes);
        }

        //общая стоимость заказа
        order.setCost(getOrderTotalCost());
        orderRepository.save(order);
    }

    private float getOrderTotalCost() {
        float totalCost = 0;
        Long userBasketOrderId = getUserBasketOrderId(getCurrentUser());
        if (userBasketOrderId != null) {
            List<OrderDishes> orderDishesList = orderDishesRepository.findAllByOrderId(userBasketOrderId);
            for (OrderDishes ordDish : orderDishesList) {
                totalCost += ordDish.getCost();
            }
        }
        return totalCost;
    }

    private float getOrderTotalCostFromDb() {
        Long userBasketOrderId = getUserBasketOrderId(getCurrentUser());
        if (userBasketOrderId != null) {
            Order order = orderRepository.findOrderById(userBasketOrderId);
            return order.getCost();
        }
        return 0;
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
    public String addOrder(Model model) {

        Long userBasketOrderId = getUserBasketOrderId(getCurrentUser());
        if (userBasketOrderId != null) {
            Order order = orderRepository.findOrderById(userBasketOrderId);
            order.setActive(true);

            String newCode = String.valueOf(order.getId() % 1000);
            order.setCode(newCode);
            order.setStatus("PROCESSED");

            String pattern = "hhmmss-ddMMyyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            order.setDate(date);

            orderRepository.save(order);

            model.addAttribute("order", order);
            addDishesFromOrderToModel(order, model);
        }

        return "orderAccept";
    }

}
