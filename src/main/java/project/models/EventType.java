package project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class EventType
 */
@Getter
@Setter
@Entity
@Table(name = "event_type")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventType implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * EventType entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer type_id;

    @Column(name = "type_name")
    private String type_name;

    @Column(name = "type_kind")
    private String type_kind;

    /**
     * Connection with table "user" (user_event_type)
     */
    @ManyToMany(mappedBy = "favorites")
    @ToString.Exclude
    @Builder.Default
    private Set<User> eventTypeUsers = new HashSet<>();

    /**
     * Connection with table "event"
     */
    @OneToMany(mappedBy = "event_type", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private Set<Event> eventTypeEvents = new HashSet<>();

    /**
     * Equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this)
                != Hibernate.getClass(o)) return false;
        EventType eventType = (EventType) o;
        return type_id != null && Objects.equals(type_id, eventType.type_id);
    }

    /**
     * HashCode
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
