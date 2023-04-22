package dynamic.picture.gallery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
private String nickname;
private String password;
private String email;
}
