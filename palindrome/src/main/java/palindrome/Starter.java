package palindrome;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import palindrome.model.service.CountPalindromeService;


@SpringBootApplication
public class Starter {
	public static void main(String[] args) {
		CountPalindromeService cps = new CountPalindromeService();/*
		ArrayList<BigInteger> list = cps.findPalindromes(BigInteger.valueOf(1l), 200);		
		System.out.println(list);	*/
		SpringApplication.run(Starter.class, args); 		
	}
}
