package es.urjc.etsii.schoolist.Controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.MonitorRepository;

@Controller
public class MonitorController {
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	@Autowired
	private AlumnoRepository alumnoRepo;

	@GetMapping("/monitor")
	 public String monitor(Model model) {
		
		/* A coger del usuario logeado cuando esté implementado */
		Optional<Monitor> conejilloIndias = monitorRepo.findById("frandiazvi");
		
		conejilloIndias.ifPresent(conejilloIndiasExistente -> {
			Autobus bus = conejilloIndiasExistente.getBus();
		    List<Alumno> alumnosBus = new LinkedList<Alumno>();
			List<Parada> paradas = bus.getParadas();
			
			alumnosBus = alumnoRepo.findByParadaIn(paradas);
			
			model.addAttribute("autobus", bus);
			model.addAttribute("alumnos", alumnosBus);
			model.addAttribute("monitor", conejilloIndiasExistente);
		});
		
		return "monitor_template";
	 }
	
}
