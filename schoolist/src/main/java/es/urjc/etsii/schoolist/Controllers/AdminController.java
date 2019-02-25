package es.urjc.etsii.schoolist.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.PostRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	

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
		
		return "admin_template";
	 }
}
