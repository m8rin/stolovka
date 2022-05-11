package rinat.isangulov.stolovka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/basket")
    public String basket(Map<String, Object> model) {
        return "basket";
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }
}