package dynamic.picture.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/DynamicPictureGallery/")
public class HomePageController {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	@PostMapping("/")
	public String getLogin() {
		return "index";
	}
}
