package es.urjc.etsii.schoolist.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.MensajeRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class MensajeController {
	
	@Autowired
	private MensajeRepository mensajeRepo;
	
	@Autowired
	private UserRepository userRepo;


	@RequestMapping("/mail")
	 public String mail(Model model) {
		model.addAttribute("name", "mail");
		return "mail_template";
	 }
	
	@PostMapping("sendMessage")
	public String createMessage(Model model, Mensaje mensaje) {
		
		/*COGER ORIGEN*/
		mensajeRepo.save(mensaje);
		return "redirect:" + "/home";
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
