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

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Falta;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.GrupoRepository;

@Controller
public class GrupoController {
	@Autowired
	private GrupoRepository grupoRepo;
	
	@GetMapping(value = "getGrupos")
	public Collection<Grupo> getAutobuses() {
		return grupoRepo.findAll();
	}
	
	@GetMapping(value = "getGrupo/{id}")
	public ResponseEntity<Grupo> getGrupo(@PathVariable Long id) {

		Optional<Grupo> grupo = grupoRepo.findById(id);
		if(grupo.get() != null) {
			return new ResponseEntity<>(grupo.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createGrupo")
	@ResponseStatus(HttpStatus.CREATED)
	public Grupo createGrupo(@RequestBody Grupo grupo) {
		
		grupoRepo.save(grupo);
		
		return grupo;
	}
	

	@PutMapping(value = "updateGrupo/{id}")
	public ResponseEntity<Grupo> updateGrupo(@PathVariable Long id, @RequestBody Grupo updatedGrupo) {

		Optional<Grupo> grupo = grupoRepo.findById(id);
		
		if(grupo.get() != null) {
			updatedGrupo.setId(id);
			grupoRepo.save(updatedGrupo);
			return new ResponseEntity<>(updatedGrupo, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteGrupo/{id}")
	public ResponseEntity<Usuario> deleteGrupo(@PathVariable Long id) {

		try {
			grupoRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	@PostMapping("deleteGrupo")
	public String deleteGrupo(Model model, @RequestParam long id) {
		
		Optional<Grupo> grupo = grupoRepo.findById(id);
		grupo.ifPresent(grupoExistente -> {
			grupoRepo.delete(grupoExistente);
		   });
		
		return "redirect:" + "/admin";
	}*/
	
}
