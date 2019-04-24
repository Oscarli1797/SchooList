package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Parada;
@CacheConfig(cacheNames="SchoolistCache")
public interface AutobusRepository extends JpaRepository<Autobus, Long>{

	@CacheEvict(allEntries=true)
	Autobus save(Autobus autobus);
	
	@Cacheable
	Autobus findByParadas(Parada parada);
	
}
