package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Repositories.CursoRepository;

@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepo;
}
