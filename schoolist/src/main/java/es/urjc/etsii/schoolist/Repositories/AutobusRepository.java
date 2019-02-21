package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Parada;

public interface AutobusRepository extends JpaRepository<Autobus, Long>{

	Autobus findByParadas(Parada parada);
	
}
