package es.urjc.etsii.schoolist.Entities;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

	List<Asignatura> findByGrupo (Grupo grupo);
	
}
