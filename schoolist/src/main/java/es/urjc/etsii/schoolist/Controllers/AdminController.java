package es.urjc.etsii.schoolist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.AsignaturaRepository;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;
import es.urjc.etsii.schoolist.Repositories.ParadaRepository;
import es.urjc.etsii.schoolist.Repositories.PostRepository;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	
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
	private ProfesorRepository profeRepo;
	

	@RequestMapping("/admin")
	 public String admin(Model model) {
		model.addAttribute("name", "admin");
		
		List<Usuario> usuarios = userRepo.findAll();
		model.addAttribute("usuarios",usuarios);
		
		List<Alumno> alumnos = alumnoRepo.findAll();
		model.addAttribute("alumnos",alumnos);
		
		/* en lugar de usuarios, añadir a cada uno si no se puede hacer por rol
		List<Profesor> profesores = profeRepo.findAll();
		model.addAttribute("profesores",profesores);
		
		List<Admin> admins = adminRepo.findAll();
		model.addAttribute("admins",admins);
		List<Padre> padres = padreRepo.findAll();
		model.addAttribute("padres",padres);
		List<Monitor> monitores = monitorRepo.findAll();
		model.addAttribute("monitores",monitores);
		*/
		List<Post> posts = postRepo.findAll();
		model.addAttribute("posts",posts);

		List<Parada> paradas = paradasRepo.findAll();
		model.addAttribute("paradas",paradas);
		
		List<Autobus> autobuses = busRepo.findAll();
		model.addAttribute("autobuses",autobuses);
		
		List<Asignatura> asignaturas = asignaturaRepo.findAll();
		model.addAttribute("asignaturas",asignaturas);
		
		return "admin_template";
	 }
}
