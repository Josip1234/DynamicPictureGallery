package dynamic.picture.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dynamic.picture.gallery.entity.GalleryCategory;
import dynamic.picture.gallery.entity.GalleryData;

public interface CategoryRepository extends JpaRepository<GalleryCategory, Integer>  {

}
