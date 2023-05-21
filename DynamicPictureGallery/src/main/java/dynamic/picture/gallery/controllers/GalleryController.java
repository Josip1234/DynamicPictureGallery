package dynamic.picture.gallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import dynamic.picture.gallery.entity.GalleryData;
import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.functions.GeneralFunctions;
import dynamic.picture.gallery.repository.Folder;
import dynamic.picture.gallery.repository.GalleryDataRepository;
import dynamic.picture.gallery.repository.ImageStorage;
import dynamic.picture.gallery.repository.UserRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class GalleryController {
	private GalleryDataRepository dataRepository;
	
	private ImageStorage imageStorage;


	
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
		
		String email=GeneralFunctions.getUserName();
	
		//String us= dataRepository.findEmailFromUsername(email);
		//System.out.println(us);
		data.setUsername(email);
		
		dataRepository.save(data);
		//create folder object
		Folder firstPath = new Folder();
	    firstPath.setFolderName(data.getUsername());
	    String defaultPath=firstPath.getDefaultPath();
	    firstPath.setDefaultPath(defaultPath);
	    System.out.println(firstPath);
	    
	    Folder secondPath= new Folder(firstPath.getDefaultPath()+firstPath.getFolderName()+"/", data.getGallery_name());
	    secondPath.setDefaultPath(defaultPath+firstPath.getFolderName()+"/");
	    
		Folder create=new Folder();
		create.createFolder(secondPath);
		
		return "redirect:/uploadFile";
	}
	
	@GetMapping("/uploadFile")
	public String getUpload() {
		return "uploadFile";
	}
}
