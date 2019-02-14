package es.urjc.etsii.schoolist;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.AlumnoRepository;
import es.urjc.etsii.schoolist.Entities.User;
import es.urjc.etsii.schoolist.Entities.UserRepository;

@Controller
public class DBController 
{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@Autowired
	private AsignaturaRepository asignaturaRepo;
	
	@Autowired
	private AutobusRepository busRepo;
	
	@Autowired
	private CursoRepository cursoRepo;
	
	@Autowired
	private FaltaRepository faltaRepo;
	
	@Autowired
	private GrupoRepository grupoRepo;
	
	@Autowired
	private MensajeRepository mensajeRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private ParadaRepository paradaRepo;
	
	@Autowired
	private ProfesorRepository profesorRepo;
	
	
	@PostConstruct
	public void init() {
		//repository.save(new User("shadow69", "taka", 1));
		//repository.save(new User("Juan", "Hola caracola", 0));
	}
	
	@RequestMapping("createUser")
	 public String createUser(Model model, @RequestParam("userName") String userName, 
			 @RequestParam("pass") String pass, @RequestParam("userType") String type) {
		
		// Recibes el nombre de usuario, el pass y el tipo de usuario
		User newUser = new User(userName, name, s1, s2, pass);
		
		userRepo.save(newUser);
		
		switch(type) {
		case "profesor":
			Profesor profe = new Profesor(newUser);
			profesorRepo.save(profe);
			//Comprobar que las claves del usuario y el profesor concuerdan
			break;
		case "monitor":
			
			break;
		case "padre":
			
			break;
		case "admin":
			
			break;
		}
		
		
		return "admin_template";
	 }
	
	@RequestMapping("createAlumno")
	 public String createAlumno(Model model, @RequestParam("name") String name, 
			 @RequestParam("surname1") String s1, @RequestParam("surname2") String s2, @RequestParam("dni") String dni) {
		
		//Hacerlo con objetos
		
		// Recibes el nombre de usuario, el pass y el tipo de usuario
		Alumno newAlumno = new Alumno( name, s1, s2, dni);
		
		alumnoRepo.save(newAlumno);
		
		return "admin_template";
	 }
	
	
}
