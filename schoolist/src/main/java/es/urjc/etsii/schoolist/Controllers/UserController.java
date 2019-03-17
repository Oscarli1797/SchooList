package es.urjc.etsii.schoolist.Controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
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

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Profesor;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.AlumnoRepository;
import es.urjc.etsii.schoolist.Repositories.MonitorRepository;
import es.urjc.etsii.schoolist.Repositories.PadreRepository;
import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;
import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private AlumnoRepository alumnoRepo;
	
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

	@PostMapping(value = "createUsuario")
	public String createUsuario(Usuario usuario, @RequestParam String userType) {

		System.out.println(usuario.getMail());
		
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

		return "redirect:" + "/admin";
	}
	
	@PostMapping("/admin/editarUsuario")
	public String adminParada(Model model, HttpServletRequest request, @RequestParam String id) {
		

		Optional<Usuario> usuario = userRepo.findById(id);
		
		if(usuario.get() != null) {
			model.addAttribute("usuario", usuario.get());
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		String t=token.getToken();
		model.addAttribute("token", token.getToken());
		
		return "editarUsuario_template";
	}
	
	@PostMapping(value = "/admin/updateUsuario")
	public String updateUsuario( @RequestParam String id, @RequestParam String nombre, 
			@RequestParam String apellido1, @RequestParam String apellido2, @RequestParam String mail) {

		Optional<Usuario> usuario = userRepo.findById(id);
		
		if(usuario.get() != null) {
			usuario.get().setNombre(nombre);
			usuario.get().setApellido1(apellido1);
			usuario.get().setApellido2(apellido2);
			usuario.get().setMail(mail);
			
			userRepo.save(usuario.get());
		}
		return "redirect:" + "/admin";
	}

	@PostMapping(value = "deleteUsuario/{id}")
	public String deleteUsuario(@PathVariable String id) {

		Optional<Usuario> usuario = userRepo.findById(id);
		usuario.ifPresent(usuarioExistente -> {
			Optional<Padre> p = padreRepo.findById(id);
			p.ifPresent(eP ->{
				List<Alumno> a = alumnoRepo.findByPadre(eP);
				for(int i=0;i<a.size();i++) {
					alumnoRepo.delete(a.get(i));
				}
			});
		
			userRepo.delete(usuarioExistente);
		});
		
		return "redirect:" + "/admin";
	}
}

