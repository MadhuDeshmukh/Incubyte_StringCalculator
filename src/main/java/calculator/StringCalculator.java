package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



class StringCalculator {

	public int add(String input) throws Exception {

		String[] numbers = input.split(",|\n");

		if(input.isEmpty()) {

			return 0;
		}else if(input.length() == 1){

			if(Integer.parseInt(input) < 0) {
				throw new RuntimeException("negatives not allowed " + Integer.parseInt(input) );

			}else{
				return Integer.parseInt(input);
			}

		}else if(input.startsWith("//[")){

			return anyLengthDelimiter(input);

		}else if(input.startsWith("//")){

			String[] num =getDelimiterSeperatedNumbers(input);


			return addNum(num);
		}else {

			for(int i=0; i < input.length(); i++)
				if(input.charAt(i) < 0) {
					throw new RuntimeException("negatives not allowed " + input.charAt(i) );

				}else{
					return addNum(numbers);
				}
		}
		return addNum(numbers);

	}



	//Method for adding any amount of numbers
	private int addNum(String [] integers) throws Exception{
		int sum=0;

		for(int i=0; i < integers.length; i++) {
			if(1000 > Integer.parseInt(integers[i])) {
				sum =sum + Integer.parseInt(integers[i]);
			}
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


	//Get Sum For Any Length Delimiter
	private int anyLengthDelimiter(String input)
	{
		String brack = input.substring(2,3);
		int sum =0;

		if(brack.contains("[")) {
			int lastIndex = input.indexOf("]");
			String delimiter = input.substring(2,lastIndex);

			int nIndex = input.indexOf("\n");
			String numString = input.substring(nIndex + 1, input.length());

			System.out.println(numString);

			for(int i=0; i < numString.length();) {

				int n = Integer.parseInt(numString.charAt(i) + "");

				sum = sum + n;
				i = i+ delimiter.length();

			}

		}

		System.out.println(sum);
		return sum;

	}



}