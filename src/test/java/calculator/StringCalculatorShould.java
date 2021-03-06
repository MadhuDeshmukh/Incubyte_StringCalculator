package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




class StringCalculatorShould {

	private StringCalculator stringCalculator = new StringCalculator();


	@Test
	void empty_string_should_return_0() throws Exception {

		assertEquals(0,stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() throws Exception {

		assertEquals(1, stringCalculator.add("1"));
	}


	@Test
	void string_with_two_number_should_return_number_as_sum() throws Exception {
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void string_with_any_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(21, stringCalculator.add("1,2,3,4,5,6"));
	}

	@Test
	void string_with_newLine_seperated_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}

	@Test
	void string_with_different_delimeter_seperated_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(3, stringCalculator.add("//;\n1;2"));
	}

	@Test
	void string_with_negative_numbers_should_throw_exception() throws Exception{
		
		stringCalculator.add("-2");
	}	
	
	@Test
	void string_with_multiple_negative_numbers_should_throw_exception() throws Exception{
		
		stringCalculator.add("-2,3,-5");
	}	
	
	@Test
	void string_with_numbers_bigger_than_1000_ignored() throws Exception{
		
		assertEquals(2, stringCalculator.add("1000,2"));
	}
	
	@Test
	void string_with_any_length_delimiter_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	void string_with_any_numbers_of_delimiter_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	void string_with_any_multiple_delimiter_numbers_should_return_number_as_sum() throws Exception {
		assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
	}
	
	@Test
	void string_start_with_plus_numbers_should_return_number_as_sum_plus_therecount() throws Exception {
		assertEquals(9, stringCalculator.add("+1,2,3"));
	}
	
	@Test
	void string_start_with_plus_numbers_should_return_number_as_sum_plus_therecount2() throws Exception {
		assertEquals(9, stringCalculator.add("+//[;]\\n1;2;3"));
	}
	
	
	
}
