package es.urjc.etsii.schoolist;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	 @Autowired
	 private UserRepository userRepository;
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		
		/* List<Usuario> usuarios = new LinkedList<Usuario>();
		 usuarios= userRepository.findAll();
		 for(int i=0;i<usuarios.size();i++) {
			 String cCifrada=new BCryptPasswordEncoder().encode("1234");
			 usuarios.get(i).setPassWord(cCifrada);
			 userRepository.save( usuarios.get(i));
			 }*/
		 
		//publico
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/home").permitAll();
		http.authorizeRequests().antMatchers("/post/**").permitAll();
		//http.authorizeRequests().antMatchers("/logout").permitAll();
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
		
		http.authorizeRequests().antMatchers("/admin").hasAnyAuthority("Admin");
		http.authorizeRequests().antMatchers("/monitor").hasAnyAuthority("Monitor");
		http.authorizeRequests().antMatchers("/padre").hasAnyAuthority("Padre");
		http.authorizeRequests().antMatchers("/profesor").hasAnyAuthority("Profesor");
		
		http.authorizeRequests().anyRequest().authenticated();
				
		//login
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("uname");
		http.formLogin().passwordParameter("pass");
		http.formLogin().failureUrl("/loginerror");
		
		//logouthttp
		http.logout().logoutUrl("/logout");
     	http.logout().logoutSuccessUrl("/");
		
		//http.csrf().disable();
	}

	 @Override
	 protected void configure(AuthenticationManagerBuilder auth)
	 throws Exception {
	 // Database authentication provider
		 auth.authenticationProvider(authenticationProvider);
	 }

}
