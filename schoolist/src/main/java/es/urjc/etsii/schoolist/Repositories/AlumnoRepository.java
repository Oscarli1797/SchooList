package es.urjc.etsii.schoolist.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Parada;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

	List<Alumno> findByParada(Parada parada);
	List<Alumno> findByParadaIn(List<Parada> paradaList);
	
}
