package es.urjc.etsii.schoolist.Controllers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profeRepo;

	@RequestMapping("/profesor")
	 public String profesor(Model model, HttpServletRequest request) {
		

		class auxObject
		{
			
			public Set<Alumno> alumnos;
			public Asignatura asignatura;
			public Grupo grupo;
			
			protected auxObject(Set<Alumno> alumnos, Asignatura asignatura, Grupo grupo) {
				 this.alumnos = alumnos;
				 this.asignatura=asignatura;
				 this.grupo=grupo;
			 }
	    }
		
		List<auxObject> AsigAlumnos = new LinkedList<auxObject>();
		
		model.addAttribute("name", "profesor");

		String currentUserName ="";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}

		Optional<Profesor> profe = profeRepo.findById(currentUserName);
		profe.ifPresent(profeExistente -> {profeExistente.getId();});
		
		model.addAttribute("profesor", profe.get());
		
		Set<Asignatura> asignaturas = profe.get().getAsignaturas();
	    for (Iterator<Asignatura> it = asignaturas.iterator(); it.hasNext(); ) {
	        Asignatura a = it.next();
	        Set<Grupo> grupo = a.getCurso();
	        for (Iterator<Grupo> i = grupo.iterator(); i.hasNext(); ) {
	        	Grupo g = i.next();
	        	auxObject e = new auxObject(g.getAlumnos(),a,g);
	        	AsigAlumnos.add(e);
	        }
	    }
	    
		model.addAttribute("AsigAlumnos", AsigAlumnos);
		
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		String t=token.getToken();
		model.addAttribute("token", token.getToken());
		
		return "profesor_template";
	 }
	
}
