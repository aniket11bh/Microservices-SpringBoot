package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	public void configureGlabal(AuthenticationManagerBuilder auth) throws Exception{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.passwordEncoder(encoder)
		.withUser("user1").password(encoder.encode("pass1")).roles("cadmin")
		.and().withUser("user2").password(encoder.encode("pass2")).roles("cuser").and()
		.withUser("user3").password(encoder.encode("pass3")).roles("cadmin","cuser")
		;
	}

	public  void configure(HttpSecurity http) throws Exception {
		
		
		http.authorizeRequests().antMatchers("/").permitAll()                  
				.antMatchers("/insert").hasRole("cadmin")                                      
				.antMatchers("/list").hasRole("cuser")            
			.and().httpBasic();
	}

}