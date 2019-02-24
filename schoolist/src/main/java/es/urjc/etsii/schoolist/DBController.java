package es.urjc.etsii.schoolist;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.*;
import es.urjc.etsii.schoolist.Repositories.*;

@Controller
public class DBController 
{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private PadreRepository padreRepo;
	
	@Autowired
	private ProfesorRepository profesorRepo;
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	@PostMapping("createUser")
	 public String createUser(Model model, User newUser, @RequestParam String userType) {
		
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
	
}
