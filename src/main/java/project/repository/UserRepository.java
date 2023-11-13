package project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.User;

/**
 * User Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
