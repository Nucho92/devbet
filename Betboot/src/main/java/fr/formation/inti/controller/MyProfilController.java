package fr.formation.inti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;
import fr.formation.inti.service.IPersonService;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.IWalletService;
import fr.formation.inti.util.FileUploadUtil;

@Controller
public class MyProfilController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IWalletService walletService;

	@Autowired
	private IPersonService personService;

	/*
	 * View mon profil
	 */
	@RequestMapping(path = { "/myprofile" })
	public String home(Model model,@ModelAttribute("user") User user) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		Wallet wallet = walletService.findWalletByUser(user);

		System.out.println("Wallet :" + wallet);

		wallet.getAvailBalance();

		model.addAttribute("availBalance",
				"Il te reste actuellement " + wallet.getAvailBalance() + " € sur ton compte ");
		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("firstName1", "Hello " + user.getPerson().getFirstName() + " !");
		model.addAttribute("user", user);

		return "monprofil";
	}

	/* 
	 * SAVE picture 
	 */
	@PostMapping("/uploadimj")
	public String saveImjUser(Model model, @ModelAttribute("user") User user,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		// récupération des infos du user 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		user = userService.findByMail(userDetails.getUsername());

		System.out.println(user);

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		user.setPicturePath(fileName);

		User savedUser = userService.save(user);

		String uploadDir = "./user-photos/" + savedUser.getUserId();

		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

		Wallet wallet = walletService.findWalletByUser(user);

		System.out.println("Wallet :" + wallet);

		wallet.getAvailBalance();

		model.addAttribute("availBalance",
				"Il te reste actuellement " + wallet.getAvailBalance() + "€ sur ton compte ");
		model.addAttribute("firstName", user.getPerson().getFirstName());
		model.addAttribute("firstName1", "Hello " + user.getPerson().getFirstName() + " !");
		model.addAttribute("user", user);

		return "monprofil";
	}

}
