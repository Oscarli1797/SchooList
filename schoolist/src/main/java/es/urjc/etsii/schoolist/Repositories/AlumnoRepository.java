package es.urjc.etsii.schoolist.Repositories;
import java.util.List;



import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;

@CacheConfig(cacheNames="SchoolistCache")
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

	@CacheEvict(allEntries=true)
	Alumno save(Alumno alumno);
	
	@Cacheable
	List<Alumno> findByParada(Parada parada);
	
	@Cacheable
	List<Alumno> findByParadaIn(List<Parada> paradaList);
	
	@Cacheable
	List<Alumno> findByPadre(Padre padre);
}
