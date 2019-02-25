package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Padre;

public interface PadreRepository extends JpaRepository<Padre, String>{

	Padre findByHijo(Alumno hijo);
	
}
