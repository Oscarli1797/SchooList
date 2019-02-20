package es.urjc.etsii.schoolist.Entities;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutobusRepository extends JpaRepository<Autobus, Long>{

	Autobus findByParadas(Parada parada);
	
}
