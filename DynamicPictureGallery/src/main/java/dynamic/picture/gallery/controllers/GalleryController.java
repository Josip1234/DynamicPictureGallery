package dynamic.picture.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import dynamic.picture.gallery.entity.GalleryData;
import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.functions.GeneralFunctions;
import dynamic.picture.gallery.repository.GalleryDataRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class GalleryController {
	private GalleryDataRepository dataRepository;
	
	@ModelAttribute(name = "galleryData")
	public GalleryData galleryData() {
	return new GalleryData();
	}
    
	@GetMapping("/galleryName")
	public String getGalleryNameForm() {
		return "galleryName";
	}
	
	@PostMapping("/galleryName")
	public String insertIntoGallery(@ModelAttribute("GalleryData") GalleryData data) {
		String email=GeneralFunctions.getUserEmail();
		String us= dataRepository.findByEmailAddress(email);
		data.setUsername(us);
		dataRepository.save(data);
		return "redirect:/uploadFile";
	}
	
	@GetMapping("/uploadFile")
	public String getUpload() {
		return "uploadFile";
	}
}
