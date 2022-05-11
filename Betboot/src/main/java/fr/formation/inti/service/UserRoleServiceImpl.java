package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IPersonDao;
import fr.formation.inti.dao.IUserRoleDao;
import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.UserRole;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

	@Autowired
	private IUserRoleDao userRoleDao;
	


	@Override
	public void save(UserRole userRole) {
		userRoleDao.save(userRole);
		
	}

	@Override
	public UserRole get(Integer id) {
		// TODO Auto-generated method stub
		return userRoleDao.findById(id).get();
	}

	@Override
	public List<UserRole> listAll() {
		// TODO Auto-generated method stub
		return userRoleDao.findAll();
	}

	@Override
	public void delete(Integer id) {
		userRoleDao.deleteById(id);
		
	}

}
