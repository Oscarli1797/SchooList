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
	
	@PostMapping(value = "createGrupo")
	public String createGrupo(Grupo grupo) {
		
		grupoRepo.save(grupo);
		
		return "redirect:" + "/admin";
	}
	

	@PostMapping(value = "updateGrupo/{id}")
	public String updateGrupo(@PathVariable Long id, Grupo updatedGrupo) {

		Optional<Grupo> grupo = grupoRepo.findById(id);
		
		if(grupo.get() != null) {
			updatedGrupo.setId(id);
			grupoRepo.save(updatedGrupo);
		}
		return "redirect:" + "/admin";	}
	
	@PostMapping(value = "deleteGrupo/{id}")
	public String deleteGrupo(@PathVariable Long id) {

		grupoRepo.deleteById(id);
		return "redirect:" + "/admin";
		
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
