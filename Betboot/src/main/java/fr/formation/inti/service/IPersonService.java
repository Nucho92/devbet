package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.User;

public interface IPersonService {
	

	List<Person> listAll();
	
	void save(Person person);
	
	Person get(Integer id);
	
	void delete (Integer id);
	
	Person updateUser (Person person, Integer personId);


}
