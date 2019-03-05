package es.urjc.etsii.schoolist.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;

@Controller
public class ParadaController {
	@Autowired
	private ParadaRepository paradaRepo;
	
	@PostMapping("createParada")
	public String createParada(Model model, Parada parada) {
		
		paradaRepo.save(parada);
		
		return "redirect:" + "/admin";
	 }
	
	@PostMapping("deleteParada")
	public String deleteParada(Model model, @RequestParam long id) {
		
		Optional<Parada> parada = paradaRepo.findById(id);
		parada.ifPresent(paradaExistente -> {
			paradaRepo.delete(paradaExistente);
		   });
		
		return "redirect:" + "/admin";
	}
	
}
