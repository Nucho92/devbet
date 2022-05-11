package fr.formation.inti.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.Bet;
import fr.formation.inti.entities.Gambling;
import fr.formation.inti.entities.Match;
import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;
import fr.formation.inti.model.Matchadapted;
import fr.formation.inti.service.IBetService;
import fr.formation.inti.service.IGamblingService;
import fr.formation.inti.service.IMatchService;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.IWalletService;

@Controller
public class BetController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IBetService betService;
	@Autowired
	private IMatchService matchService;
	@Autowired
	private IGamblingService gamblingService;
	
	@Autowired
	private IWalletService walletService;

	@PostMapping("testpari")
	public String testbet(Model model, @RequestParam Float cote, @RequestParam Integer amount,
			@RequestParam Integer matchId ,@RequestParam Integer betId, @ModelAttribute("user") User user) {
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		User userAut = userService.findByMail(userDetails.getUsername());
		
		model.addAttribute("user", userAut);
		model.addAttribute("firstName", userAut.getPerson().getFirstName());
		
		//calcul du nombre de pari sur un match
		Match match =matchService.getMatchByMatchId(matchId);
		Bet betnbgambleradded=betService.findByBetId(betId);
		if (betnbgambleradded.getNbGambler()==null) {// s'assure qu'une celllule nulle soit rempli d'un 0 en vue de l'incrémenter vu qu'il est impossible d'incrémenter du null
			betnbgambleradded.setNbGambler(0);
		}
		betnbgambleradded.setNbGambler(betnbgambleradded.getNbGambler()+1);
		betService.SaveBet(betnbgambleradded);//enregistre le paris
		List<Bet> lisbet=betService.findBetsByMatch(match); //extrait tous les bet associé a un match

		
		float nbtotal=0;
		for (Bet bet : lisbet) {
			if(bet.getNbGambler()==null) {
				bet.setNbGambler(0);
			}
			nbtotal= nbtotal+bet.getNbGambler(); //sommme le nombre de paris sur toutes les issues d'un match
		}
	
		 
		if(betnbgambleradded.getClub()==null) {  //Si on pari sur un match nul
			float rating=(betnbgambleradded.getNbGambler())/nbtotal;
			betnbgambleradded.setRating(2-rating);
		} else { 
			Integer prestige =betnbgambleradded.getClub().getPrestige();
			float rating= (float) (((20-prestige)*(2.1-(betnbgambleradded.getNbGambler())/nbtotal))*0.8);
			betnbgambleradded.setRating(rating);
			}
		
		

		Date dt=new Date();
		Gambling gambling=new Gambling();
		gambling.setGamblingDate(dt);
		gambling.setAmount(amount);
		gambling.setGain(cote*amount);
		gambling.setBet(betnbgambleradded);
		gambling.setUser(userAut);

		
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
		
		//retirer argent parié
		Wallet newWallet = walletService.findWalletByUser(userAut);
		
		
		if(newWallet.getAvailBalance() == null || (newWallet.getAvailBalance() - amount) < 0) {
			
			model.addAttribute("user", userAut);
			model.addAttribute("firstName", userAut.getPerson().getFirstName());
			
			return "rechargement";
			
		}
		
		betService.SaveBet(betnbgambleradded);//enregistre le paris
		
		newWallet.setAvailBalance(newWallet.getAvailBalance() - amount);
		
		
		
		walletService.save(newWallet);
		
		
		gamblingService.SaveGambling(gambling); //enregistre le gambling
		System.out.println(gambling.getAmount());
		System.out.println(gambling.getGamblingDate());
		System.out.println(gambling.getGain());
		System.out.println(gambling.getUser());
		System.out.println(gambling.getBet());
	
		return "redirect:/testbet";
	}

}
