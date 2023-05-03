package dynamic.picture.gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.functions.GeneralFunctions;

@Controller
@RequestMapping(path = "/DynamicPictureGallery/")
public class HomePageController {

	
	
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

}
