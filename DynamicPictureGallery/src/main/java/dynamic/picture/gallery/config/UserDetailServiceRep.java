package dynamic.picture.gallery.config;


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
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
	    if (user != null) {
	        return user;
	      }
	      throw new UsernameNotFoundException(
	                      "User '" + username + "' not found");
	}

}
