package dynamic.picture.gallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dynamic.picture.gallery.entity.GalleryData;
import dynamic.picture.gallery.entity.User;

public interface GalleryDataRepository extends JpaRepository<GalleryData, Integer> {
	  @Query(value = "SELECT username FROM USER WHERE EMAIL = ?", nativeQuery = true)
	  String findByEmailAddress(String emailAddress);
	  @Query(value = "SELECT email FROM USER WHERE username = ?", nativeQuery = true)
	  String findEmailFromUsername(String username);
	  @Query(value = "SELECT * FROM Gallery_data WHERE username=?", nativeQuery = true)
	  List<GalleryData> findGalleryData(String username);



}
