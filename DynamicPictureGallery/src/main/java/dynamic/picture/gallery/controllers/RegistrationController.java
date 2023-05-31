package dynamic.picture.gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.GalleryData;
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
	
	@ModelAttribute(name = "User")
	public User getUser() {
		
	return new User();
	}
	
	@GetMapping
	public String registerForm() {
		
	return "register";
	}
	@PostMapping
	public String processRegistration(User form) {
	
	userRepo.save(form.toUser(passwordEncoder));
	Folder folder =new Folder();
	String user=dataRepository.findByEmailAddress(form.getEmail());//find username
	//System.out.println(user);
    folder.createFolder(user);
	
	return "redirect:/login";
	}
}
