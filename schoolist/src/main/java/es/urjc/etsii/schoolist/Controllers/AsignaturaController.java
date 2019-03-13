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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AsignaturaRepository;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;

@Controller
public class AsignaturaController {
	
	@Autowired
	private AsignaturaRepository asignaturaRepo;

	
	@PostMapping(value = "createAsignatura")
	public String createAsignatura(Asignatura asignatura) {
		
		asignaturaRepo.save(asignatura);
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "updateAsignatura/{id}")
	public String updateAsignatura(@PathVariable Long id, Asignatura updatedAsignatura) {
		
		Optional<Asignatura> asignatura = asignaturaRepo.findById(id);
		if(asignatura.get() != null) {
			updatedAsignatura.setId(id);
			asignaturaRepo.save(updatedAsignatura);
		}
		return "redirect:" + "/admin";
		
	}
	
	@PostMapping(value = "deleteAsignatura/{id}")
	public String deleteAutobus(@PathVariable Long id) {

			asignaturaRepo.deleteById(id);
			return "redirect:" + "/admin";
	}
	
}
