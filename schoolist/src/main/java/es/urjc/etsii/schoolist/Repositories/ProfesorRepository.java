package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Profesor;

@CacheConfig(cacheNames="SchoolistCache")
public interface ProfesorRepository extends JpaRepository<Profesor, String>{

	@CacheEvict(allEntries=true)
	Profesor save(Profesor post);
}
