package dynamic.picture.gallery.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.User;
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

	@GetMapping
	public String registerForm() {
	return "register";
	}
	@PostMapping
	public String processRegistration(User form) {
	userRepo.save(form.toUser(passwordEncoder));
	return "redirect:/DynamicPictureGallery/login";
	}
}
