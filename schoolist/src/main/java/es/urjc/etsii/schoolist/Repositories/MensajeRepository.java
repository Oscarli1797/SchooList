package es.urjc.etsii.schoolist.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Usuario;

public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	List<Mensaje> findByDestino (Usuario user);
	
}
