/*package es.urjc.etsii.schoolist;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
		//publico
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/loginerror").permitAll();
		
		//privado
		http.authorizeRequests().anyRequest().authenticated();
		
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
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		//usuarios por defecto
		auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("adminpass").roles("USER","ADMIN");
		
	}
}
*/