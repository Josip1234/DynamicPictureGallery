/**
 * 
 */
package dynamic.picture.gallery.repository;

import java.util.List;

import dynamic.picture.gallery.entity.Storage;

/**
 * @author Korisnik
 *
 */
public interface StorageRepository  {
 Storage save(Storage storage);
 List<Storage> findByGalleryName(String galleryName);
}
