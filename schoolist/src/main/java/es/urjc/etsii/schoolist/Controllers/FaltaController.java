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

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Falta;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.FaltaRepository;

@Controller
public class FaltaController {

	@Autowired
	private FaltaRepository faltaRepo;
	
	@GetMapping(value = "getFaltas")
	public Collection<Falta> getAutobuses() {
		return faltaRepo.findAll();
	}
	
	@GetMapping(value = "getFalta/{id}")
	public ResponseEntity<Falta> getFalta(@PathVariable Long id) {

		Optional<Falta> falta = faltaRepo.findById(id);
		if(falta.get() != null) {
			return new ResponseEntity<>(falta.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createFalta")
	@ResponseStatus(HttpStatus.CREATED)
	public Falta createFalta(@RequestBody Falta falta) {
		
		faltaRepo.save(falta);
		
		return falta;
	}

	@PutMapping(value = "updateFalta/{id}")
	public ResponseEntity<Falta> updateFalta(@PathVariable Long id, @RequestBody Falta updatedFalta) {

		Optional<Falta> falta = faltaRepo.findById(id);
		
		if(falta.get() != null) {
			updatedFalta.setId(id);
			faltaRepo.save(updatedFalta);
			return new ResponseEntity<>(updatedFalta, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteFalta/{id}")
	public ResponseEntity<Falta> deleteFalta(@PathVariable Long id) {

		try {
			faltaRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
