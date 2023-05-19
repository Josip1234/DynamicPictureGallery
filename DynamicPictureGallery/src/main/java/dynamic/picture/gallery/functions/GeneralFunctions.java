package dynamic.picture.gallery.functions;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GeneralFunctions {
	

	public static String getFileExtension(String regExpression, String valueToReplace) {
		String value="";
		String regex=regExpression;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(valueToReplace);
		if(m.find()) {
			value=m.group(0);
			
		}
		return value;
	}
	


    /***
     * This function using security context holder and user details to get user email from logged in user.
     * @author Josip Bošnjak
     * @return email from logged in user
     */
	public static String getUserName() {
		String email="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  email=username;
		} else {
		  String username = principal.toString();
		  email=username;
		}
		return email;
	}


public static String replaceURL(String url) {
	String temp="";
	String temp2="";
	//Pattern pattern = Pattern.compile(".*/(.*)");
	Pattern pattern = Pattern.compile(".*/(.*)=(.*)");
	Matcher matcher = pattern.matcher(url);
	String complete="";
	if (matcher.find())
	{
	   
	    temp=matcher.group(1);
	    complete+=temp;
	    temp2=matcher.group(2);
	    complete+="-";
	    complete+=temp2;
	    //System.out.println(temp);
	    //System.out.println(temp2);
	}
	return complete;
}


}
