package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
