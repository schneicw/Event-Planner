package dev.schneider.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.schneider.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{

//	List<Client> findByEmailAndPassword(String email, String password);
	Client findByEmail(String email);
}
