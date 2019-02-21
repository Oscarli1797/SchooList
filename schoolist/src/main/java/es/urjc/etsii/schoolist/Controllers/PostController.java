package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.PostRepository;

@Controller
public class PostController {
	@Autowired
	private PostRepository postRepo;
	
}
