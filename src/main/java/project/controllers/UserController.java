package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.service.interfaces.UserService;

@Controller
public class UserController {
    /**
     * Spring dependency injection autocomplete
     */
    @Autowired
    private UserService userService;

    /**
     * Add user
     */
    @RequestMapping("/registration")
    public String userAdd(Model model) {
        return "registration";
    }

    /**
     * Add user (method post)
     */
    @PostMapping("/registration")
    public String teamPostAdd(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam Integer age,
                              @RequestParam String sex,
                              @RequestParam String country,
                              @RequestParam String city, Model model) {

        userService.createUser(name, surname, sex, country, city, age);
        return "login";
    }
}
