package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.service.interfaces.EventService;
import project.service.interfaces.EventTypeService;

import static project.controllers.Constans.HOME;

@Controller
public class EventTypeController {

    /**
     * Spring dependency injection autocomplete
     */
    @Autowired
    private EventTypeService eventTypeService;

    /**
     * Home page
     */
    @GetMapping("/")
    public String home(Model model) {
        return HOME;
    }
}
