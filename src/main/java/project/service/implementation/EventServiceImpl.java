package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.Event;
import project.models.EventType;
import project.models.User;
import project.repository.EventRepository;
import project.repository.UserRepository;
import project.service.interfaces.EventService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class EventServiceImpl implements EventService {
    /**
     * Spring dependency injection autocomplete
     */

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     * Create Event with add User (role User)
     */
    @Override
    public Event createEventWithAddUser(User creator, EventType event_type, String event_date,
                                        String event_time_start, String event_time_finish, String country,
                                        String city, String place_name, Integer number_people_fact, Integer number_people_max,
                                        String sex_type, Integer age_min, Integer age_max, String level_game,
                                        String event_comment) {
        Event event = Event.builder()
                .creator(creator)
                .event_type(event_type)
                .event_date(event_date)
                .event_time_start(event_time_start)
                .event_time_finish(event_time_finish)
                .country(country)
                .city(city)
                .place_name(place_name)
                .number_people_fact(number_people_fact)
                .number_people_max(number_people_max)
                .sex_type(sex_type)
                .age_min(age_min)
                .age_max(age_max)
                .level_game(level_game)
                .event_comment(event_comment)
                .build();
        eventRepository.save(event);
        return event;
    }

    /**
     * Check Creator (Auto)
     */
    @Override
    public boolean checkCreator(Integer event_id, Integer creator_id) {
        Event event = eventRepository.findById(event_id).orElseThrow();
        boolean check = false;
        if (Objects.equals(event.getCreator().getUser_id(), creator_id)){
            check = true;
        }
        return check;
    }

    /**
     * Update Event (role UserCreator)
     */
    @Override
    public void updateEventCreator(Integer id, EventType eventType, String event_date,
                                   String event_time_start, String event_time_finish, String country, String city,
                                   String place_name, Integer number_people_fact, Integer number_people_max, String sex_type,
                                   Integer age_min, Integer age_max, String level_game, String event_comment) {

        Event event = eventRepository.findById(id).orElseThrow();
        event.setEvent_type(eventType);
        event.setEvent_date(event_date);
        event.setEvent_time_start(event_time_start);
        event.setEvent_time_finish(event_time_finish);
        event.setCountry(country);
        event.setCity(city);
        event.setPlace_name(place_name);
        event.setNumber_people_fact(number_people_fact);
        event.setNumber_people_max(number_people_max);
        event.setSex_type(sex_type);
        event.setAge_min(age_min);
        event.setAge_max(age_max);
        event.setLevel_game(level_game);
        event.setEvent_comment(event_comment);
        eventRepository.save(event);
        
    }

    /**
     * Delete Event by id (role UserCreator,Admin)
     */
    @Override
    public void deleteEventById(Integer id, Integer user_id) {
    Event event = eventRepository.findById(id).orElseThrow();
    eventRepository.delete(event);
    }

    /**
     * Check User-Event(Auto)
     */
    @Override
    public boolean checkUserEvent(Integer event_id, Integer user_id) {
        Event event = eventRepository.findById(event_id).orElseThrow();
        boolean check = false;
        if (event.getEventUsers() != null) {
            for (User user : event.getEventUsers()
            ) {
                if (Objects.equals(user.getUser_id(), user_id)) {
                    check = true;
                }
            }
        }else {
            check = false;
        }
        return check;
    }

    /**
     * Update Event (role UserNoCreator)
     */
    @Override
    public void updateEventNoCreator(Integer id, String event_comment) {
        Event event = eventRepository.findById(id).orElseThrow();
        event.setEvent_comment(event_comment);
        eventRepository.save(event);
    }

    /**
     * Find Event by id (role Admin,User)
     */
    @Override
    public Event findEventById(Integer id) {
        return eventRepository.findById(id).orElseThrow();
    }

    /**
     * Print all Events (role Admin, User)
     */
    @Override
    public Iterable<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Print my all Events (role Admin, User)
     */
    @Override
    public Iterable<Event> findMyAllEvents(Integer user_id) {
        List<Event> eventListAll = eventRepository.findAll();
        List<Event> eventListMy = new ArrayList<>();
        for (Event p : eventListAll
        ) {
            for (User user:p.getEventUsers()
                 ) {
                if (Objects.equals(user.getUser_id(), user_id)){
                    eventListMy.add(p);
                }
            }
        }
        return null;
    }

    /**
     * Add User to Event by id (role User,Admin)
     */
    @Override
    public boolean addUserToEventById(Integer id, Integer user_id) {
        boolean check = false;
        Event event = eventRepository.findById(id).orElseThrow();
        for (User user : event.getEventUsers()
        ) {
            if (Objects.equals(user.getUser_id(), user_id)) {
                break;
            } else {
                event.getEventUsers().add(userRepository.findById(user_id).orElseThrow());
                eventRepository.save(event);
                check = true;
            }
        }

        return check;
    }

    /**
     * Delete User from Event by id (role User,Admin)
     */
    @Override
    public void deleteUserFromEventById(Integer id, Integer user_id) {
        Event event = eventRepository.findById(id).orElseThrow();
        event.getEventUsers().remove(userRepository.findById(user_id).orElseThrow());
        eventRepository.save(event);
    }

    /**
     * Print all Filter Events (role Admin, User)
     */
    @Override
    public Iterable<Event> findAllFilterEvents(Integer event_type_id, String event_date, String event_time_start,
                                               String event_time_finish, String country, String city, String place_name,
                                               String number_people_fact, String number_people_max, String sex_type,
                                               Integer age_min, Integer age_max, String level_game, String event_comment) {
        return null;
    }
}
