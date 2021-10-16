package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



class StringCalculator {

	private static int count;

	static {
		count =0;
	}

	public int add(String input) throws Exception {
		++count;

		String[] numbers = input.split(",|\n");

		if(input.isEmpty()) {

			return 0;
		}else if(input.length() == 1){

			if(Integer.parseInt(input) < 0) {
				throw new RuntimeException("negatives not allowed " + Integer.parseInt(input) );

			}else
			{
				return Integer.parseInt(input);
			}

		}else if(input.startsWith("//")){

			String[] num = getDelimiterSeperatedNumbers(input);


			return addNum(num);

		}else {


			return addNum(numbers);
		}

	}



	//Method for adding any amount of numbers
	private int addNum(String [] integers) throws Exception{
		int sum=0;

		for(int i=0; i < integers.length; i++) {

			if(Integer.parseInt(integers[i]) < 100) {
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



	public static int GetCalledCount() {
		return count;
	}




}