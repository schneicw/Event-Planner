package dev.schneider.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.schneider.entities.Client;
import dev.schneider.entities.Event;

@Component
@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{
	List<Event> findByClient(Client client);
	Event findById(int id);
}
