package rinat.isangulov.stolovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rinat.isangulov.stolovka.repository.DishRepository;

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
}