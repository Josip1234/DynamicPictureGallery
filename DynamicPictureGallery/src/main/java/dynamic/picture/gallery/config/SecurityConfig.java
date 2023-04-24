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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;

	 private final String authenticateSQL = "SELECT USERNAME as user_name, PASSWORD as user_pwd, ACCOUNT_ENABLED as user_enabled FROM USERS WHERE USERNAME = ?";
	    private final String authorizeSQL = "SELECT USERNAME as user_name, ROLE as user_role FROM USERSROLES WHERE USERNAME = ?";
	    
	 


	 @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }
}
