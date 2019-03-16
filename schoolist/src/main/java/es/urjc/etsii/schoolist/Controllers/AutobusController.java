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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.urjc.etsii.schoolist.Entities.Alumno;
import es.urjc.etsii.schoolist.Entities.Autobus;
import es.urjc.etsii.schoolist.Entities.Grupo;
import es.urjc.etsii.schoolist.Entities.Monitor;
import es.urjc.etsii.schoolist.Entities.Padre;
import es.urjc.etsii.schoolist.Entities.Parada;
import es.urjc.etsii.schoolist.Entities.Usuario;
import es.urjc.etsii.schoolist.Repositories.AutobusRepository;
import es.urjc.etsii.schoolist.Repositories.MonitorRepository;

@Controller
public class AutobusController {

	@Autowired
	private AutobusRepository autobusRepo;
	
	@Autowired
	private MonitorRepository monitorRepo;
	
	@PostMapping(value = "createAutobus")
	public String createAutobus(Autobus bus, @RequestParam String monitor) {
		
		Optional<Monitor> moni = monitorRepo.findById(monitor);
		moni.ifPresent(eMonitor -> {
			eMonitor.setBus(bus);
		});
		
		autobusRepo.save(bus);
		
		return "redirect:" + "/admin";
	}
	
	@PostMapping(value = "deleteAutobus/{id}")
	public String deleteAutobus(@PathVariable Long id) {
		
		/*
		Optional<Autobus> bus = autobusRepo.findById(id);
		bus.ifPresent(eBus -> {
			Monitor moni = monitorRepo.findByAutobus(eBus);
			moni.setBus(null);
		});
		*/
		
		autobusRepo.deleteById(id);
		return "redirect:" + "/admin";
		
	}
	
}
