package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;

@CacheConfig(cacheNames="SchoolistCache")
public interface UserRepository extends JpaRepository<Usuario, String>{

	@CacheEvict(allEntries=true)
	Usuario save(Usuario post);
}
