package es.urjc.etsii.schoolist.Repositories;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Post;

@CacheConfig(cacheNames="SchoolistCache")
public interface PostRepository extends JpaRepository<Post, Long>{
	
	@Cacheable
	Post findById(long id);

	@CacheEvict(allEntries=true)
	Post save(Post post);
}
	
