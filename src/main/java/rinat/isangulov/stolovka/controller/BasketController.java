package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.BasketRepository;
import rinat.isangulov.stolovka.repository.DishRepository;

import java.util.ArrayList;

@Controller
public class BasketController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping("/basket")
    public String basketForm(@AuthenticationPrincipal User currentUser, Model model) {

        ArrayList dishes = new ArrayList();
        dishes.add(dishRepository.findDishByCode("12277"));
        dishes.add(dishRepository.findDishByCode("11078"));
        model.addAttribute("dishes", dishes);
        return "basket";
    }

}
