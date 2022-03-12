package rinat.isangulov.stolovka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rinat.isangulov.stolovka.entity.Role;
import rinat.isangulov.stolovka.entity.User;
import rinat.isangulov.stolovka.repository.UserRepository;
import rinat.isangulov.stolovka.service.UserService;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController extends UserService {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            @RequestParam String phoneNumber,
            @RequestParam String email,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", getCurrentUser());
        return "profile";
    }
}