package es.urjc.etsii.schoolist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.AdminRepository;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.AlumnoRepository;
import es.urjc.etsii.schoolist.Entities.Asignatura;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.GrupoRepository;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.MonitorRepository;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.PadreRepository;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.PostRepository;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.ProfesorRepository;
import es.urjc.etsii.schoolist.Entities.User;
import es.urjc.etsii.schoolist.Entities.UserRepository;

@Controller
public class MustacheController 
{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private ProfesorRepository profeRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@PostConstruct
	public void init() {
		//repository.save(new User("shadow69", "taka", 1));
		//repository.save(new User("Juan", "Hola caracola", 0));
	}
	
	@RequestMapping(value={"", "/", "home"})
	 public String base(Model model) {
		model.addAttribute("name", "home");
		//model.addAttribute("name", repository.findById("Juan").toString());
		return "home_template";
	 }
	
	@RequestMapping("/login")
	 public String greeting(Model model) {
		model.addAttribute("name", "login");
		return "login_template";
	 }
	
	@RequestMapping("/logout")
	 public String salir(Model model) {
		model.addAttribute("name", "logout");
		return "logout_template";
	 }
	
	@RequestMapping("/loginerror")
	 public String loginerr(Model model) {
		model.addAttribute("name", "loginError");
		return "loginErr_template";
	 }
	
	@RequestMapping("/admin")
	 public String admin(Model model) {
		model.addAttribute("name", "admin");
		
		List<User> usuarios = repository.findAll();
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
	
	@RequestMapping("/profesor")
	 public String profesor(Model model) {
		model.addAttribute("name", "profesor");
		model.addAttribute("nombreProfesor", "jureher");
		
		
		List<String> nombres = new LinkedList<String>();
		

		Optional<Profesor> profe = profeRepo.findById("jureher");
		profe.ifPresent(profeExistente -> {profeExistente.getID();});
		   
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
	    
	    if(alumnos!=null) {
	
	    for (Iterator<Alumno> u = alumnos.iterator(); u.hasNext(); ) {
	        Alumno a = u.next();
	        nombres.add(a.getNombreCompleto());
	    }
	    }
		model.addAttribute("alumnos", nombres);
		return "profesor_template";
	 }
	
	@RequestMapping("/padre")
	 public String padre(Model model) {
		model.addAttribute("name", "padre");
		return "padre_template";
	 }
	
	@RequestMapping("/monitor")
	 public String monitor(Model model) {
		model.addAttribute("name", "monitor");
		return "monitor_template";
	 }
	
	@RequestMapping("/mail")
	 public String mail(Model model) {
		model.addAttribute("name", "mail");
		return "mail_template";
	 }
	
}
