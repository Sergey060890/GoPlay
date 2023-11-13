package project.service.interfaces;

import project.models.Event;

public interface EventService {

    /**
     * Create Event with add User (role User)
     */
    Event createEventWithAddUser(Integer creator_id, Integer event_type_id, String event_date, String event_time_start,
                                 String event_time_finish, String country, String city, String place_name,
                                 String number_people_fact, String number_people_max,
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
    void updateEventCreator(Integer id, Integer creator_id, Integer event_type_id, String event_date, String event_time_start,
                            String event_time_finish, String country, String city, String place_name,
                            String number_people_fact, String number_people_max,
                            String sex_type, Integer age_min, Integer age_max, String level_game, String event_comment
    );

    /**
     * Update Event (role UserNoCreator)
     */
    void updateEventNoCreator(Integer id, Integer user_id, String event_comment);

    /**
     * Find Event by id (role Admin,User)
     */
    Event findEventById(Integer id);

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
     * Delete User from Event by id (role User,Admin)
     */
    void deleteUserFromEventById(Integer id, Integer user_id);

    /**
     * Print all Filter Events (role Admin, User)
     */
    Iterable<Event> findAllFilterEvents(Integer event_type_id, String event_date, String event_time_start,
                                  String event_time_finish, String country, String city, String place_name,
                                  String number_people_fact, String number_people_max,
                                  String sex_type, Integer age_min, Integer age_max, String level_game, String event_comment);

}