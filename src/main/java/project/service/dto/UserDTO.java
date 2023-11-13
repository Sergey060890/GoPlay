package project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.models.Event;
import project.models.EventType;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User DTO
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements Serializable {
    private Integer user_id;
    private String user_name;
    private String user_surname;
    private String user_nickname;
    private String sex;
    private String country;
    private String city;
    private Integer age;
    private String social;
    private String about_me;
    private Set<EventType> favoritesDTO;
    private Set<Event> userEventsDTO;
    private Set<Event> creatorEventsDTO;
}
