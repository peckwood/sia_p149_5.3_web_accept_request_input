package spittr.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/spittler")
public class SpitterController {
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}
	
	//Form parameters
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(){
		return null;
	}
}
