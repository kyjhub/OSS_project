package Yongjun.Kwon.calender.repository;

import Yongjun.Kwon.calender.domain.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventRepository {
    @PersistenceContext
    private final EntityManager em;

    public void save(Event event) {
        em.persist(event);
    }

    public Event find(Long Id) {
        return em.find(Event.class, Id);
    }

    public List<Event> findAll() {
        return em.createQuery("select e from Event e", Event.class)
                .getResultList();
    }

    public void delete(Long EventId) {
        Event event = this.find(EventId);
        em.remove(event);
    }
}
