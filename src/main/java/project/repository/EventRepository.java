package project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.Event;
import project.models.User;

/**
 * Event Repository
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
