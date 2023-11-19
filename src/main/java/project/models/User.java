package project.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class User
 */
@Getter
@Setter
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * User entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_surname")
    private String user_surname;

    @Column(name = "user_nickname")
    private String user_nickname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "age")
    private Integer age;

    @Column(name = "social")
    private String social;

    @Column(name = "about_me")
    private String about_me;

    /**
     * Connection with table "event_type" (user_event_type)
     */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_event_type",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")}
    )
    @ToString.Exclude
    @Builder.Default
    private Set<EventType> favorites = new HashSet<>();

    /**
     * Connection with table "event" (user_event_type)
     */
    @ManyToMany(mappedBy = "eventUsers")
    @ToString.Exclude
    @Builder.Default
    private Set<Event> userEvents = new HashSet<>();

    /**
     * Connection with table "event" (creator)
     */
    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private Set<Event> creatorEvents = new HashSet<>();


    /**
     * Connection with table "user-role"
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * Equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this)
                != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return user_id != null && Objects.equals(user_id, user.user_id);
    }

    /**
     * HashCode
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
