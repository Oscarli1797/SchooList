package es.urjc.etsii.schoolist.Controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;
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
	 public String monitor(Model model, HttpServletRequest request) {
		
		
		String currentUserName ="";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		
		/* A coger del usuario logeado cuando esté implementado */
		Optional<Monitor> conejilloIndias = monitorRepo.findById(currentUserName);
		
		conejilloIndias.ifPresent(conejilloIndiasExistente -> {
			Autobus bus = conejilloIndiasExistente.getBus();
		    List<Alumno> alumnosBus = new LinkedList<Alumno>();
			List<Parada> paradas = bus.getParadas();
			List<auxObject> paradaAlumno= new LinkedList<auxObject>();
			
			for(int i=0;i<paradas.size();i++) {
				alumnosBus = alumnoRepo.findByParada(paradas.get(i));
				auxObject e = new auxObject(paradas.get(i),alumnosBus);
				paradaAlumno.add(e);
				}
			
			model.addAttribute("autobus", bus);
			model.addAttribute("paradaAlumno", paradaAlumno);
			model.addAttribute("monitor", conejilloIndiasExistente);
		});
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		return "monitor_template";
	 }
	
}

class auxObject{
	public Parada parada;
	public List<Alumno> listaAlumnos;
	 protected auxObject(Parada p, List<Alumno> a) {
		 this.parada = p;
		 this.listaAlumnos=a;
	 }
}




