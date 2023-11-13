package project.service.interfaces;

import project.models.EventType;

import java.util.List;

public interface EventTypeService {

    /**
     * Create EventType (role Admin)
     */

    EventType createEventType(String typeName, String typeKind);

    /**
     * Update EventType (role Admin)
     */
    void updateEventType(Integer id, String typeName, String typeKind);

    /**
     * Print all EventType (role Admin,User)
     */
    Iterable<EventType> findAllEventType();

    /**
     * Find EventType by id (role Admin,User)
     */
    EventType findEventTypeById(Integer id);


    /**
     * Print all EventType by TypeName (role Admin,User)
     */

    List<String> findAllEventTypeByTypeName();

    /**
     * Print all EventType by TypeKind (role Admin,User)
     */

    List<String> findAllEventTypeByTypeKind();

    /**
     * Select Event Type "Type name" by id (role Admin,User)
     */
    Iterable<EventType> selectAllEventTypeName(String typeName);

    /**
     * Select Event Type "Type kind" by id (role Admin,User)
     */
    Iterable<EventType> selectAllEventTypeKind(String typeKind);

    /**
     * Delete EventType by id (role Admin)
     */
    void deleteEventTypeById(Integer id);

}
