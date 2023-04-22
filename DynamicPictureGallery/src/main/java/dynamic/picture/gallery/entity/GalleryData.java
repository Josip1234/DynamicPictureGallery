package dynamic.picture.gallery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GalleryData {
	@NonNull
	private String nickname;
	@NonNull //treba biti unique vezati ćemo na listu sa slikama
    private String galleryName;
	@NonNull 
	private Integer sizeOfGallery;
	//trebamo neku listu slika dodati ćemo to kasnije
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
    }
}
