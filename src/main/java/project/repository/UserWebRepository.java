package project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.User;

/**
 * UserWebRepository
 */
@Repository
public interface UserWebRepository extends JpaRepository<User, Integer> {

}
