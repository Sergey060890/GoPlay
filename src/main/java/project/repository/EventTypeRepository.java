package project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.EventType;


/**
 * Event Type Repository
 */
@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {

}
