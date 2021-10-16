package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



class StringCalculator {

	public int add(String input) {

		String[] numbers = input.split(",|\n");

		if(input.isEmpty()) {
			
			return 0;
		}else if(input.length() == 1){
			
			return addNum(numbers);
			
		}else if(input.startsWith("//")){
			
			String[] num = getDelimiterSeperatedNumbers(input);
			return addNum(num);
			
		}else {

			return addNum(numbers);
		}

	}

	

	//Method for adding any amount of numbers
	private int addNum(String [] integers) {
		int sum=0;

		for(int i=0; i < integers.length; i++) {
			sum =sum + Integer.parseInt(integers[i]);
		}
		return sum;

	}

	//Method to get different delimiter separated numbers
	private String[] getDelimiterSeperatedNumbers(String input) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		
		if(matcher.matches()) {
			
			String delimiter = matcher.group(1);
			String toSplit = matcher.group(2);
			
			return toSplit.split(delimiter);
			
		}
		throw new RuntimeException("Wrong Custom Delimeter Format");
	}

}