package edu.manhattan.javaprog.InToPost;

import java.util.Scanner;

/**
 * <p>Input sets the User input to a variable that can be fetched. It also tokenizes the string input and 
 * outputs a string array.</p>
 */

public class Input {
	//Initialize scanner.
	private Scanner in = new Scanner(System.in);
	private String input;
	
	/**
	 * <p>setStringInput sets the users input to a variable and closes the scanner to prevent 
	 * leakage.</p>
	 */
	public void setStringInput() {
		//Variable to take the user input.
		input = in.nextLine();
		//Close input to prevent leakage.
		in.close();
	}
	
	/**
	 * <p>Returns the input fetched in setStringInput</p>
	 * @return input
	 */
	public String getStringInput() {
		//Return the user input as a string.
		return input;
	}
		
	/**
	 * <p>Takes the string from getStringInput and parses it based on the spaces in the string. 
	 * It stores the parsed string into an array and returns the string array</p>
	 * @param s
	 * @return tokens
	 */
	public String[] tokenInput(String s) {
		//Tokens the string.
		String[] tokens = s.split("\\s");
		//Return the tokens user input.
		return tokens;
	}
}