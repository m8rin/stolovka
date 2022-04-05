package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rinat.isangulov.stolovka.entity.Dish;
import rinat.isangulov.stolovka.repository.DishRepository;

import java.util.Map;

@Controller
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/dishesList")
    public String dishesList(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());

        return "dishesList";
    }

    @GetMapping("/")
    public String menu(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());

        return "dishesList";
    }

    @GetMapping("/dish/{dish}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String dishEditForm(@PathVariable Dish dish, Model model) {
        if (dish.getCategory() == null) {
            dish.setCategory("");
            dishRepository.save(dish);
        }
        model.addAttribute("dish", dish);
        return "dishEdit";
    }

    @PostMapping("/dish")
    public String dishSave(
            @RequestParam String name,
            @RequestParam float price,
            @RequestParam String category,
            @RequestParam("dishId") Dish dish
    ) {
        dish.setName(name);
        dish.setPrice(price);
        dish.setCategory(category);

        dishRepository.save(dish);
        return "redirect:/";
    }
}