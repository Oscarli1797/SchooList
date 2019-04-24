package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Falta;
import es.urjc.etsii.schoolist.Entities.Grupo;

@CacheConfig(cacheNames="SchoolistCache")
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
	
	@CacheEvict(allEntries=true)
	Grupo save(Grupo grupo);
	
	@Cacheable
	Grupo findByCursoAndLetra(String curso, String letra);
}
