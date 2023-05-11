package dynamic.picture.gallery.entity;








import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gallery_data")
public class GalleryData {
	@Null
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@NonNull
	@NotBlank(message = "Name is required.")
	@Size(min = 1, max = 50, message = "Name must be between 1 and 50 letters.")
	@Column(name="gallery_name")
        //treba biti unique vezati ćemo na listu sa slikama
    private String gallery_name;
	@NonNull 
	@Column(name="size_of_gallery")
	private Integer size_of_gallery;
	//trebamo neku listu slika dodati ćemo to kasnije
	
	@Column(name="username")
    //treba biti unique vezati ćemo na listu sa slikama
    private String username;

	/*
	private Integer currentIndex;
	private Integer previousIndex;
	private Integer nextIndex;
	private Integer firstIndex;
	private Integer lastIndex;
	
	
	public Integer increaseIndex() {
		return this.currentIndex++;
	}
	public Integer decreaseIndex() {
		return this.currentIndex--;
	}
	public Integer returnFirstIndex() {
		return this.firstIndex=getFirstIndex();
	}
	public Integer returnLastIndex() {
		return this.lastIndex=getLastIndex();
	}
    public void rememberPreviousIndex(Integer currentIndex) {
    	this.previousIndex=currentIndex;
    }
    public void setCurrentIndex(Integer index){
    	this.currentIndex=index;
    }
    public void setNextIndex(Integer index) {
    	this.nextIndex=index;
    }*/
}
