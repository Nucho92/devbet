package fr.formation.inti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Club;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;
import fr.formation.inti.entities.User;
import fr.formation.inti.model.Matchadapted;
import fr.formation.inti.service.IBetService;
import fr.formation.inti.service.IMatchService;
import fr.formation.inti.service.IUserService;

@Controller
public class RencontreController {

	@Autowired
	private IBetService betService;
	@Autowired
	private IMatchService matchService;

	@Autowired
	private IUserService userService;

	@RequestMapping(path = "rencontres")
	public String test(Model model, @RequestParam int betId) {

		Bet bet = betService.findByBetId(betId);
		List<Bet> listbet = betService.getAllBet();
		model.addAttribute("bet", bet);
		model.addAttribute("listbet", listbet);

		return "bet";
	}

	@RequestMapping(path = "testbet")
	public String testbet(Model model, @ModelAttribute("user") User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getPerson().getFirstName());

//		List<Bet> listbet= betService.getAllBet();
		Gambling gamb = new Gambling();

		List<Match> listmatch = matchService.getAllMatches();
		List<Matchadapted> listmatchadapted = new ArrayList<Matchadapted>();

		for (Match m : listmatch) {
			Matchadapted nucho= new Matchadapted();
			for (Bet b : m.getBets()) { 
				if(b.getClub()==null) {
					nucho.setCotedunull(b.getRating());
					nucho.setBetIdDrawn(b.getBetId());
				}else if(m.getClubByClubHome().getClubId() == b.getClub().getClubId()){
					nucho.setCotevictoryclubhome(b.getRating());
					nucho.setBetIdClubHome(b.getBetId());
				}else {
					nucho.setCotevictoryclubvisitor(b.getRating());
					nucho.setBetIdClubvisitor(b.getBetId());
				}
				nucho.setMatch(m);
			}
			listmatchadapted.add(nucho);

		}

		model.addAttribute("listmatch", listmatchadapted);
//	model.addAttribute("listmatch",listmatch); 
//	model.addAttribute("list",listmatchadapted);
		model.addAttribute("Gambling", gamb);
		return "parissportifs";

	}

}
