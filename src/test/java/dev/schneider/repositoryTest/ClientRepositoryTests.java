package dev.schneider.repositoryTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import dev.schneider.app.EventPlannerApplication;
import dev.schneider.entities.Client;
import dev.schneider.repositories.ClientRepository;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = EventPlannerApplication.class)
//@Transactional
class ClientRepositoryTests {

	@Autowired ClientRepository cr;
	
	@Order(1)
	@ParameterizedTest
	@CsvSource({"0,'tom','brom','tomuser','tommail','tompass'"})
	void saveClient(int clientId, String firstName, String lastName, String username, String email, String password) {
		Client client = new Client(clientId,firstName,lastName, username, email, password);
		Assertions.assertDoesNotThrow(()->{
			Client clientReturned= cr.save(client);
			System.out.println(clientReturned);
		});
	}
	
	@Order(2)
	@Test
	void getClientByEmail() {
//		List<Client> clients = cr.findByEmailAndPassword("tommail", "tompass");
		Assertions.assertDoesNotThrow(()->{
			Client client = cr.findByEmail("tommail");
//			Client client = cr.findById(30).get();
			System.out.println(client);
		});
	}
}
