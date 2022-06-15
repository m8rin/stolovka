package rinat.isangulov.stolovka.controller;


import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.entity.Order;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.DishRepository;
import rinat.isangulov.stolovka.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DishRepository dishRepository;


    @GetMapping("/orderAdministration")
    public String orderAdministration(Model model) {
        model.addAttribute("orders", orderRepository.findAll());

        return "orderAdministration";
    }


    @PostMapping("/orders")
    public String orderSave(
            @RequestParam String code,
            @RequestParam Collection<Dish> dishesList,
            @RequestParam("order_id") Order order
    ) {
        order.setCode(code);
        order.setActive(true);
        //order.setDishesOrderList(dishesList);

        orderRepository.save(order);

        return "redirect:/";
    }

    @PostMapping("/addOrders")
    public String orderAdd() {
        Order order = new Order();
        order.setCode("123123");
        order.setActive(true);
/*

        Collection dishesList = new ArrayList();
        dishesList.add(dishRepository.findDishByCode("11078"));
        dishesList.add(dishRepository.findDishByCode("10446"));
        //order.setDishesOrderList(dishesList);
*/

        orderRepository.save(order);

        return "redirect:/";
    }

}
