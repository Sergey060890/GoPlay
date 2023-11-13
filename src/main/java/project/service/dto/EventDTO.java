package project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.models.EventType;
import project.models.User;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Set;

/**
 * Event DTO
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDTO implements Serializable {
    private Integer event_id;
    private String event_date;
    private String event_time_start;
    private String event_time_finish;
    private String country;
    private String city;
    private String place_name;
    private Integer number_people_fact;
    private Integer number_people_max;
    private String sex_type;
    private Integer age_min;
    private Integer age_max;
    private String level_game;
    private String event_comment;
    private EventType event_type;
    private User creator;
    private Set<User> eventUsersDTO;
}
