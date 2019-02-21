package es.urjc.etsii.schoolist.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.AdminRepository;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.AlumnoRepository;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.PadreRepository;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@PostMapping("createAlumno")
	public String createAlumno(Model model, Alumno newAlumno, @RequestParam String padre) {
		
		/*obtenemos todos los padres del repositorio, si alguno de ellos coincide con el padre 
		 * asignado a este alumno,se le asigna este nuevo alumno como hijo
		*/
		List<Padre> padres = padreRepo.findAll();
		for(int i=0; i<padres.size();i++) {
			if(padres.get(i).getId().equals(padre)) {
				padres.get(i).setHijo(newAlumno);
			}
			
		}
		alumnoRepo.save(newAlumno);
		
		return "redirect:" + "/admin";
	 }
	
	
	@PostMapping("deleteAlumno")
	public String deleteAlumno(Model model, @RequestParam("id")long id) {
		
		Optional<Alumno> alumno = alumnoRepo.findById(id);
		alumno.ifPresent(alumnoExistente -> {
			alumnoRepo.delete(alumnoExistente);
		   });
		
		return "redirect:" + "/admin";
	}
}
