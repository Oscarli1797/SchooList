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

import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Post;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.PostRepository;

@Controller
public class PostController {
	@Autowired
	private PostRepository postRepo;

	@GetMapping(value = "getPosts")
	public Collection<Post> getAutobuses() {
		return postRepo.findAll();
	}
	
	
	@GetMapping(value = "getPost/{id}")
	public ResponseEntity<Post> getPost(@PathVariable Long id) {

		Optional<Post> post = postRepo.findById(id);
		if(post.get() != null) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "createPost")
	@ResponseStatus(HttpStatus.CREATED)
	public Post createPost(@RequestBody Post newPost) {
		
		postRepo.save(newPost);
		
		return newPost;
	}

	@PutMapping(value = "updatePost/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {

		Optional<Post> post = postRepo.findById(id);
		
		if(post.get() != null) {
			updatedPost.setId(id);
			postRepo.save(updatedPost);
			return new ResponseEntity<>(updatedPost, HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "deletePost/{id}")
	public ResponseEntity<Post> deleteAutobus(@PathVariable Long id) {

		try {
			postRepo.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
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
	}*/

	
}
