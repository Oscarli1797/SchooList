package es.urjc.etsii.schoolist.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Repositories.PadreRepository;

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

	@PostMapping("editAlumno")
	public String editAlumno(Model model, @RequestParam("id")long id) {
		//se busca en todos los usuarios, si el nick del seleccionado coincide, se accede a la edicion con sus datos
		
		Optional<Alumno> alumno = alumnoRepo.findById(id);
		alumno.ifPresent(alumnoExistente -> {
			model.addAttribute("alumno", alumnoExistente);
		   });
		
		if(model.containsAttribute("alumno"))
			return "editarUsuario_template";
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
