package project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.models.Event;
import project.models.User;

import java.io.Serializable;
import java.util.Set;

/**
 * EventType DTO
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventTypeDTO implements Serializable {
    private Integer type_id;
    private String type_name;
    private String type_kind;
    private Set<User> eventTypeUsersDTO;
    private Set<Event> eventTypeEventsDTO;
}
