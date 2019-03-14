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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;

@Controller
public class ParadaController {
	
	@Autowired
	private ParadaRepository paradaRepo;

	@Autowired
	private AutobusRepository autobusRepo;
	
	@PostMapping(value = "createParada")
	public String createParada(Parada parada, Autobus autobus) {
		
		paradaRepo.save(parada);
		
		return "redirect:" + "/admin";
	}
	
	@RequestMapping("/admin/editarParada")
	public String adminParada(Model model, @RequestParam long id) {
		
		Optional<Parada> parada = paradaRepo.findById(id);
		
		if(parada.get() != null) {
			Autobus autobus = autobusRepo.findByParadas(parada.get());
			model.addAttribute("autobus",autobus);
			model.addAttribute("parada", parada.get());
		}
		
		return "editarParada_template";
	}
	@PostMapping(value = "/admin/updateParada")
	public String updateParada(@RequestParam Long id, Parada updatedParada) {

		Optional<Parada> parada = paradaRepo.findById(id);
		
		if(parada.get() != null) {
			updatedParada.setId(id);
			paradaRepo.save(updatedParada);
		}
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deleteParada/{id}")
	public String deleteAutobus(@PathVariable Long id) {

		paradaRepo.deleteById(id);
		return "redirect:" + "/admin";
	}
	
}
