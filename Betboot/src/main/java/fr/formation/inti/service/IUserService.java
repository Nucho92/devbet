package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.User;

public interface IUserService {
	
	User findByMail(String mail);

	List<User> listAll();
	
	User save(User user);
	
	User get(Integer id);
	
	void delete (Integer id);
	
	User updateUser (User user, Integer userId);
	
	User findUserByUserId(Integer userId);


}
