package palindrome.controller;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import palindrome.model.service.CountPalindromeService;
import palindrome.model.service.UserDetailsServiceImpl;

@Controller
//@PreAuthorize("hasRole('USER')")
public class PalindromeController {
	
	private final CountPalindromeService cps;
	
	public PalindromeController(CountPalindromeService cps) {
		this.cps = cps;
	}
	
	@Autowired 
	private UserDetailsService uds;
	 
	@RequestMapping(value= "/palindrome", method = RequestMethod.GET)
	public ModelAndView pagePalindrome() {
		ModelAndView mav = new ModelAndView("palindrome");
		return mav;
	}
	@RequestMapping(value= "/count", method = RequestMethod.POST)
	public ModelAndView countPalindromes(@RequestParam BigInteger number, int numberOfPalindromes) {
		ArrayList<BigInteger> listOfPalindromes = cps.findPalindromes(number, numberOfPalindromes);
		ModelAndView mav = new ModelAndView("palindrome");
		mav.addObject("listOfPalindromes", listOfPalindromes);
		mav.addObject("NUMBER", number);
		mav.addObject("numberOfPalindromes", numberOfPalindromes);
		return mav;
	}
}
