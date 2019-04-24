package es.urjc.etsii.schoolist.Repositories;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Falta;

@CacheConfig(cacheNames="SchoolistCache")
public interface FaltaRepository extends JpaRepository<Falta, Long>{

	@CacheEvict(allEntries=true)
	Falta save(Falta falta);
	
	@Cacheable
	List<Falta> findByAlumno(Alumno alumno);
	
}
