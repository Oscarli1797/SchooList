package es.urjc.etsii.schoolist.Repositories;
import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Admin;

@CacheConfig(cacheNames="SchoolistCache")
public interface AdminRepository extends JpaRepository<Admin, String>{

	@CacheEvict(allEntries=true)
	Admin save(Admin admin);
}
