package dynamic.picture.gallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicPictureGalleryApplication {

	public static void main(String[] args) {
		  System.setProperty("server.servlet.context-path", "/DynamicPictureGallery");
		SpringApplication.run(DynamicPictureGalleryApplication.class, args);
	}

}
