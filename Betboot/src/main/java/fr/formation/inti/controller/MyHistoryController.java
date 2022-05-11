package fr.formation.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.User;
import fr.formation.inti.service.IGamblingService;
import fr.formation.inti.service.IUserService;

@Controller
public class MyHistoryController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGamblingService gamblingService;
	
	@RequestMapping(path = "/myhistory")
	public String myHistory(Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);
			return "myhistory";
		}

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);

		List<Gambling> newGamblingList = gamblingService.findGambilngsByUser(user);
		
		model.addAttribute("glist",newGamblingList);
		
		return "myhistory";
	}

}
