package es.urjc.etsii.schoolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
		//publico
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		
		//privado
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/home").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/monitor").hasAnyRole("MONITOR");
		http.authorizeRequests().antMatchers("/padre").hasAnyRole("PADRE");
		http.authorizeRequests().antMatchers("/profesor").hasAnyRole("PROFESOR");
		//login
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("user");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/loginerror");
		
		//logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		//cosica a cambiar
		http.csrf().disable();
		
		
		// Database authentication provider
		 //auth.authenticationProvider(authenticationProvider);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		//usuarios por defecto
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("USER","ADMIN");
		
	}
}
