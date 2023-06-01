package dynamic.picture.gallery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Storage {
	private String username;
	private String user_folder;
	@NonNull
	private String file_name;
	private String file_extension;
	@NonNull
	private String local_path;
	@NonNull
	private String url;
	@NonNull
	private String relative_link;
	private String gallery_name;
	
}
