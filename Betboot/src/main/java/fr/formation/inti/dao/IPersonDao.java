package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.User;

@Repository
public interface IPersonDao extends JpaRepository<Person, Integer>, CrudRepository<Person, Integer>{
	


}
