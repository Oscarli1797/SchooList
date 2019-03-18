package es.urjc.etsii.schoolist.Controllers;

import java.sql.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Admin;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Repositories.AdminRepository;
import es.urjc.etsii.schoolist.Repositories.PostRepository;

@Controller
public class PostController {
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@PostMapping(value = "createPost")
	public String createPost(Post newPost) {
		
		long millis = System.currentTimeMillis();
		
		Date date = new Date(millis);
		
		newPost.setFecha(date);
		
		String currentUserName ="";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		
		Optional<Admin> admin = adminRepo.findById(currentUserName);
		admin.ifPresent(eAdmin -> {
			newPost.setCreador(eAdmin);
			postRepo.save(newPost);
		});
		
		
		return "redirect:" + "/admin";
	}

	@RequestMapping("/admin/editarPost")
	public String adminPost(Model model, HttpServletRequest request, @RequestParam long id) {
		
		Optional<Post> post = postRepo.findById(id);
		
		if(post.get() != null) {
			model.addAttribute("post", post.get());
		}
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		String t=token.getToken();
		model.addAttribute("token", token.getToken());
		
		return "editarPost_template";
	}
	
	@PostMapping(value = "admin/updatePost")
	public String updatePost(@RequestParam Long id, Post updatedPost) {

		Optional<Post> post = postRepo.findById(id);
		
		
		if(post.get() != null) {
			updatedPost.setCreador(post.get().getCreador());
			updatedPost.setId(id);
			postRepo.save(updatedPost);
		}
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deletePost/{id}")
	public String deleteAutobus(@PathVariable Long id) {

		postRepo.deleteById(id);
		return "redirect:" + "/admin";
	}
	
	@RequestMapping(value = "post/{id}")
	public String goPost(Model model, @PathVariable Long id) {

		Optional<Post> post = postRepo.findById(id);
		
		if(post.get()!=null) {
			model.addAttribute("post", post.get());

			return "post_template";
		}

		return "redirect:" + "/home";
	}

	
}
