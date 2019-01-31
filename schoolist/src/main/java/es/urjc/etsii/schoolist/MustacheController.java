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
	
	@RequestMapping("/admin")
	 public String admin(Model model) {
		model.addAttribute("name", "admin");
		return "admin_template";
	 }
	
	@RequestMapping("/profesor")
	 public String profesor(Model model) {
		model.addAttribute("name", "profesor");
		return "profesor_template";
	 }
	
	@RequestMapping("/padre")
	 public String padre(Model model) {
		model.addAttribute("name", "padre");
		return "padre_template";
	 }
	
	@RequestMapping("/monitor")
	 public String monitor(Model model) {
		model.addAttribute("name", "monitor");
		return "monitor_template";
	 }
	
	@RequestMapping("/mail")
	 public String mail(Model model) {
		model.addAttribute("name", "mail");
		return "mail_template";
	}
	
}
