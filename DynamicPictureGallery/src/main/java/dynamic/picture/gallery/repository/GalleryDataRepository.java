package dynamic.picture.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dynamic.picture.gallery.entity.GalleryData;

public interface GalleryDataRepository extends JpaRepository<GalleryData, Integer> {

}
