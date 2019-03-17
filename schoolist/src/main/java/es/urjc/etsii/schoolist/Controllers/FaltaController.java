package es.urjc.etsii.schoolist.Controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.EmailService;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Falta;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.FaltaRepository;

@Controller
public class FaltaController {

	@Autowired
	private FaltaRepository faltaRepo;
	
	
	@PostMapping(value = "createFalta")
	@ResponseStatus(HttpStatus.CREATED)
	public String createFalta( Falta falta) {
		
		try {
			faltaRepo.save(falta);
			EmailService.getInstance().send(falta.getAlumno().getPadre(), "nuevaFalta");
		}catch(Exception e) {
			e.getLocalizedMessage();
		}
		
		return "redirect:" + "/admin";
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
