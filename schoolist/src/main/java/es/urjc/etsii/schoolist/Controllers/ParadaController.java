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
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;

@Controller
public class ParadaController {
	@Autowired
	private ParadaRepository paradaRepo;
	
	@GetMapping(value = "getParadas")
	public Collection<Parada> getAutobuses() {
		return paradaRepo.findAll();
	}
	
	@GetMapping(value = "getParada/{id}")
	public ResponseEntity<Parada> getParada(@PathVariable Long id) {

		Optional<Parada> parada = paradaRepo.findById(id);
		if(parada.get() != null) {
			return new ResponseEntity<>(parada.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createParada")
	@ResponseStatus(HttpStatus.CREATED)
	public Parada createParada(@RequestBody Parada parada) {
		
		paradaRepo.save(parada);
		
		return parada;
	}
	
	@PutMapping(value = "updateParada/{id}")
	public ResponseEntity<Parada> updateParada(@PathVariable Long id, @RequestBody Parada updatedParada) {

		Optional<Parada> parada = paradaRepo.findById(id);
		
		if(parada.get() != null) {
			updatedParada.setId(id);
			paradaRepo.save(updatedParada);
			return new ResponseEntity<>(updatedParada, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteParada/{id}")
	public ResponseEntity<Parada> deleteAutobus(@PathVariable Long id) {

		try {
			paradaRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/*
	@PostMapping("deleteParada")
	public String deleteParada(Model model, @RequestParam long id) {
		
		Optional<Parada> parada = paradaRepo.findById(id);
		parada.ifPresent(paradaExistente -> {
			paradaRepo.delete(paradaExistente);
		   });
		
		return "redirect:" + "/admin";
	}*/
	
}
