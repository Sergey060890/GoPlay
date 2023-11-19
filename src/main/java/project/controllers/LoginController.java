package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static project.config.ConstansConfig.LOGIN;

@Controller
public class LoginController {
    /**
     * Login controller
     */

    @GetMapping("/login")
    String login() {
        return LOGIN;
    }
}
