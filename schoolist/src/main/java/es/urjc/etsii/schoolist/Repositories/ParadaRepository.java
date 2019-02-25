package es.urjc.etsii.schoolist.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.etsii.schoolist.Entities.Parada;

public interface ParadaRepository extends JpaRepository<Parada, Long>{
	
	 Parada findByLocalizacion(String localizacion); 
}
