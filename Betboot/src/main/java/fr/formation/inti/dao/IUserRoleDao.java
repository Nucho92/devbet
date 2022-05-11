package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.UserRole;

@Repository
public interface IUserRoleDao extends JpaRepository<UserRole, Integer>, CrudRepository<UserRole, Integer> {

}
