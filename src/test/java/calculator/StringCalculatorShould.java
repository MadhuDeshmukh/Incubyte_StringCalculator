package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




class StringCalculatorShould {

	private StringCalculator stringCalculator = new StringCalculator();


	@Test
	void empty_string_should_return_0() {

		assertEquals(0,stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() {

		assertEquals(1, stringCalculator.add("1"));
	}


	@Test
	void string_with_two_number_should_return_number_as_sum() {
		assertEquals(3, stringCalculator.add("1,2"));
	}
	
	@Test
	void string_with_any_numbers_should_return_number_as_sum() {
		assertEquals(21, stringCalculator.add("1,2,3,4,5,6"));
	}
	
	@Test
	void string_with_newLine_seperated_numbers_should_return_number_as_sum() {
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}

	@Test
	void string_with_different_delimeter_seperated_numbers_should_return_number_as_sum() {
		assertEquals(3, stringCalculator.add("//;\\n1;2"));
	}

}
