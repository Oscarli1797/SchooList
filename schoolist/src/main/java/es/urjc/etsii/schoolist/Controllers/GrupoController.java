package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.GrupoRepository;

@Controller
public class GrupoController {
	@Autowired
	private GrupoRepository grupoRepo;
	
}
