package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.ProfesorRepository;

@Controller
public class ProfesorController {
	@Autowired
	private ProfesorRepository profesortRepo;
	
}
