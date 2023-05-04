package dynamic.picture.gallery.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.repository.UserRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserDetailServiceRep implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		System.out.println(user.getUsername());
	    if (user != null) {
	        return user;
	      }
		return user; 
	      
	      
	}

}
