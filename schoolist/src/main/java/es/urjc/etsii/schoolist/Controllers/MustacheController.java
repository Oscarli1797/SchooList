package es.urjc.etsii.schoolist.Controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Repositories.PostRepository;

@Controller
public class MustacheController 
{
	@Autowired
	private PostRepository postRepo;
	
	
	@PostConstruct
	public void init() {
	}
	
	@RequestMapping(value={"", "/", "home"})
	 public String base(Model model) {
		model.addAttribute("name", "home");
		List<Post> postes = postRepo.findAll();
		model.addAttribute("postes",postes);
		return "home_template";
	 }
	
	@RequestMapping("/login")
	 public String greeting(Model model) {
		model.addAttribute("name", "login");
		return "login_template";
	 }
	
	@RequestMapping("/logout")
	 public String salir(Model model) {
		model.addAttribute("name", "logout");
		return "logout_template";
	 }
	
	@RequestMapping("/loginerror")
	 public String loginerr(Model model) {
		model.addAttribute("name", "loginError");
		return "loginErr_template";
	 }
	
}
