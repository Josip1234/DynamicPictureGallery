package dynamic.picture.gallery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	private String nickname;
	private String article_number;
	private String user_folder;
	private String article_folder;
	private String file_name;
	private String file_extension;
	private String local_path;
	private String url;
	private String relative_link;
	
}
