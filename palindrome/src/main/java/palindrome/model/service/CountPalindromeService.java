package palindrome.model.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Service;


@Service
public class CountPalindromeService {
	
	public ArrayList<BigInteger> findPalindromes(BigInteger number, int numberOfPalindromes) {
		
		ArrayList<BigInteger> palindromes = new ArrayList<BigInteger>();
		int[] arr = bigIntegerToIntArray(number);
		List<Integer> listOfNumbers = new ArrayList<>(arr.length);		
		for (int i : arr) {
			listOfNumbers.add(Integer.valueOf(i));
		}
		int size = listOfNumbers.size();
		if(number.compareTo(BigInteger.valueOf(10l)) == -1) {
			Long lessThan10 = number.longValue();
			for(;lessThan10 < 10 ; lessThan10++) {
				palindromes.add(BigInteger.valueOf(lessThan10));
			}
			size++;
			number = BigInteger.valueOf(10l);
		}
		else if (isPalindrome(number)) {
			palindromes.add(number);
		}
		String firstPartOfNumber = number.toString().substring(0, size/2);
		String centralFigure = number.toString().substring(listOfNumbers.size()/2, listOfNumbers.size()/2 + 1);
		String secondPartOfNumber = number.toString().substring(listOfNumbers.size()/2 + 1);
		
		String newFirstPartOfNumberForNotEven = (new Double(Math.pow(10, size/2))).toString().replace(".0", "");
		String newFirstPartOfNumberForEven = (new Double(Math.pow(10, ((size/2) - 1)))).toString().replace(".0", "");
		
		String newCentralFigure = "0";
		
		String newSizeForNotEven;
		String newSizeForEven;
		String fullNumber;
		
		while(!(palindromes.size() == numberOfPalindromes)) {
			newSizeForNotEven = (new Double(Math.pow(10, (size/2)+1) - 1)).toString().replace(".0", "");
			newSizeForEven = (new Double(Math.pow(10, size/2) - 1)).toString().replace(".0", "");
			fullNumber = "" + firstPartOfNumber + centralFigure + secondPartOfNumber;
			
			if(size % 2 == 1) {
				System.out.println(firstPartOfNumber + " " + centralFigure + " " + secondPartOfNumber);
				
				secondPartOfNumber = new StringBuilder(firstPartOfNumber.toString()).reverse().toString();
				fullNumber = "" + firstPartOfNumber + centralFigure + secondPartOfNumber;
				
				if(number.compareTo(BigInteger.valueOf(Long.parseLong(fullNumber))) == -1) {
					number = BigInteger.valueOf(Long.parseLong(fullNumber));
					palindromes.add(number);
					
				}
				
				if((firstPartOfNumber+centralFigure).equals(newSizeForNotEven) ) {
					firstPartOfNumber = newFirstPartOfNumberForNotEven;
					centralFigure = newCentralFigure;
					size++;
				}
				else if(centralFigure.equals("9")) {					
					centralFigure = "0";
					Long temp = Long.parseLong(firstPartOfNumber) + 1;
					firstPartOfNumber = temp.toString();
				}
				else {
					Long temp = Long.parseLong(centralFigure) + 1;
					centralFigure = temp.toString();
				}
			}
			
			if(size % 2 == 0) {
				System.out.println(firstPartOfNumber + " " + secondPartOfNumber);
				secondPartOfNumber = new StringBuilder(firstPartOfNumber.toString()).reverse().toString();
				fullNumber = firstPartOfNumber + secondPartOfNumber;
				if(number.compareTo(BigInteger.valueOf(Long.parseLong(fullNumber))) == -1) {
					number = BigInteger.valueOf(Long.parseLong(fullNumber));
					palindromes.add(number);
				}
				if((firstPartOfNumber).equals(newSizeForEven) ) {
					firstPartOfNumber = newFirstPartOfNumberForEven;
					centralFigure = newCentralFigure;
					size++;
				} 
				else {
					Long temp = Long.parseLong(firstPartOfNumber) + 1;
					firstPartOfNumber = temp.toString();
				}
			}
		}
		return palindromes;	
	}
		
	public int[] bigIntegerToIntArray(BigInteger number) {
		String str = number.toString();
		int[] arr = new int[str.length()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i)-'0';
		}
		return arr;
	}
	
	long arrayToLong(List<Integer> arr)
	{
	    StringBuilder s = new StringBuilder(); 
	    for (int i : arr)
	    {
	         s.append(i);
	    }

	    return Long.parseLong(s.toString()); 
	}
	
	String arrayToString(List<Integer> arr)
	{
	    StringBuilder s = new StringBuilder(); 
	    for (int i : arr)
	    {
	         s.append(i);
	    }

	    return s.toString(); 
	}
	ArrayList<Integer> longToArray(long number) {
		ArrayList<Integer> asb = new ArrayList<Integer>();
		return asb;
	}
	
	public boolean isPalindrome(BigInteger number) {
		BigInteger palindrome = number;
		BigInteger reverse = BigInteger.valueOf(0l);
	    
	    while (!(palindrome.compareTo(BigInteger.valueOf(0l)) == 0)) {
	    	BigInteger remainder = palindrome.mod(BigInteger.valueOf(10l));
	        reverse = (reverse.multiply(BigInteger.valueOf(10l))).add(remainder);
	        palindrome = palindrome.divide(BigInteger.valueOf(10l));
	    }
	    
	    if (number.equals(reverse)) {
	        return true;
	    }
	    return false;
	}
}
