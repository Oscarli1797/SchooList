package es.urjc.etsii.schoolist.Entities;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

	List<Alumno> findByParada(Parada parada);
	List<Alumno> findByParadaIn(List<Parada> paradaList);
	
}
