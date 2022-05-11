package fr.formation.inti.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IUserDao;
import fr.formation.inti.entities.User;
import fr.formation.inti.entities.UserRole;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userInfo = this.userDao.findByMail(username);

		System.out.println("Found User: " + userInfo);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				userInfo.getMail(), userInfo.getPassword(), mapRolesToAuthorities(userInfo.getUserRoles()));

		return userDetails;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<UserRole> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public User findByMail(String mail) {
		// TODO Auto-generated method stub
		return userDao.findByMail(mail);
	}

	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User save(User user) {

		return userDao.save(user);

	}

	@Override
	public User get(Integer id) {

		return userDao.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		userDao.deleteById(id);

	}

	@Override
	public User updateUser(User user, Integer userId) {
		User userDB = userDao.findById(userId).get();

		if (Objects.nonNull(user.getMail()) && !"".equalsIgnoreCase(user.getMail())) {
			userDB.setMail(user.getMail());
		}

		if (Objects.nonNull(user.getPassword())
				&& !"".equalsIgnoreCase(user.getPassword())) {
			userDB.setPassword(user.getPassword());
		}

		if (Objects.nonNull(user.getConfirmPassword()) && !"".equalsIgnoreCase(user.getConfirmPassword())) {
			userDB.setConfirmPassword(user.getConfirmPassword());
		}

		return userDao.save(userDB);
	}

	@Override
	public User findUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(userId);
	}

}
