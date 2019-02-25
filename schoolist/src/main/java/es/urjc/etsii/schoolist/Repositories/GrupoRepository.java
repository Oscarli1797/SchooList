package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	Grupo findByCursoAndLetra(String curso, String letra);
}
