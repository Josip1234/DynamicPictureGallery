package dynamic.picture.gallery.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dynamic.picture.gallery.entity.Folder;
import dynamic.picture.gallery.entity.GalleryCategory;
import dynamic.picture.gallery.entity.GalleryData;
import dynamic.picture.gallery.entity.Storage;
import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.exceptions.StorageFileNotFoundException;
import dynamic.picture.gallery.functions.GeneralFunctions;
import dynamic.picture.gallery.repository.CategoryRepository;
import dynamic.picture.gallery.repository.GalleryDataRepository;
import dynamic.picture.gallery.repository.StorageRepository;
import dynamic.picture.gallery.repository.UserRepository;
import dynamic.picture.gallery.services.ImageStorage;
import dynamic.picture.gallery.services.ImageStorageService;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class GalleryController {
	private GalleryDataRepository dataRepository;
	
	private StorageRepository repository;
	private final ImageStorageService imageStorageService;
	private final CategoryRepository categoryRepository;


	
	@ModelAttribute(name = "galleryData")
	public GalleryData galleryData() {
		
	return new GalleryData();
	}
    
	@GetMapping("/galleryName")
	public String getGalleryNameForm(Model model) {
		List<GalleryCategory> categories = new ArrayList<GalleryCategory>();
		categories=categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "galleryName";
	}
	

	
	@GetMapping("/findGalleries/galleryPreview")
	public String GalleryPreview(@CookieValue(value="gallery_name", required = true) String gallery_name,@CookieValue(value="gallery_type", required = false) String gallery_type,Model model) {
		System.out.println(gallery_type);
		
		boolean isNull = (gallery_type == null || gallery_type.length() == 0);
		
		if(isNull==true) {
			gallery_type="slideshow";
		}
        List<Storage> getListOfImages = repository.findByGalleryName(gallery_name);
        model.addAttribute("images",getListOfImages);
        model.addAttribute("type",gallery_type);
		return "galleryPreview";
	}

	
	@GetMapping("/findGalleries")
	public String getListOfAllGalleries(Model model) {
		List<GalleryData> data = dataRepository.findAll();
		model.addAttribute("galleryData",data);
		return "findGalleries";
	}
	
	@PostMapping("/galleryName")
	public String insertIntoGallery(@ModelAttribute("GalleryData") GalleryData data) {
		
		//this will fix folders to not call exception when user eneters spacing between gallery name
		String galleryName=data.getGallery_name();
		data.setGallery_name(galleryName.replace(' ', '_'));
		System.out.println("Name"+data.getGallery_name());
		
		Cookie cookie = new Cookie("gallery_name",data.getGallery_name());
	   //System.out.println(cookie.getValue());
		
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
	    //System.out.println(firstPath);
	    
	    Folder secondPath= new Folder(firstPath.getDefaultPath()+firstPath.getFolderName()+"/", data.getGallery_name());
	    secondPath.setDefaultPath(defaultPath+firstPath.getFolderName()+"/");
	    
		Folder create=new Folder();
		create.createFolder(secondPath);
	
		return "redirect:/uploadFile";
	}
	
	
	/***
	 * @author Josip Bošnjak
	 * @return form for uploading images of products
	 *we need to get coockies here see file:///C:/Users/Korisnik/Desktop/Tutorials/docs/spring%205/java%20-%20get%20cookie%20value%20by%20name%20in%20spring%20mvc%20-%20Stack%20Overflow.html
	 */
	@GetMapping("/uploadFile")
	public String getUploadForm(@CookieValue(value="gallery_name", required = false) String gallery_name,Model model) throws IOException {
		 System.out.println(gallery_name);
		String user=GeneralFunctions.getUserName();
		if(user!="anonymousUser") {
			
		
		//log.info(article_number);
		model.addAttribute("files", imageStorageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(GalleryController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadFile";
		}else {
			return "redirect:/";
		}
		
	}


	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = imageStorageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/uploadFile")
	public String handleFileUpload(@CookieValue(value="gallery_name", required = false) String gallery_name, @RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		 //we will save here everything from url article number nickname user folder article folder file name file extension local path url and type of file.
	     //log.info("success");
	      String user=GeneralFunctions.getUserName();
	      System.out.println(gallery_name);

		imageStorageService.storeFile(user,gallery_name,file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
	    //if user want to input more files we need to ask it overhere when button is executed then redirect first on get where upload 
		//form is then we can finally redirect to insert advanced details.
		return "redirect:uploadFile";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		//log.info("success");
		return ResponseEntity.notFound().build();
	}
	

}
