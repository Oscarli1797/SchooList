package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
}
