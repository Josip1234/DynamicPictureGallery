package dynamic.picture.gallery.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
@RequestMapping("/DynamicPictureGallery")
public class LoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}


}
