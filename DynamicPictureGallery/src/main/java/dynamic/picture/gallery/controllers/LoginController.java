package dynamic.picture.gallery.controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import dynamic.picture.gallery.functions.GeneralFunctions;

@Controller
public class LoginController {
	
	
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String getSuccess(@RequestParam String username, @RequestParam String password) {
		System.out.println(username+password);
		System.out.println(GeneralFunctions.getUserEmail());
		return "index";
	}

}
