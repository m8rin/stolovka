package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.DishRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BasketController {

    private static ArrayList<Dish> DISH_REPOSITORY = new ArrayList<>();
    private static final Map<Long, Dish> DISH_REPOSITORY_MAP = new HashMap<>();

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/basket")
    public String basketForm(@AuthenticationPrincipal User currentUser, Model model) {

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

        model.addAttribute("dishes", DISH_REPOSITORY);
        return "redirect:/";
    }

}
