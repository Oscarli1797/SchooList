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
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;

@Controller
public class AutobusController {

	@Autowired
	private AutobusRepository autobusRepo;
	
	@GetMapping(value = "getAutobuses")
	public Collection<Autobus> getAutobuses() {
		return autobusRepo.findAll();
	}

	@GetMapping(value = "getAutobus/{id}")
	public ResponseEntity<Alumno> getAutobus(@PathVariable Long id) {

		Optional<Autobus> bus = autobusRepo.findById(id);
		bus.ifPresent(busExistente -> {
			return new ResponseEntity<>(busExistente, HttpStatus.OK);
		});
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createAutobus")
	@ResponseStatus(HttpStatus.CREATED)
	public Autobus createAutobus(@RequestBody Autobus bus) {
		
		autobusRepo.save(bus);
		
		return bus;
	}
	
	@PutMapping(value = "updateAutobus/{id}")
	public ResponseEntity<Autobus> updateAutobus(@PathVariable Long id, @RequestBody Autobus updatedBus) {

		Optional<Autobus> bus = autobusRepo.findById(id);
		
		bus.ifPresent(alumnoExistente -> {
			updatedBus.setId(id);
			autobusRepo.save(updatedBus);
			return new ResponseEntity<>(updatedBus, HttpStatus.OK);
		});
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteAutobus/{id}")
	public ResponseEntity<Usuario> deleteAutobus(@PathVariable Long id) {

		try {
			autobusRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
}
