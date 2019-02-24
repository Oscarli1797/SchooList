package es.urjc.etsii.schoolist.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Repositories.PostRepository;

@Controller
public class PostController {
	@Autowired
	private PostRepository postRepo;

	@PostMapping("createPost")
	public String createPost(Model model, Post newPost) {
		
		postRepo.save(newPost);
		
		return "redirect:" + "/admin";
	 }
	

	@PostMapping("deletePost")
	public String deletePost(Model model, @RequestParam("id")long id) {

		postRepo.deleteById(id);	
		
		return "redirect:" + "/admin";
	}
	
	
	@PostMapping("editPost")
	public String editPost(Model model, @RequestParam("id")long id) {

		Optional<Post> post = postRepo.findById(id);
		post.ifPresent(postExistente -> {
			model.addAttribute("post", postExistente);
		   });
		
		if(model.containsAttribute("post"))
			return "editarPost_template";
		return "redirect:" + "/admin";
	}
	
	@PostMapping("modificarPost")
	public String modificarPost(Model model) {
		//añadir modificacion en un futuro
		/*
		Optional<Post> poster = postRepo.findById(id);
		poster.ifPresent(postExistente -> {
			postExistente.setTitulo(post.getTitulo());
			postExistente.setTexto(post.getTexto());
			postRepo.save(postExistente);
		 });
		*/
		return "redirect:" + "/admin";
	}
	
}
