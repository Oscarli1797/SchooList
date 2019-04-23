package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Monitor;

@CacheConfig(cacheNames="SchoolistCache")
public interface MonitorRepository extends JpaRepository<Monitor, String>{
	
	@CacheEvict(allEntries=true)
	Monitor save(Monitor monitor);
	
	@Cacheable
	Monitor findByBus(Autobus bus);
}
