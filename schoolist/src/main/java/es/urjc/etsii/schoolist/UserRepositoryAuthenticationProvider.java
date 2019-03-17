
package es.urjc.etsii.schoolist;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Component
public class UserRepositoryAuthenticationProvider  implements AuthenticationProvider {
	 @Autowired
	 private UserRepository userRepository;
	 @Override
	 public Authentication authenticate(Authentication auth) throws AuthenticationException {
	 System.out.println("Iniciando autenticacion");
	 Usuario user = userRepository.findById(auth.getName()).orElseThrow(() ->new BadCredentialsException("User not found"));
	 System.out.println("Encontré a "+user.getId());
	 String password = (String) auth.getCredentials();
	
	 if (!new BCryptPasswordEncoder().matches(password, user.getPassWord())) {
	// if(!password.equals( user.getPassWord())){		
		 System.out.println("La contraseña almacenada es " + user.getPassWord());
		 System.out.println("Contraseña incorrecta");

		 throw new BadCredentialsException("Wrong password");
	 }
	
	 System.out.println("-----" + user.getRol().toString()+ "------");
	 List<GrantedAuthority> roles = new ArrayList<>();
	 
	 roles.add(new SimpleGrantedAuthority(user.getRol()));

	 return new UsernamePasswordAuthenticationToken(user.getNombre(), password, roles);
	 }
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	

	
}
