package project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class Event
 */
@Getter
@Setter
@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Event entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer event_id;

    @Column(name = "event_date")
    private String event_date;

    @Column(name = "event_time_start")
    private String event_time_start;

    @Column(name = "event_time_finish")
    private String event_time_finish;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "place_name")
    private String place_name;

    @Column(name = "number_people_fact")
    private Integer number_people_fact;

    @Column(name = "number_people_max")
    private Integer number_people_max;

    @Column(name = "sex_type")
    private String sex_type;

    @Column(name = "age_min")
    private Integer age_min;

    @Column(name = "age_max")
    private Integer age_max;

    @Column(name = "level_game")
    private String level_game;

    @Column(name = "event_comment")
    private String event_comment;

    /**
     * Connection with table "event_type"
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_type_id")
    private EventType event_type;

    /**
     * Connection with table "user" (creator)
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "creator_id")
    private User creator;


    /**
     * Connection with table "user" (event_user)
     */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "event_user",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    @ToString.Exclude
    @Builder.Default
    private Set<User> eventUsers = new HashSet<>();

    /**
     * Equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this)
                != Hibernate.getClass(o)) return false;
        Event event = (Event) o;
        return event_id != null && Objects.equals(event_id, event.event_id);
    }

    /**
     * HashCode
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
