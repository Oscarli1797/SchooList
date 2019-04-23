package es.urjc.etsii.schoolist.Repositories;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Grupo;


@CacheConfig(cacheNames="SchoolistCache")
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{

	@CacheEvict(allEntries=true)
	Asignatura save(Asignatura asignatura);

	@Cacheable
	List<Asignatura> findByGrupo (Grupo grupo);
	
}
