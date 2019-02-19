package com.nareshit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.domain.UserProfile;

@Controller
@RequestMapping("/user")
public class ManageUserController {

	@RequestMapping("/doLogin")
	public String getLoginPage(Model model) {
		model.addAttribute("user", new UserProfile());
		return "login";
	}
	
	@RequestMapping("/login")
	public String getLoggedIn(@ModelAttribute("user") UserProfile up) {
		System.out.println("user name is:\t"+up.getEmail());
		System.out.println("password is:\t"+up.getPassword());
		
		if(up.getEmail() != null && up.getPassword() != null) {
			return "superAdminBoard";
		}
		return "login";
	}
	
}
