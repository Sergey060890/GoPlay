package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static project.config.ConstansConfig.LOGIN;

@Controller
public class LoginController {

    /**
     * Login controller
     */

    /**
     * Home page
     */
    @GetMapping("/")
    public String home(Model model) {
        return LOGIN;
    }

    /**
     * Login page
     */
    @GetMapping("/login")
    String login() {
        return LOGIN;
    }
}
