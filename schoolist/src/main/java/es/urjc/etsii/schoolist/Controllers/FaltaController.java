package es.urjc.etsii.schoolist.Controllers;

import java.sql.Date;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.EmailService;
import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Falta;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.FaltaRepository;

@Controller
public class FaltaController {
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	@Autowired
	private FaltaRepository faltaRepo;
	
	
	@PostMapping(value = "createFalta")
	public String createFalta(long alumno) {
		
		long millis = System.currentTimeMillis();
		Date fecha = new Date(millis);
		
		Optional<Alumno> a = alumnoRepo.findById(alumno);
		a.ifPresent(eAlumno -> {
			Falta falta = new Falta(fecha, eAlumno);
			falta.setJustificacion("Su hij@ "+ eAlumno.getNombreCompleto() +" ha faltado a clase");
			faltaRepo.save(falta);
			/*
			try {
				EmailService.getInstance().send(eAlumno.getPadre(), "nuevaFalta");
			}catch(Exception e) {
				e.getLocalizedMessage();
			}
			*/
		});
		
		
		return "redirect:" + "/profesor";
	}

	@PostMapping(value = "updateFalta/{id}")
	public String updateFalta(@PathVariable Long id, Falta updatedFalta) {

		Optional<Falta> falta = faltaRepo.findById(id);
		
		if(falta.get() != null) {
			updatedFalta.setId(id);
			faltaRepo.save(updatedFalta);
		}
	
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deleteFalta/{id}")
	public String deleteFalta(@PathVariable Long id) {

		faltaRepo.deleteById(id);
		return "redirect:" + "/admin";
		
	}
	
}
