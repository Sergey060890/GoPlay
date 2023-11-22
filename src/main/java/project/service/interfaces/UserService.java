package project.service.interfaces;

import project.models.EventType;
import project.models.User;

import java.util.Set;


public interface UserService {

    /**
     * Create User (role User)
     */
    User createUser(String user_name, String user_surname,
                    String sex, String country, String city,
                    Integer age);

    /**
     * Update User (role User)
     */
    void updateUser(Integer id, String user_name, String user_surname, String user_nickname,
                    String sex, String country, String city,
                    Integer age, String social, String about_me);

    /**
     * Print all User (role Admin)
     */
    Iterable<User> findAllUser();

    /**
     * Find User by id (role Admin,User)
     */
    User findUserById(Integer id);

    /**
     * Find User by user_name (role Admin,User)
     */
    User findUserByName(String userName);

    /**
     * Delete User by id (role User,Admin)
     */
    void deleteUserById(Integer id);

    /**
     * Add favorites event type (role User)
     */
    void addUserEventTypes(Integer id, Set<EventType> eventTypes);

    /**
     * Delete favorites event type (role User)
     */
    void deleteUserEventTypes(Integer id, Set<EventType> eventTypes);


}
