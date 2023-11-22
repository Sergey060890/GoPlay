package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.service.interfaces.EventTypeService;

@Controller
public class EventTypeController {
    /**
     * EventType controller
     */

    /**
     * Spring dependency injection autocomplete
     */
    @Autowired
    private EventTypeService eventTypeService;



}
