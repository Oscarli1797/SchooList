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
	
	
	@GetMapping(value = "getAsignaturas")
	public Collection<Asignatura> getAsignaturas() {
		return asignaturaRepo.findAll();
	}

	@GetMapping(value = "getAsignatura/{id}")
	public ResponseEntity<Asignatura> getAsignatura(@PathVariable Long id) {

		Optional<Asignatura> asig = asignaturaRepo.findById(id);
		asig.ifPresent(asigExistente -> {
			return new ResponseEntity<>(asigExistente, HttpStatus.OK);
		});
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createAsignatura")
	@ResponseStatus(HttpStatus.CREATED)
	public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
		
		asignaturaRepo.save(asignatura);
		
		return asignatura;
	}
	
	@PutMapping(value = "updateAsignatura/{id}")
	public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura updatedAsignatura) {

		Optional<Asignatura> asignatura = asignaturaRepo.findById(id);
		
		asignatura.ifPresent(alumnoExistente -> {
			updatedAsignatura.setId(id);
			asignaturaRepo.save(updatedAsignatura);
			return new ResponseEntity<>(updatedAsignatura, HttpStatus.OK);
		});
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteAutobus/{id}")
	public ResponseEntity<Usuario> deleteAutobus(@PathVariable Long id) {

		try {
			asignaturaRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
