package rinat.isangulov.stolovka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rinat.isangulov.stolovka.entity.Role;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPhoneNumber("Не заполнен");
        user.setEmail("Не заполнен");
        userRepository.save(user);

        return "redirect:/login";
    }
}