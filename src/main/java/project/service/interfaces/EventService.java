package project.service.interfaces;

import project.models.Event;
import project.models.EventType;
import project.models.User;

public interface EventService {

    /**
     * Create Event with add User (role User)
     */
    Event createEventWithAddUser(User creator, EventType eventType, String event_date, String event_time_start,
                                 String event_time_finish, String country, String city, String place_name,
                                 Integer number_people_fact, Integer number_people_max,
                                 String sex_type, Integer age_min, Integer age_max, String level_game, String event_comment
    );

//    /**
//     * Create Event without add User (role User)
//     */
//    Event createEventWithOutAddUser(Integer creator_id, Integer event_type_id, String event_date, String event_time_start,
//                                 String event_time_finish, String country, String city, String place_name,
//                                 String number_people_fact, String number_people_max,
//                                 String sex_type, Integer age_min, Integer age_max, String level_game, String event_comment
//    );

    /**
     * Update Event (role UserCreator)
     */
    void updateEventCreator(Integer id, EventType eventType, String event_date, String event_time_start,
                            String event_time_finish, String country, String city, String place_name,
                            Integer number_people_fact, Integer number_people_max,
                            String sex_type, Integer age_min, Integer age_max, String level_game, String event_comment
    );

    /**
     * Update Event (role UserNoCreator)
     */
    void updateEventNoCreator(Integer id, String event_comment);

    /**
     * Find Event by id (role Admin,User)
     */
    Event findEventById(Integer id);

    /**
     * Check Creator (Auto)
     */
    boolean checkCreator(Integer event_id, Integer creator_id);

    /**
     * Check User-Event(Auto)
     */
    boolean checkUserEvent(Integer event_id, Integer user_id);

    /**
     * Delete Event by id (role UserCreator,Admin)
     */
    void deleteEventById(Integer id, Integer user_id);

    /**
     * Print all Events (role Admin, User)
     */
    Iterable<Event> findAllEvents();

    /**
     * Print my all Events (role Admin, User)
     */
    Iterable<Event> findMyAllEvents(Integer user_id);

    /**
     * Check UserAddEvent(Auto)
     */
    boolean checkUserAddEvent(Integer event_id, Integer user_id);

    /**
     * Add User to Event by id (role User,Admin)
     */
    void addUserToEventById(Integer id, Integer user_id);

    /**
     * Delete User from Event by id (role User,Admin)
     */
    void deleteUserFromEventById(Integer id, Integer user_id);

    /**
     * Print all Filter Events (role Admin, User)
     */
    Iterable<Event> findAllFilterEvents(Integer event_type_id, String event_date, String event_time_start,
                                        String event_time_finish, String country, String city, String place_name,
                                        String number_people_fact, String number_people_max,
                                        String sex_type, Integer age_min, Integer age_max, String level_game,
                                        String event_comment);

}
