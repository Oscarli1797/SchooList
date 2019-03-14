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
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/mlogout").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		http.authorizeRequests().antMatchers("/css/**").permitAll();
		http.authorizeRequests().antMatchers("/img/**").permitAll();
		http.authorizeRequests().antMatchers("/js/**").permitAll();
		http.authorizeRequests().antMatchers("/less/**").permitAll();
		http.authorizeRequests().antMatchers("/mail/**").permitAll();
		http.authorizeRequests().antMatchers("/vendor/**").permitAll();

		
		//privado
		http.authorizeRequests().anyRequest().authenticated();
		
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("Admin");
		http.authorizeRequests().antMatchers("/monitor").hasAnyRole("MONITOR");
		http.authorizeRequests().antMatchers("/padre").hasAnyRole("Padre");
		http.authorizeRequests().antMatchers("/profesor").hasAnyRole("Profesor");
		
		
		//login
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("uname");
		http.formLogin().passwordParameter("pass");
		//http.formLogin().defaultSuccessUrl("/admin");
		http.formLogin().failureUrl("/loginerror");
		
		//logout
		http.logout().logoutUrl("/logout");
     	http.logout().logoutSuccessUrl("/mlogout");
		
		//cosica a cambiar
		//http.csrf().disable();
				
		// Database authentication provider
		 //auth.authenticationProvider(authenticationProvider);
		//login
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("uname");
		http.formLogin().passwordParameter("pass");
		//http.formLogin().defaultSuccessUrl("/admin");
		http.formLogin().failureUrl("/loginerror");
		
		//logout
		http.logout().logoutUrl("/logout");
     	http.logout().logoutSuccessUrl("/mlogout");

	}
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//usuarios por defecto
		//auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		//auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("ADMIN");
		
	}*/
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth)
	 throws Exception {
	 // Database authentication provider
	 auth.authenticationProvider(authenticationProvider);
	 }
}


