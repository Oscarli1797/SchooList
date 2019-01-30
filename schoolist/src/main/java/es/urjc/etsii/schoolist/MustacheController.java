package es.urjc.etsii.schoolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MustacheController 
{
	
	@RequestMapping(value={"", "/", "home"})
	 public String base(Model model) {
		model.addAttribute("name", "home");
		return "home_template";
	 }
	
	@RequestMapping("/login")
	 public String greeting(Model model) {
		model.addAttribute("name", "login");
		return "login_template";
	 }
	
}
