package dynamic.picture.gallery.repository;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**ž
 * Will be used as storage service to store images depending on user folder and product number folder.
 * 
 * @author Korisnik
 * @version 1. 0
 * 
 *
 */
public interface ImageStorageService {
	void init();
   public void storeFile(String nickname,String galleryName,MultipartFile fileName);
   Stream<Path> loadAll();
   Path load(String fileName);
   Resource loadAsResource(String fileName);
}
