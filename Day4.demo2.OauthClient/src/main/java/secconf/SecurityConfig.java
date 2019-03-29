package secconf;



import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.antMatcher("/admin/**").authorizeRequests()
	.anyRequest().authenticated()
	.and()
	.logout().logoutUrl("/admin/logout").permitAll()
	.logoutSuccessUrl("/");

	}
  
}