package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.AsignaturaRepository;

@Controller
public class AsignaturaController {
	
	@Autowired
	private AsignaturaRepository asignaturaRepo;
}
