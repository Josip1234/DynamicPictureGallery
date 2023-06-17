package dynamic.picture.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dynamic.picture.gallery.entity.Folder;
import dynamic.picture.gallery.entity.GalleryCategory;
import dynamic.picture.gallery.entity.GalleryData;
import dynamic.picture.gallery.functions.GeneralFunctions;
import dynamic.picture.gallery.repository.CategoryRepository;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CategoryController {
private CategoryRepository categoryRepository;

@ModelAttribute(name = "galleryCategory")
public GalleryCategory galleryCategory() {
	
return new GalleryCategory();
}

@GetMapping("/galleryCategory")
public String getCategoryForm() {
	return "galleryCategory";
}

@PostMapping("/galleryCategory")
public String insertIntoGalleryCategory(@ModelAttribute("galleryCategory") GalleryCategory data) {
	
    categoryRepository.save(data);
	
	return "redirect:/galleryName";
}


}
