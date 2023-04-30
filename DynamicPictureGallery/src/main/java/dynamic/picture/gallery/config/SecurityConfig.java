package dynamic.picture.gallery.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import dynamic.picture.gallery.entity.User;
import dynamic.picture.gallery.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	return http.authorizeHttpRequests().requestMatchers("/DynamicPictureGallery/register","/DynamicPictureGallery/login").permitAll() 
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.usernameParameter("user")
			.passwordParameter("pwd")
			.defaultSuccessUrl("/uploadFile")
			.and().build();
	}

	 @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
}
