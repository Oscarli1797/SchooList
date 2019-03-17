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
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;

@Controller
public class ProfesorController {
	
	@Autowired
	private ProfesorRepository profeRepo;

	@RequestMapping("/profesor")
	 public String profesor(Model model, HttpServletRequest request) {
		model.addAttribute("name", "profesor");

		String currentUserName ="";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}

		Optional<Profesor> profe = profeRepo.findById(currentUserName);
		profe.ifPresent(profeExistente -> {profeExistente.getId();});
		   
		Set<Asignatura> asignaturas= profe.get().getAsignaturas();
		Set<Grupo> grupos=null;
		Grupo grupo;
		Set<Alumno> alumnos=null;
	    for (Iterator<Asignatura> it = asignaturas.iterator(); it.hasNext(); ) {
	        Asignatura a = it.next();
	        if (a.getNombre().equals("matematicas 1"))
	           grupos=a.getGrupo();
	        
	    }
	    if(grupos!=null)
	    for (Iterator<Grupo> i = grupos.iterator(); i.hasNext(); ) {
	        Grupo g = i.next();
	        if (g.getId()==(long) 179431) {
	           grupo=g;
	           alumnos=g.getAlumnos();
	        }
	    }
	    
		model.addAttribute("alumnos", alumnos);
		
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		
		return "profesor_template";
	 }
	
}
