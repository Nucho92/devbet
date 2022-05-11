package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.IWalletService;

@Controller
public class AccountController {

	@Autowired
	private IWalletService walletService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(path = "/myaccount")
	public String myaccount(Model model,@ModelAttribute("user") User user) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null || auth instanceof AnonymousAuthenticationToken) {
			model.addAttribute("user", user);
			return "myaccount";
		}

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("user", user);

		return "myaccount";
	}
	
	@RequestMapping(path = "/recharge" ,method = RequestMethod.POST)
	public String recharge(Model model, @ModelAttribute("user") User user, @RequestParam Float rechargeAmount) {
	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		Wallet newWallet = walletService.findWalletByUser(user);
		newWallet.setRechargeAmount(rechargeAmount);

		if(newWallet.getAvailBalance() == null) {
			newWallet.setAvailBalance((float) 0);
		}
		newWallet.setAvailBalance(newWallet.getAvailBalance() + rechargeAmount);
		walletService.save(newWallet);
		
		

		return "redirect:/myprofile";
	}
	
}
