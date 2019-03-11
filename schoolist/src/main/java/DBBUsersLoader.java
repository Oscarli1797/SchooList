import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Component
public class DBBUsersLoader {
	 @Autowired
	 private UserRepository userRepository;
	/* @PostConstruct
	 private void initDatabase() {

	 userRepository.save( 
new Usuario ("nombree", "Serrano",  "Navia","ap2","contra"));

	 }*/
	
}
