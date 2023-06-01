package dynamic.picture.gallery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dynamic.picture.gallery.repository.ImageStorageService;



@SpringBootApplication
public class DynamicPictureGalleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicPictureGalleryApplication.class, args);
	}
	@Bean
	CommandLineRunner init(ImageStorageService storageService) {
		return (args) -> {
			
			storageService.init();
		};
	}
}
