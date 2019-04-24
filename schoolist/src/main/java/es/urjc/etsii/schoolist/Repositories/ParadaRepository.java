package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;

@CacheConfig(cacheNames="SchoolistCache")
public interface ParadaRepository extends JpaRepository<Parada, Long>{
	
	@CacheEvict(allEntries=true)
	Parada save(Parada parada);
	
	@Cacheable
	 Parada findByLocalizacion(String localizacion); 
	 
}
