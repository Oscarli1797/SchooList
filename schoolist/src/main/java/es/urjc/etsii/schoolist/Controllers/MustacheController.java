package es.urjc.etsii.schoolist.Controllers;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import es.urjc.etsii.schoolist.NotificationService;
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
	 public String base(Model model, HttpServletRequest request) {
		model.addAttribute("name", "home");
		List<Post> postes = postRepo.findAll();
		model.addAttribute("postes",postes);

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
	//	NotificationService s = new NotificationService();
	//	s.sendNotification();
		return "home_template";
	 }
	
	@RequestMapping("/login")
	 public String greeting(Model model, HttpServletRequest request) {
		 System.out.println("Entrando en login");
		model.addAttribute("name", "login");
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken()); 

		// model.addAttribute("token","cambiaresto por el .getoken()"); 
		return "login_template";
	 }
	
	@RequestMapping("/logout")
	 public String salir(Model model, HttpServletRequest request) {
		System.out.println("Haciendo logOut");
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		return "home_template";
	 }
	
	@RequestMapping("/mlogout")
	 public String mostrarLogOut(Model model, HttpServletRequest request) {
		System.out.println("Mostrando logOut");
		model.addAttribute("name", "logout");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		return "logout_template";
	 }
	
	@RequestMapping("/loginerror")
	 public String loginerr(Model model, HttpServletRequest request) {
		System.out.println("Entrando en logError");
		model.addAttribute("name", "loginError");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		return "loginErr_template";
	 }
	
	@RequestMapping("/mail")
	 public String mail(Model model, HttpServletRequest request) {
		model.addAttribute("name", "mail");
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 String t=token.getToken();
		 System.out.println(t);
		 model.addAttribute("token", token.getToken());
		
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
