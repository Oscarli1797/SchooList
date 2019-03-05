package es.urjc.etsii.schoolist.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Repositories.GrupoRepository;

@Controller
public class GrupoController {
	@Autowired
	private GrupoRepository grupoRepo;
	
	@PostMapping("createGrupo")
	public String createGrupo(Model model, Grupo grupo) {
		
		grupoRepo.save(grupo);
		
		return "redirect:" + "/admin";
	 }
	
	@PostMapping("deleteGrupo")
	public String deleteGrupo(Model model, @RequestParam long id) {
		
		Optional<Grupo> grupo = grupoRepo.findById(id);
		grupo.ifPresent(grupoExistente -> {
			grupoRepo.delete(grupoExistente);
		   });
		
		return "redirect:" + "/admin";
	}
	
}
