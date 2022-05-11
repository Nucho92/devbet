package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.UserRole;

public interface IUserRoleService {
	

	List<UserRole> listAll();
	
	void save(UserRole userRole);
	
	UserRole get(Integer id);
	
	void delete (Integer id);

}
