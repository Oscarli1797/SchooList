package es.urjc.etsii.schoolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
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
		 
	 Optional<Usuario> user = userRepository.findById(auth.getName());
	 user.ifPresent(userExistente ->{userExistente.getId();});
	 
	 if (user == null) {
	 throw new BadCredentialsException("User not found");
	 }
	 String password = (String) auth.getCredentials();
	 if (!new BCryptPasswordEncoder().matches(password, user.get().getPassWord())) {//era getpasswordhash
	 throw new BadCredentialsException("Wrong password");
	 }
	 /*
	 List<GrantedAuthority> roles = new ArrayList<>();
	 for (String role : user.getRoles()) {
	 roles.add(new SimpleGrantedAuthority(role));
	 }
	 return new UsernamePasswordAuthenticationToken(user.getNombre(), password, roles);
	 }*/
	return auth;//temporal
}
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}