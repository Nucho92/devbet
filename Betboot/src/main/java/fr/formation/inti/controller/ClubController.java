package fr.formation.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Match;
import fr.formation.inti.entities.Results;
import fr.formation.inti.entities.User;
import fr.formation.inti.service.IClubService;
import fr.formation.inti.service.IMatchService;
import fr.formation.inti.service.IResultsService;
import fr.formation.inti.service.IUserService;

@Controller
public class ClubController {

	@Autowired
	private IClubService clubService;
	
	@Autowired
	private IUserService userService;

	@GetMapping("/classement")
	public String viewClassement(Model model, @ModelAttribute("user") User user) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);
			return findPaginated(1, "points", "desc", model, user);
		}
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);
			
		
		return findPaginated(1, "points", "desc", model, user);
	}

	@GetMapping("/classement{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model, @ModelAttribute("user") User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			int pageSize = 10;
			Page<Club> page = clubService.findPaginated(pageNo, pageSize, sortField, sortDir);
			List<Club> classement = page.getContent();

			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());

			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

			model.addAttribute("classement", classement);
			model.addAttribute("user", user);
			return "classement";
		}
			
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);
		
		int pageSize = 10;
		Page<Club> page = clubService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Club> classement = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("classement", classement);

		return "classement";

	}

}
