package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, String>{
	
		Monitor findByBus(Autobus bus);
}
