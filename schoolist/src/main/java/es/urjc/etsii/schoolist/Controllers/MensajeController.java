package es.urjc.etsii.schoolist.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.EmailService;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Mensaje;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.MensajeRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class MensajeController {
	
	@Autowired
	private MensajeRepository mensajeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping(value = "createMensaje")
	public String createMensaje(Mensaje mensaje) {
		try {
			mensajeRepo.save(mensaje);
			EmailService.getInstance().send(mensaje.getDestino(), "nuevoMensaje");
		}catch(Exception e) {
			e.getLocalizedMessage();
		}
		
		return "redirect:" + "/admin";
	}
	

	@PostMapping(value = "updateMensaje/{id}")
	public String updateMensaje(@PathVariable Long id, Mensaje updatedMensaje) {

		Optional<Mensaje> mensaje = mensajeRepo.findById(id);
		
		if(mensaje.get() != null) {
			updatedMensaje.setId(id);
			mensajeRepo.save(updatedMensaje);
		}
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deleteMensaje/{id}")
	public String deleteAutobus(@PathVariable Long id) {

		mensajeRepo.deleteById(id);
		return "redirect:" + "/admin";
		
	}
	
}

/*
@PostMapping("sendMessage")
public String createMessage(Model model, Mensaje mensaje) {
	
	/*COGER ORIGEN
	mensajeRepo.save(mensaje);
	return "redirect:" + "/home";
}
*/