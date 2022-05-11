package fr.formation.inti.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.User;
import fr.formation.inti.entities.UserRole;
import fr.formation.inti.entities.Wallet;
import fr.formation.inti.service.IPersonService;
import fr.formation.inti.service.IUserRoleService;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.IWalletService;

@Controller
public class InscriptionController {

	@Autowired
	private PasswordEncoder pwEncoder;

	@Autowired
	private IUserService userService;

	@Autowired
	private IPersonService personService;

	@Autowired
	private IUserRoleService userRoleService;

	@Autowired
	private IWalletService walletService;

	@RequestMapping(path = { "/new" })
	public String inscription(Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			model.addAttribute("user", user);
			return "index";
		} else {

			return "inscription";
		}

	}

	/*
	 * SAVE USER
	 */

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String saveUserandPerson(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasErrors()) {
			
			return "inscription";
		} else {

			personService.save(user.getPerson());
			String passEncoder = pwEncoder.encode(user.getPassword());
			user.setPassword(passEncoder);
			user.setConfirmPassword(passEncoder);

			userService.save(user);

			UserRole newUserRole = new UserRole();
			newUserRole.setRole("ROLE_USER");
			newUserRole.setUser(user);

			userRoleService.save(newUserRole);

			Wallet newWallet = new Wallet();
			newWallet.setUser(user);

			walletService.save(newWallet);
			
			model.addAttribute("firstName", user.getPerson().getFirstName());

			return "confirmation";
		}

	}


	

	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
	}

}
