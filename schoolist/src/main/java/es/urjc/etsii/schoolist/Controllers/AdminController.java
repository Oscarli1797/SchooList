package es.urjc.etsii.schoolist.Controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.AsignaturaRepository;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;
import es.urjc.etsii.schoolist.Repositories.MonitorRepository;
import es.urjc.etsii.schoolist.Repositories.PadreRepository;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;
import es.urjc.etsii.schoolist.Repositories.PostRepository;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	@Autowired
	private AsignaturaRepository asignaturaRepo;

	@Autowired
	private ParadaRepository paradasRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AutobusRepository busRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AlumnoRepository alumnoRepo;

	@Autowired
	private PadreRepository padreRepo;
	

	@RequestMapping("/admin")
	 public String admin(Model model, HttpServletRequest request) {
		
		class auxObject{
			public Parada parada;
			public Autobus bus;
			 protected auxObject(Parada p, Autobus a) {
				 this.parada = p;
				 this.bus=a;
			 }
	    }
		
		
		model.addAttribute("name", "admin");
		
		List<Usuario> usuarios = userRepo.findAll();
		model.addAttribute("usuarios",usuarios);
		
		List<Padre> padres = padreRepo.findAll();
		model.addAttribute("padres",padres);
		
		List<Monitor> monitores = monitorRepo.findAll();
		model.addAttribute("monitores",monitores);
		
		List<Alumno> alumnos = alumnoRepo.findAll();
		model.addAttribute("alumnos",alumnos);
		
		List<Post> posts = postRepo.findAll();
		model.addAttribute("posts",posts);

		List<Parada> paradas = paradasRepo.findAll();
		List<auxObject> parada_bus = new LinkedList<auxObject>();
		for(int i = 0;i<paradas.size();i++)
		{
			Autobus a = busRepo.findByParadas(paradas.get(i));
			auxObject e = new auxObject(paradas.get(i),a);
			parada_bus.add(e);
		}
		model.addAttribute("paradas",paradas);
		model.addAttribute("parada_bus",parada_bus);
		
		List<Autobus> autobuses = busRepo.findAll();
		model.addAttribute("autobuses",autobuses);
		
		List<Asignatura> asignaturas = asignaturaRepo.findAll();
		model.addAttribute("asignaturas",asignaturas);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		 
		return "admin_template";
	 }
	
	
}
