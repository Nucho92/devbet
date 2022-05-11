package fr.formation.inti.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Results;
import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;
import fr.formation.inti.service.IBetService;
import fr.formation.inti.service.IClubService;
import fr.formation.inti.service.IGamblingService;
import fr.formation.inti.service.IMatchService;
import fr.formation.inti.service.IResultsService;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.IWalletService;

@Controller
public class ResultatsController {

	@Autowired
	private IMatchService matchService;

	@Autowired
	private IResultsService resultsService;

	@Autowired
	private IClubService clubService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBetService betService;

	@Autowired
	private IGamblingService gamblingService;
	
	@Autowired
	private IWalletService walletService;
	
	
	@GetMapping("/resultats")
	public String viewMatch(Model model, @ModelAttribute("user") User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getPerson().getFirstName());
		return findPaginated(10, model, user);
	}
	

        
	@GetMapping("/resultats{pageNo}")
	public String findPaginated(@PathVariable (value="pageNo") int pageNo, Model model, @ModelAttribute("user") User user) {
		

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getPerson().getFirstName());
		
		int pageSize = 5;
		
		Page<Results> page = resultsService.findPaginated(pageNo, pageSize);
		List<Results> res=page.getContent();
		List<Club> tabclubs = clubService.getAllClubs();
        model.addAttribute("tabclubs", tabclubs);       
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("res", res);
		
		
		return "resultats";
		
	}


	

	@GetMapping(path = "/resultatsUpdateForm{resultId}")
	public String showFormForUpdate(@PathVariable(value = "resultId") Integer resultId, Model model, @ModelAttribute("user") User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getPerson().getFirstName());
		
		// get match from the service
		Results result = resultsService.getResultsByResultsId(resultId);

		// set match as a model attribute to pre-populate the form

		model.addAttribute("result", result);
		return "resultatsEdit";

	}

	@PostMapping("/resultats/saveResults")
	public String saveResults(@ModelAttribute("result") Results result, Model model) {
		resultsService.saveResults(result);
		
		Bet newBet = betService.getBetbyClubandMatch(result.getClubByVictoryId(), result.getMatch());
		
		List<Gambling> newGamblingList = gamblingService.findGambilngsByBet(newBet);
		
		
		
		for (Gambling g : newGamblingList) {
			Wallet newWallet = walletService.findWalletByUser(g.getUser());
			newWallet.setAvailBalance(newWallet.getAvailBalance() + g.getGain());
			walletService.save(newWallet);
		}
		
		return "redirect:/resultats";

	}

}
