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

	@GetMapping(value = "getMensajes")
	public Collection<Mensaje> getAutobuses() {
		return mensajeRepo.findAll();
	}
	
	@GetMapping(value = "getMensaje/{id}")
	public ResponseEntity<Mensaje> getMensaje(@PathVariable Long id) {

		Optional<Mensaje> mensaje = mensajeRepo.findById(id);
		if(mensaje.get() != null) {
			return new ResponseEntity<>(mensaje.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createMensaje")
	@ResponseStatus(HttpStatus.CREATED)
	public Mensaje createMensaje(@RequestBody Mensaje mensaje) {
		
		mensajeRepo.save(mensaje);
		
		return mensaje;
	}
	

	@PutMapping(value = "updateMensaje/{id}")
	public ResponseEntity<Mensaje> updateMensaje(@PathVariable Long id, @RequestBody Mensaje updatedMensaje) {

		Optional<Mensaje> mensaje = mensajeRepo.findById(id);
		
		if(mensaje.get() != null) {
			updatedMensaje.setId(id);
			mensajeRepo.save(updatedMensaje);
			return new ResponseEntity<>(updatedMensaje, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deleteMensaje/{id}")
	public ResponseEntity<Mensaje> deleteAutobus(@PathVariable Long id) {

		try {
			mensajeRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
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