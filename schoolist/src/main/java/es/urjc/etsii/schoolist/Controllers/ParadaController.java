package es.urjc.etsii.schoolist.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;

@Controller
public class ParadaController {
	
	@Autowired
	private ParadaRepository paradaRepo;
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private AutobusRepository autobusRepo;
	
	@PostMapping(value = "createParada")
	public String createParada(Parada parada, Autobus autobus) {
		
		paradaRepo.save(parada);
		
		return "redirect:" + "/admin";
	}
	
	@RequestMapping("/admin/editarParada")
	public String adminParada(Model model, HttpServletRequest request, @RequestParam long id) {
		
		Optional<Parada> parada = paradaRepo.findById(id);
		
		if(parada.get() != null) {
			Autobus autobus = autobusRepo.findByParadas(parada.get());
			model.addAttribute("autobus",autobus);
			model.addAttribute("parada", parada.get());
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		String t=token.getToken();
		model.addAttribute("token", token.getToken());
		
		return "editarParada_template";
	}
	@PostMapping(value = "/admin/updateParada")
	public String updateParada(@RequestParam Long id, Parada updatedParada, @RequestParam long bus_oldId, @RequestParam long bus_newId) {

		Optional<Parada> parada = paradaRepo.findById(id);
		
		if(parada.get() != null) {
			updatedParada.setId(id);
			paradaRepo.save(updatedParada);
		}
		//si las id de los autobuses no son la misma, se ha asignado a otra ruta
		//se elimina del bus antiguo y se añadel al nuevo (si existe)
		if(bus_oldId != bus_newId) {
			Optional<Autobus> bus1 = autobusRepo.findById(bus_oldId);
			Optional<Autobus> bus2 = autobusRepo.findById(bus_newId);
			
			if(bus1.get() != null && bus2.get() != null) {
				
				bus1.get().eliminarParada(parada.get());
				bus2.get().añadirParada(parada.get());
				autobusRepo.save(bus1.get());
				autobusRepo.save(bus2.get());
			}
		}
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deleteParada/{id}")
	public String deleteAutobus(@PathVariable Long id) {
		
		Optional<Parada> p = paradaRepo.findById(id);
		p.ifPresent(eP ->{
			List<Alumno> a = alumnoRepo.findByParada(eP);
			for(int i=0;i<a.size();i++) {
				a.get(i).setParada(null);
			}
		});
		paradaRepo.deleteById(id);
		return "redirect:" + "/admin";
	}
	
}
