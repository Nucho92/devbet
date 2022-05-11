package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.User;
 
@Repository
public interface IUserDao extends CrudRepository<User, Integer>, JpaRepository<User, Integer> {

	// HQL
		@Query("from User where mail=:mail")
		User findByMail(String mail);
	
		@Query("select u from User u where u.userId=?1 ")
		User findUserByUserId(Integer userId);

		
}
