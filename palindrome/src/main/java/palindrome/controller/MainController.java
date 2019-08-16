package palindrome.controller;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import palindrome.model.service.UserDetailsServiceImpl;

@Controller
public class MainController {
	
	private final UserDetailsService uds;
	
	public MainController(UserDetailsService uds) {
		this.uds = uds;
	}
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		System.out.println(uds.loadUserByUsername("Vlas").getAuthorities());
		return mav;
	}
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
