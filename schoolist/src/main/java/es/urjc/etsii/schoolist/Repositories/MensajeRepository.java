package es.urjc.etsii.schoolist.Repositories;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Usuario;

@CacheConfig(cacheNames="SchoolistCache")
public interface MensajeRepository extends JpaRepository<Mensaje, Long>{

	@CacheEvict(allEntries=true)
	Mensaje save(Mensaje grupo);
	
	@Cacheable
	List<Mensaje> findByDestino (Usuario user);
	
}
