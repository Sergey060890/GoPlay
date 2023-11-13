package project.service.dto.mapper;

import project.models.EventType;
import project.models.User;
import project.service.dto.EventTypeDTO;
import project.service.dto.UserDTO;

/**
 * UserMapper
 */
public class EventTypeMapper {
    public static EventTypeDTO mapFrom(EventType eventType) {
        return new EventTypeDTO(eventType.getType_id(), eventType.getType_name(), eventType.getType_kind(),
                eventType.getEventTypeUsers(), eventType.getEventTypeEvents());
    }
}
