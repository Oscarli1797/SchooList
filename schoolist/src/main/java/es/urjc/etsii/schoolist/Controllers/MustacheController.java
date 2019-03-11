package es.urjc.etsii.schoolist.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.NotificationService;
import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.MensajeRepository;
import es.urjc.etsii.schoolist.Repositories.PostRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class MustacheController 
{
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MensajeRepository mensajeRepo;
	
	@PostConstruct
	public void init() {
	}
	
	@RequestMapping(value={"", "/", "home"})
	 public String base(Model model) {
		model.addAttribute("name", "home");
		List<Post> postes = postRepo.findAll();
		model.addAttribute("postes",postes);
		NotificationService s = new NotificationService();
		s.sendNotification();
		return "home_template";
	 }
	
	@RequestMapping("/login")
	 public String greeting(Model model, HttpServletRequest request) {
		 System.out.println("Entrando en login");
		model.addAttribute("name", "login");
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		// String t=token.getToken();
		// System.out.println(t);
		// model.addAttribute("token", token.getToken()); 
		 model.addAttribute("token","rrrrr"); 

		return "login_template";
	 }
	
	@RequestMapping("/logout")
	 public String salir(Model model) {
		System.out.println("Entrando en logOut");
		model.addAttribute("name", "logout");
		return "logout_template";
	 }
	
	@RequestMapping("/loginerror")
	 public String loginerr(Model model) {
		System.out.println("Entrando en logError");
		model.addAttribute("name", "loginError");
		return "loginErr_template";
	 }
	
	@RequestMapping("/mail")
	 public String mail(Model model) {
		model.addAttribute("name", "mail");
		return "mail_template";
	 }
	
	@PostMapping("getMailBox")
	public String getMessages(Model model, Mensaje mensaje) {
		
		/* A coger del usuario logeado cuando esté implementado */
		Optional<Usuario> conejilloIndias = userRepo.findById("jureher");
		
		conejilloIndias.ifPresent(conejilloIndiasExistente -> {
			List<Mensaje> mensajesList = mensajeRepo.findByDestino(conejilloIndiasExistente);			
			model.addAttribute("usuario", conejilloIndiasExistente);
			model.addAttribute("mensajes", mensajesList);
		});
		
		return "mailBox_template";
	}
	
}
