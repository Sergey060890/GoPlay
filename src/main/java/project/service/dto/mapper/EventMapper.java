package project.service.dto.mapper;

import project.models.Event;
import project.models.User;
import project.service.dto.EventDTO;
import project.service.dto.UserDTO;

/**
 * EventMapper
 */
public class EventMapper {
    public static EventDTO mapFrom(Event event) {
        return new EventDTO(event.getEvent_id(), event.getEvent_date(), event.getEvent_time_start(),
                event.getEvent_time_finish(), event.getCountry(), event.getCity(), event.getSex_type(),
                event.getNumber_people_fact(), event.getNumber_people_max(), event.getPlace_name(),
                event.getAge_min(), event.getAge_max(), event.getEvent_comment(), event.getLevel_game(),
                event.getEvent_type(), event.getCreator(), event.getEventUsers()
        );
    }
}
