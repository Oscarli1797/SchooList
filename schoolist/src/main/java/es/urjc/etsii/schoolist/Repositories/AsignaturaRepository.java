package es.urjc.etsii.schoolist.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Grupo;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

	List<Asignatura> findByGrupo (Grupo grupo);
	
}
