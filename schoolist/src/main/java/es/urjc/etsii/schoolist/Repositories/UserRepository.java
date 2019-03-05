package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, String>{


}
