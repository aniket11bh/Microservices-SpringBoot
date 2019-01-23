package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableOAuth2Client
public class OAuthConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthConsumerApplication.class, args);
	}

	@Component
	@Order(value = 99)
	public static class LoginConfigurer extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/insert").authorizeRequests().anyRequest().authenticated().and().logout()
					.logoutUrl("/admin/logout").permitAll().logoutSuccessUrl("/index.html").permitAll();

		}
	}

}
