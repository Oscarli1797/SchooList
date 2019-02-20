package es.urjc.etsii.schoolist;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.*;

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
	private PostRepository postRepo;
	
	@Autowired
	private ProfesorRepository profesorRepo;
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	
	@GetMapping("/monitor")
	 public String monitor(Model model) {
		
		model.addAttribute("name", "monitor");
		
		/* A coger del usuario logeado cuando esté implementado */
		Optional<Monitor> conejilloIndias = monitorRepo.findById("frandiazvi");
		
		conejilloIndias.ifPresent(conejilloIndiasExistente -> {
			Autobus bus = conejilloIndiasExistente.getBus();
		    List<Alumno> alumnosBus = new LinkedList<Alumno>();
			List<Parada> paradas = bus.getParadas();
			
			alumnosBus = alumnoRepo.findByParadaIn(paradas);
			
			model.addAttribute("autobus", bus.getId());
			model.addAttribute("alumno", alumnosBus);
		});
		
		return "monitor_template";
	 }
	
	@PostMapping("createUser")
	 public String createUser(Model model, User newUser, @RequestParam String userType) {
		
		userRepo.save(newUser);
		
		switch(userType) {
		case "profesor":
			Profesor profe = new Profesor(newUser);
			profesorRepo.save(profe);
			break;
		case "monitor":
			Monitor moni = new Monitor(newUser);
			monitorRepo.save(moni);
			break;
		case "padre":
			Padre papi = new Padre(newUser);
			padreRepo.save(papi);
			break;
		case "admin":
			Admin admin = new Admin(newUser);
			adminRepo.save(admin);
			break;
		}
		
		
		return "redirect:" + "/admin";
	 }
	
	@PostMapping("createAlumno")
	public String createAlumno(Model model, Alumno newAlumno, @RequestParam String padre) {
		
		/*obtenemos todos los padres del repositorio, si alguno de ellos coincide con el padre 
		 * asignado a este alumno,se le asigna este nuevo alumno como hijo
		*/
		List<Padre> padres = padreRepo.findAll();
		for(int i=0; i<padres.size();i++) {
			if(padres.get(i).getId().equals(padre)) {
				padres.get(i).setHijo(newAlumno);
			}
			
		}
		alumnoRepo.save(newAlumno);
		
		return "redirect:" + "/admin";
	 }

	@PostMapping("createPost")
	public String createPost(Model model, Post newPost) {
		
		postRepo.save(newPost);
		
		return "redirect:" + "/admin";
	 }
	
	@PostMapping("sendMessage")
	public String createMessage(Model model, Mensaje mensaje, @RequestParam("receptor") String destino_id) {
		//User origen, User destino, String cabecera, String texto
		//mensaje.setOrigin_id(%id_usuario%);
		/*Optional<User> user = userRepo.findById(destino_id);
		
		mensaje.setDestino(user.get());
		*/
		mensajeRepo.save(mensaje);
		
		return "redirect:" + "/home";
	}
	
	@PostMapping("getMailBox")
	public String getMessages(Model model, Mensaje mensaje) {
		
		//model.addAttribute("name", "padre");
		List<Mensaje> mensajesList = mensajeRepo.findAll();
		
		List<String> asuntos = new LinkedList<String>();
		List<String> textos = new LinkedList<String>();
		
		for(int i=0; i<mensajesList.size(); i++) {
			asuntos.add(mensajesList.get(i).getCabecera());
			textos.add(mensajesList.get(i).getTexto());
		}
		
		model.addAttribute("mensajes", asuntos);
		model.addAttribute("textos", textos);
		return "mailBox_template";
	}


	@PostMapping("deleteUsuario")
	public String deleteUsuario(Model model, @RequestParam("nick")String nick) {
		
		//se busca en todos los usuarios, si el nick del seleccionado coincide, se borra ese usuario
		Optional<User> usuario = userRepo.findById(nick);
		usuario.ifPresent(usuarioExistente -> {
			userRepo.delete(usuarioExistente);
		   });
		return "redirect:" + "/admin";
	}
	
	@PostMapping("editUsuario")
	public String editUsuario(Model model, @RequestParam("nick")String nick) {
		//se busca en todos los usuarios, si el nick del seleccionado coincide, se accede a la edicion con sus datos
		
		Optional<User> usuario = userRepo.findById(nick);
		usuario.ifPresent(usuarioExistente -> {
			model.addAttribute("usuario", usuarioExistente);
		   });
		
		if(model.containsAttribute("usuario"))
			return "editarUsuario_template";
		return "redirect:" + "/admin";
	}
	
	@PostMapping("modificarUsuario")
	public String modificarUsuario(Model model, User user) {
		//añadir modificacion en un futuro
		/*
		Optional<User> usuario = userRepo.findById(user.getNick());
		usuario.ifPresent(usuarioExistente -> {
			usuarioExistente.setNombre(user.getNombre());
			usuarioExistente.setApellido1(user.getApellido1());
			usuarioExistente.setApellido2(user.getApellido2());
			userRepo.save(usuarioExistente);
		 });
		*/
		return "redirect:" + "/admin";
	}
	
	@PostMapping("deleteAlumno")
	public String deleteAlumno(Model model, @RequestParam("id")long id) {
		
		Optional<Alumno> alumno = alumnoRepo.findById(id);
		alumno.ifPresent(alumnoExistente -> {
			alumnoRepo.delete(alumnoExistente);
		   });
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping("editAlumno")
	public String editAlumno(Model model, @RequestParam("id")long id) {
		//se busca en todos los usuarios, si el nick del seleccionado coincide, se accede a la edicion con sus datos
		
		Optional<Alumno> alumno = alumnoRepo.findById(id);
		alumno.ifPresent(alumnoExistente -> {
			model.addAttribute("alumno", alumnoExistente);
		   });
		
		if(model.containsAttribute("alumno"))
			return "editarUsuario_template";
		return "redirect:" + "/admin";
	}
	
	@PostMapping("deletePost")
	public String deletePost(Model model, @RequestParam("id")long id) {

		postRepo.deleteById(id);	
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping("editPost")
	public String editPost(Model model, @RequestParam("id")long id) {

		Optional<Post> post = postRepo.findById(id);
		post.ifPresent(postExistente -> {
			model.addAttribute("post", postExistente);
		   });
		
		if(model.containsAttribute("post"))
			return "editarPost_template";
		return "redirect:" + "/admin";
	}
	
	@PostMapping("modificarPost")
	public String modificarPost(Model model) {
		//añadir modificacion en un futuro
		/*
		Optional<Post> poster = postRepo.findById(id);
		poster.ifPresent(postExistente -> {
			postExistente.setTitulo(post.getTitulo());
			postExistente.setTexto(post.getTexto());
			postRepo.save(postExistente);
		 });
		*/
		return "redirect:" + "/admin";
	}
	
}
