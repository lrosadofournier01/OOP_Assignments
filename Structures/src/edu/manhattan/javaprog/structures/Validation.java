package edu.manhattan.javaprog.structures;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

	
	public static void main(String[] args) {
		//Initialize scanner
		Scanner input = new Scanner(System.in);
		//Ask user to input string
		System.out.println("Please Enter a line you would like to calculate. Make sure to have one more number than operand.");
		//Variable to take the user input
		String equation = input.nextLine();
		//Tokenize the string
		String[] tokens = equation.split("\\s");
		input.close();
		//Validate the string
		//Find amount of numbers and operands
		int number = 0, operand = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].matches(".*\\d+.*")) { // matches uses regex
	            number++;
	        }
			else {
				operand++;
			}
		}
		int diff = number - operand;
		//Make sure input only contains numbers, spaces, and operands
		if (validate(equation) == false) {
			System.out.println("Only numbers, spaces, and operands");
		}
		//Make sure there are spaces between the elements
		else if (tokens.length<=1) {
			System.out.println("There must be spaces between each element");
		}
		//Make sure there are more numbers than operands
		else if (operand > number) {
			System.out.println("There must be more numbers then there are operands");
		}
		//Make sure there is only one more in numbers than operands
		else if (diff != 1) {
			System.out.println("Only one more in numbers than operands");
		}
	}
	
	//Validation Boolean class
	static boolean validate (String s) {
		//Comparison regex
		String regex ="[*/+\\-0-9 ]+";
		return (Pattern.matches(regex, s));
	 }
}
