package fr.formation.inti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entities.User;
import fr.formation.inti.service.IPersonService;
import fr.formation.inti.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IPersonService personService;

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(path = "/login")
	public String login(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			return "redirect:/testbet";
		}

	
		return "login";

	}

	/*
	 * Message d'erreur LOGIN
	 */
	@GetMapping("/login-error")
	public String login(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		String errorMessage = "L'adresse mail ou le mot de passe est incorrect";
		if (session != null) {
			AuthenticationException ex = (AuthenticationException) session
					.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//			if (ex != null) {
//				errorMessage = ex.getMessage();
//			}
		}

		model.addAttribute("errorMessage", errorMessage);
		return "login";
	}

	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String authentif(Model model, @ModelAttribute("user") User user) {

		if (user != null) {
			model.addAttribute("user", user);
			model.addAttribute("password", user.getPassword());
			model.addAttribute("firstName", user.getPerson().getFirstName());

			return "parissportifs";
		} else {
			model.addAttribute("error", "login ou mot de passe incorrect");
			return "login";
		}
	}

	/*
	 * View Paris sportifs
	 */
	@RequestMapping(path = "/parissportifs")
	public String welcome(Model model,@ModelAttribute("user") User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		user = userService.findByMail(userDetails.getUsername());
		
		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getPerson().getFirstName());


		return "parissportifs";

	}

}
