package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.EventType;
import project.models.User;
import project.repository.EventTypeRepository;
import project.repository.UserRepository;
import project.service.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    /**
     * Spring dependency injection autocomplete
     */

    @Autowired
    private UserRepository userRepository;

    /**
     * Create User (role User)
     */
    @Override
    public User createUser(String user_name, String user_surname, String user_nickname, String sex,
                           String country, String city, Integer age, String social, String about_me) {
        User user = User.builder()
                .user_name(user_name)
                .user_surname(user_surname)
                .user_nickname(user_nickname)
                .sex(sex)
                .country(country)
                .city(city)
                .age(age)
                .social(social)
                .about_me(about_me)
                .build();
        userRepository.save(user);
        return user;
    }

    /**
     * Update User (role User)
     */
    @Override
    public void updateUser(Integer id, String user_name, String user_surname, String user_nickname, String sex,
                           String country, String city, Integer age, String social, String about_me) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUser_name(user_name);
        user.setUser_surname(user_surname);
        user.setUser_nickname(user_nickname);
        user.setSex(sex);
        user.setCountry(country);
        user.setCity(city);
        user.setAge(age);
        user.setSocial(social);
        user.setAbout_me(about_me);
        userRepository.save(user);
    }

    /**
     * Print all User (role Admin)
     */
    @Override
    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    /**
     * Find User by id (role Admin,User)
     */
    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    /**
     * Delete User by id (role User,Admin)
     */
    @Override
    public void deleteUserById(Integer id) {
    User user = userRepository.findById(id).orElseThrow();
    userRepository.delete(user);
    }

    /**
     * Add favorites event type (role User)
     */
    @Override
    public void addUserEventTypes(Integer id, Set<EventType> eventTypes) {
        User user = userRepository.findById(id).orElseThrow();
        for (EventType p : eventTypes
        ) {
            user.getFavorites().add(p);
        }
        userRepository.save(user);
    }

    /**
     * Delete favorites event type (role User)
     */
    @Override
    public void deleteUserEventTypes(Integer id, Set<EventType> eventTypes) {
        User user = userRepository.findById(id).orElseThrow();
        Set<EventType> eventTypes1 = user.getFavorites();

        for (EventType p : eventTypes1
        ) {
            for (EventType p1 : eventTypes){
                if (Objects.equals(p.getType_id(), p1.getType_id())){
                    eventTypes1.remove(p);
                }
            }
        }
        userRepository.save(user);
    }
}
