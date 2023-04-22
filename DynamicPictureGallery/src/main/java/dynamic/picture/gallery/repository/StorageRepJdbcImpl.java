package dynamic.picture.gallery.repository;

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
				"insert into Storage_system (nickname,user_folder,file_name,file_extension, local_path, url,type,relative_link) values(?,?,?,?,?,?,?,?,?,?)",
				storage.getNickname(),storage.getUser_folder(),storage.getFile_name(),
				storage.getFile_extension(),storage.getLocal_path(),storage.getUrl(),storage.getRelative_link()
				);
		return storage;
		
	}

}
