package dynamic.picture.gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.functions.GeneralFunctions;
import dynamic.picture.gallery.repository.Folder;
import dynamic.picture.gallery.repository.GalleryDataRepository;
import dynamic.picture.gallery.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {
	@NonNull
	private UserRepository userRepo;
	@NonNull
	private PasswordEncoder passwordEncoder;
	
	@NonNull 
	private GalleryDataRepository dataRepository;
	
	@GetMapping
	public String registerForm() {
	return "register";
	}
	@PostMapping
	public String processRegistration(User form) {
	
	userRepo.save(form.toUser(passwordEncoder));
	Folder folder =new Folder();
	String user=GeneralFunctions.getUserEmail();//find username
     System.out.println(folder.createFolder("iggoblih"));
	
	return "redirect:/login";
	}
}
