package es.urjc.etsii.schoolist.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.User;

public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	List<Mensaje> findByDestino (User user);
	
}
