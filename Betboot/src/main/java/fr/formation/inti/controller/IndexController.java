package fr.formation.inti.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Match;
import fr.formation.inti.entities.User;
import fr.formation.inti.model.Matchadapted;
import fr.formation.inti.service.IMatchService;
import fr.formation.inti.service.IUserService;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IMatchService matchService;

	@RequestMapping(path = { "/", "/index" })
	public String home(Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);

			List<Match> listmatch = matchService.getAllMatches();

			Date dt = new Date();

			for (int i = 0; i < listmatch.size(); i++) {

				if (listmatch.get(i).getDate().before(dt) && listmatch.get(i + 1).getDate().after(dt)) {
					model.addAttribute("match", listmatch.get(i + 1));
					return "index";
				}
			}
		}

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);

		List<Match> listmatch1 = matchService.getAllMatches();

		Date dt1 = new Date();

		for (int i = 0; i < listmatch1.size(); i++) {

			if (listmatch1.get(i).getDate().before(dt1) && listmatch1.get(i + 1).getDate().after(dt1)) {
				model.addAttribute("match", listmatch1.get(i + 1));
				return "index";
			}

		}
		return "index";

	}
}
