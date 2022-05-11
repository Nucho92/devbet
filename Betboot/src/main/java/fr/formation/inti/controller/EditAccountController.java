package fr.formation.inti.controller;

import java.sql.Date;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Person;
import fr.formation.inti.entities.User;
import fr.formation.inti.service.IPersonService;
import fr.formation.inti.service.IUserService;

@Controller
public class EditAccountController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IPersonService personService;

	@RequestMapping(path = "/editaccount")
	public String myAccount(Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);
			return "myinfos";
		}

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);

		return "myinfos";
	}

	@RequestMapping(path = "/editaccount", method = RequestMethod.POST)
	public String editMyAccount(Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);
			return "editmyinfos";
		}

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);

		return "editmyinfos";
	}

	@PostMapping(path = "/saveinfo/{id}")
	public String saveEditUser(Model model, @ModelAttribute("user") User user, BindingResult result,
			@PathVariable("id") Integer userId) {

		if (result.hasErrors()) {

			return "editmyinfos";
		} else {
			
			

			personService.updateUser(user.getPerson(), user.getPerson().getPersonId());
			userService.save(user);

			model.addAttribute("firstName", user.getPerson().getFirstName());
			model.addAttribute("user", user);

			return "redirect:/editaccount";
		}

	}
}
