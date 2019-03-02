/**
 * @author Lucia Rosado-Fournier
 * 
 * <h1>In Fix to Post Fix Converter</h1>
 * <p>The user puts an expression in the in fix notation and the computer parses the input, 
 * inserts it into a tree, reads the tree, and outputs it into post fix notation.</p>
 */

package edu.manhattan.javaprog.InToPost;

import java.io.IOException;

/**
 * <p>Main runs the setStringInput to ask the user for the input and set it to a variable and the 
 * validator to parse the input string and see if the user put the right expression in.</p>
 */

public class Main {

	public static void main(String[] args) throws IOException {	
		//Declare instances
		Input userIn = new Input();
		Validation validate = new Validation();
	    //Ask user to input string
	    System.out.print("Please Enter an equation in the in-fix notiation \n"
			+ "so it can be converted to post-fix notation. \n"
			+ "Meaning, number first then operand after. \n"
			+ "The valid operands are *, /, +, -, and %. \n"
			+ "You can also use one level of parentheses, no nested parenteses! \n"
			+ "Ex. 2 + 3 * ( 4 - 5 ) / 8 \n"
			+ "Your input: ");
	    //Set User Input
	    userIn.setStringInput();
	    //Validates the tokenized user input
	    validate.validator(userIn.tokenInput(userIn.getStringInput()), userIn.getStringInput());
	}
}