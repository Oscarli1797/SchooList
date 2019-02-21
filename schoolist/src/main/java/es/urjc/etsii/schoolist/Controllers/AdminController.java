package es.urjc.etsii.schoolist.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.urjc.etsii.schoolist.Entities.AdminRepository;

@Controller
public class AdminController {
	@Autowired
	private AdminRepository adminRepo;
}
