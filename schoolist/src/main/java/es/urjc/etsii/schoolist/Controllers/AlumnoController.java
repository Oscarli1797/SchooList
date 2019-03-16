package es.urjc.etsii.schoolist.Controllers;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.GrupoRepository;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;
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
	
	@PostMapping(value = "createAlumno")
	public String createAlumno(Alumno alumno, @RequestParam String padre, @RequestParam long id_parada, @RequestParam String curso, @RequestParam String letra) {

		
		Optional<Padre> currentPadre = padreRepo.findById(padre);
		currentPadre.ifPresent(ePadre -> {
			alumno.setPadre(ePadre);
		});
		
		Optional<Parada> p = paradaRepo.findById(id_parada);
		p.ifPresent(eP -> {
			alumno.setParada(eP);		
		});
		
		
		Grupo g = grupoRepo.findByCursoAndLetra(curso, letra);
		alumno.setGrupo(g);
		
		alumnoRepo.save(alumno);
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "admin/updateAlumno")
	public String updateAlumno(@RequestParam Long id, Alumno updatedAlumno) {

		Optional<Alumno> alumno = alumnoRepo.findById(id);
		
		if(alumno.get() != null) {
			updatedAlumno.setId(id);
			alumnoRepo.save(updatedAlumno);
		}
		return "redirect:" + "/admin";
		
	}

	@RequestMapping("/admin/editarAlumno")
	public String adminAlumno(Model model, @RequestParam long id) {
		
		Optional<Alumno> alumno = alumnoRepo.findById(id);
		
		if(alumno.get() != null) {
			model.addAttribute("alumno", alumno.get());
		}
		
		return "editarAlumno_template";
	}
	
	@PostMapping(value = "deleteAlumno/{id}")
	public String deleteAlumno(@PathVariable Long id) {

		alumnoRepo.deleteById(id);
		return "redirect:" + "/admin";
		
	}
	
}




/*
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
	 */
