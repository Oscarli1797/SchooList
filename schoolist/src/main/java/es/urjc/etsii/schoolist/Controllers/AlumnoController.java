package es.urjc.etsii.schoolist.Controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.GrupoRepository;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Repositories.PadreRepository;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private ParadaRepository paradaRepo;
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@PostMapping("createAlumno")
	public String createAlumno(Model model, Alumno newAlumno, @RequestParam String padre, @RequestParam String localizacion, @RequestParam String curso, @RequestParam String letra) {
		
		
		Optional<Padre> currentPadre = padreRepo.findById(padre);
		currentPadre.ifPresent(ePadre -> {
			newAlumno.setPadre(ePadre);
		});
		
		//Habria que buscar alguna manera de indicar que la parada o el grupo no existen
		Parada p = paradaRepo.findByLocalizacion(localizacion);
		newAlumno.setParada(p);
		
		Grupo g = grupoRepo.findByCursoAndLetra(curso, letra);
		newAlumno.setGrupo(g);
		
		
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
