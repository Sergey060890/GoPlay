package project.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.models.EventType;
import project.repository.EventTypeRepository;
import project.service.interfaces.EventTypeService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EventTypeServiceImpl implements EventTypeService {

    /**
     * Spring dependency injection autocomplete
     */

    @Autowired
    private EventTypeRepository eventTypeRepository;


    /**
     * Create Event Type (role Admin)
     */
    @Override
    public EventType createEventType(String typeName, String typeKind) {
        EventType eventType = EventType.builder()
                .type_name(typeName)
                .type_kind(typeKind)
                .build();
        eventTypeRepository.save(eventType);
        return eventType;
    }

    /**
     * Update EventType (role Admin)
     */
    @Override
    public void updateEventType(Integer id, String typeName, String typeKind) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        eventType.setType_name(typeName);
        eventType.setType_kind(typeKind);
        eventTypeRepository.save(eventType);
    }

    /**
     * Print all EventType (role Admin,User)
     */
    @Override
    public Iterable<EventType> findAllEventType() {
        return eventTypeRepository.findAll();
    }

    /**
     * Find EventType by id (role Admin,User)
     */
    @Override
    public EventType findEventTypeById(Integer id) {
        return eventTypeRepository.findById(id).orElseThrow();
    }

    /**
     * Print all EventType by TypeName (role Admin,User)
     */
    @Override
    public List<String> findAllEventTypeByTypeName() {
        List<String> stringsTypeName = new ArrayList<>();
        for (EventType p : eventTypeRepository.findAll()
        ) {
            stringsTypeName.add(p.getType_name());
        }
        return stringsTypeName;
    }

    /**
     * Print all EventType by TypeKind (role Admin,User)
     */
    @Override
    public List<String> findAllEventTypeByTypeKind() {
        List<String> stringsTypeKind = new ArrayList<>();
        for (EventType p : eventTypeRepository.findAll()
        ) {
            stringsTypeKind.add(p.getType_kind());
        }
        return stringsTypeKind;
    }

    /**
     * Select Event Type "Type name" by id (role Admin,User)
     */
    @Override
    public Iterable<EventType> selectAllEventTypeName(String typeName) {
        List<EventType> listTypeNameSelect = new ArrayList<>();
        for (EventType p : eventTypeRepository.findAll()
        ) {
            if (Objects.equals(p.getType_name(), typeName)) {
                listTypeNameSelect.add(p);
            }
        }
        return listTypeNameSelect;
    }

    /**
     * Select Event Type "Type kind" by id (role Admin,User)
     */
    @Override
    public Iterable<EventType> selectAllEventTypeKind(String typeKind) {
        List<EventType> listTypeKindSelect = new ArrayList<>();
        for (EventType p : eventTypeRepository.findAll()
        ) {
            if (Objects.equals(p.getType_kind(), typeKind)) {
                listTypeKindSelect.add(p);
            }
        }
        return listTypeKindSelect;
    }

    /**
     * Delete EventType by id (role Admin)
     */
    @Override
    public void deleteEventTypeById(Integer id) {
        EventType eventType = eventTypeRepository.findById(id).orElseThrow();
        eventTypeRepository.delete(eventType);
    }
}
