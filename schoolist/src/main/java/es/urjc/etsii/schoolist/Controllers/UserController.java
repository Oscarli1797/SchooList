package es.urjc.etsii.schoolist.Controllers;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.MonitorRepository;
import es.urjc.etsii.schoolist.Repositories.PadreRepository;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class UserController {
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

	@GetMapping(value = "getUsers")
	public Collection<Usuario> getUsuarios() {
		return userRepo.findAll();
	}

	@GetMapping(value = "getUser/{id}")
	public ResponseEntity<Usuario> getUusario(@PathVariable String id) {

		Optional<Usuario> usuario = userRepo.findById(id);
		usuario.ifPresent(usuarioExistente -> {
			return new ResponseEntity<>(usuarioExistente, HttpStatus.OK);
		});
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "createUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario createUsuario(@RequestBody Usuario usuario, @RequestParam String userType) {

		switch (userType) {
		case "profesor":
			Profesor profe = new Profesor(usuario);
			profesorRepo.save(profe);
			break;
		case "monitor":
			Monitor moni = new Monitor(usuario);
			monitorRepo.save(moni);
			break;
		case "padre":
			Padre papi = new Padre(usuario);
			padreRepo.save(papi);
			break;
		case "admin":
			Admin admin = new Admin(usuario);
			adminRepo.save(admin);
			break;
		}

		return usuario;
	}

	@PutMapping(value = "updateUser/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario updatedUsuario) {

		Optional<Usuario> usuario = userRepo.findById(id);
		
		usuario.ifPresent(usuarioExistente -> {
			updatedUsuario.setId(id);
			userRepo.save(updatedUsuario);
			return new ResponseEntity<>(usuarioExistente, HttpStatus.OK);
		});
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "deleteUser/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable String id) {

		try {
			userRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}


/*
@PostMapping("createUser")
public String createUser(Model model, Usuario newUser, @RequestParam String userType) {

	switch (userType) {
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
public String deleteUsuario(Model model, @RequestParam("id") String id) {

	// se busca en todos los usuarios, si el nick del seleccionado coincide, se
	// borra ese usuario
	Optional<Usuario> usuario = userRepo.findById(id);
	usuario.ifPresent(usuarioExistente -> {
		userRepo.delete(usuarioExistente);
	});
	return "redirect:" + "/admin";
}

@PostMapping("editUsuario")
public String editUsuario(Model model, @RequestParam("nick") String nick) {
	// se busca en todos los usuarios, si el nick del seleccionado coincide, se
	// accede a la edicion con sus datos

	Optional<Usuario> usuario = userRepo.findById(nick);
	usuario.ifPresent(usuarioExistente -> {
		model.addAttribute("usuario", usuarioExistente);
	});

	if (model.containsAttribute("usuario"))
		return "editarUsuario_template";
	return "redirect:" + "/admin";
}

@PostMapping("modificarUsuario")
public String modificarUsuario(Model model, Usuario user) {
	// añadir modificacion en un futuro
	/*
	 * Optional<User> usuario = userRepo.findById(user.getNick());
	 * usuario.ifPresent(usuarioExistente -> {
	 * usuarioExistente.setNombre(user.getNombre());
	 * usuarioExistente.setApellido1(user.getApellido1());
	 * usuarioExistente.setApellido2(user.getApellido2());
	 * userRepo.save(usuarioExistente); });
	 
	return "redirect:" + "/admin";
}*/
