package dev.schneider.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import dev.schneider.app.EventPlannerApplication;
import dev.schneider.entities.Client;
import dev.schneider.entities.Event;
import dev.schneider.repositories.ClientRepository;
import dev.schneider.repositories.EventRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = EventPlannerApplication.class)
@Transactional
class EventRepositoryTests {

	@Autowired EventRepository er;
	@Autowired ClientRepository cr;

	
	@Test
	@Order(1)
	@Rollback
	void saveEvent() {
		Client client = new Client(0,"tom","brom","tomuser","tommail","tompass");
		Client addedClient = cr.save(client);
		Event event = new Event(0, "Parade", client);
		Assertions.assertDoesNotThrow(()->{
			Event eventReturned = er.save(event);
			System.out.println(eventReturned);
		});
	}
	
	@Test
	@Order(1)
	void getEventById() {
		
	}

}
