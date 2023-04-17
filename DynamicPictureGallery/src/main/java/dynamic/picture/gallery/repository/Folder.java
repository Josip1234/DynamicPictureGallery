package dynamic.picture.gallery.repository;


import java.io.File;


import dynamic.picture.gallery.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class Folder implements CreateFolders {

   private boolean done;

   private String folderName;

   private File file;

   private String defaultPath="images/";

   private boolean doesExists;
  

   public Folder(String folderName) {
	   this.file=new File(defaultPath+folderName);
	   this.folderName=defaultPath+folderName;
   }

   public Folder(String path, String folderName) {
	   this.file=new File(path+folderName);
	   this.folderName=folderName;
   }
   

   public void setFolder(String nameOfFolder) {
	   this.folderName=nameOfFolder;
	   this.defaultPath="";
	   this.file=new File(this.folderName);
	   
   }
   

	public boolean createFolder(Object object) {
	
	   if(object instanceof User) {
	
		   User user = (User) object;
	
		   Folder folder=new Folder(user.getNickname());

		   setDone(makeDirectory(folder));
	   }
		
	
		return isDone();
	}
   

   public boolean makeDirectory(Folder folder) {

		if(doesFileExists(folder)) {
			setDone(false);
		}else {
		    setDone(folder.getFile().mkdir());
		  
		    if(isDone()) {
		    	setDone(true);
		    }else {
		    	setDone(false);
		    }
		}
       return isDone();
   }
 

	public boolean doesFileExists(Folder folder) {
		if(folder.getFile().exists()) {
			setDoesExists(true);
		}else {
			setDoesExists(false);
		}
		return isDoesExists();
	}

}
