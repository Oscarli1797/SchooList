package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;

@CacheConfig(cacheNames="SchoolistCache")
public interface PadreRepository extends JpaRepository<Padre, String>{
	
	@CacheEvict(allEntries=true)
	Padre save(Padre padre);
}
