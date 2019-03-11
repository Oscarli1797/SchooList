package es.urjc.etsii.schoolist.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Falta;

public interface FaltaRepository extends JpaRepository<Falta, Long>{

	List<Falta> findByAlumno(Alumno alumno);
	
}
