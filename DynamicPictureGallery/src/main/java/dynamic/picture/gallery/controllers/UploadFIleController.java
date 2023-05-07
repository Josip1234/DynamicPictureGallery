package dynamic.picture.gallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadFIleController {
    
	@GetMapping("/uploadFile")
	public String getUpload() {
		return "uploadFile";
	}
}
