package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IPersonDao;
import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.User;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonDao personDao;
	
	@Override
	public List<Person> listAll() {
	
		return personDao.findAll();
	}

	@Override
	public void save(Person person) {
		personDao.save(person);
		
	}

	@Override
	public Person get(Integer id) {
		
		return personDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		personDao.deleteById(id);
		
	}

	@Override
	public Person updateUser(Person person, Integer personId) {
		Person personDB = personDao.findById(personId).get();
		return personDao.save(personDB);
	}


}
