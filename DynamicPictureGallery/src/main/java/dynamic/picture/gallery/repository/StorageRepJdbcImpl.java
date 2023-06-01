package dynamic.picture.gallery.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dynamic.picture.gallery.entity.Storage;
import lombok.NoArgsConstructor;


@Repository
@NoArgsConstructor
public class StorageRepJdbcImpl implements StorageRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StorageRepJdbcImpl(JdbcTemplate jdbc) {
		this.jdbcTemplate=jdbc;
	}

	@Override
	public Storage save(Storage storage) {
		jdbcTemplate.update(
				"insert into Storage_system (username,user_folder,file_name,file_extension, local_path, url,relative_link,gallery_name) values(?,?,?,?,?,?,?,?)",
				storage.getUsername(),storage.getUser_folder(),storage.getFile_name(),
				storage.getFile_extension(),storage.getLocal_path(),storage.getUrl(),storage.getRelative_link(),storage.getGallery_name()
				);
		return storage;
		
	}

	@Override
	public List<Storage> findByGalleryName(String galleryName) {

		return jdbcTemplate.query("select file_name,local_path,url,relative_link from Storage_system WHERE gallery_name=?", this::mapRowToStorage,galleryName);
	}
	private Storage mapRowToStorage(ResultSet rs, int rowNum) throws SQLException {
		return new Storage(rs.getString("file_name"),rs.getString("local_path"),rs.getString("url"),rs.getString("relative_link"));
	
	}

}
