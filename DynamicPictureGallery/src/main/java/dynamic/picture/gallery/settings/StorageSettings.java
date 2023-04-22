package dynamic.picture.gallery.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@ConfigurationProperties("storage")
public class StorageSettings {
private String location="images";

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

}
