package dynamic.picture.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dynamic.picture.gallery.entity.GalleryData;

@Controller
public class GalleryController {
	
	@ModelAttribute(name = "galleryData")
	public GalleryData galleryData() {
	return new GalleryData();
	}
    
	@GetMapping("/galleryName")
	public String getGalleryNameForm() {
		return "galleryName";
	}
	
	@GetMapping("/uploadFile")
	public String getUpload() {
		return "uploadFile";
	}
}
