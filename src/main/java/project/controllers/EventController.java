package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.service.interfaces.EventService;

@Controller
public class EventController {
    /**
     * Spring dependency injection autocomplete
     */
    @Autowired
    private EventService eventService;
}
