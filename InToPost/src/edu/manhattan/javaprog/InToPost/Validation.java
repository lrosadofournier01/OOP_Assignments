package edu.manhattan.javaprog.InToPost;

/**
 * <p>Validation takes the tokenized user input and checks for different parameters explained later
 * down the line.</p>
 */

public class Validation {
	
	/**
	 * <p>The maximum of the array has to be 50 characters as given by the requirements. The minimum
	 * has to be 3 because the most basic expressions are two numbers with an operand in-between.
	 * It takes in the tokenized string array input and returns true if the array satisfies the 
	 * size.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateSize(String[] s) {
		if (s.length <= 3 && 50 <= s.length) {
			return false;
		}
		return true;
	}
	
	/**
	 * <p>The user can only put numbers, operands, and parentheses. As given by the requirements, 
	 * the only operands that can be used are +, -, *, /, and %. It takes in the the tokenized
	 * string array input and returns true if the array satisfies the characters.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateChar(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (!s[i].matches("[()%*/+\\\\-[0-9] ]+")) { 
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>The user must put spaces in-between the elements. It takes in the the tokenized
	 * string array input and returns true if the array satisfies the space requirement.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateSpace(String[] s) {
		if (s.length == 1) { 
			return false;
		}
		return true;
	}
	
	/**
	 * <p>The user must close opening parentheses with a closing parentheses. It takes in the the 
	 * tokenized string array input and returns true if the parentheses are balanced.</p>
	 * @param s
	 * @return true == 0.
	 */
	public boolean validateParentheses(String[] s) {
		int balance = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == "(") {
				balance += 1;
			}
			else if (s[i] == ")") {
				balance -= 1;
			}
		}
		return balance == 0;
	}
	
	/**
	 * <p>The user must start and end the equation with either a parentheses or a number because in fix
	 * notation states this. It takes in the the tokenized string array input and returns true if 
	 * the starting element is satisfied.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateElement(String[] s) {
		if (s[0].matches("\\d*|\\(") && s[s.length-1].matches("\\d*|\\)")) {
			return true;
		}
		return false;
	}
	
	/**
	 * <p>The user must put the expression in the right order, meaning after a number there must be an 
	 * operand and after an operand there must be a number. It takes in the the tokenized string array 
	 * input and returns true if the array is in the right order.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateOrder(String[] s) {
		for (int i = 0; i < s.length-1; i++) {
			if (i != s.length) {
				if (s[i].matches("\\d*\\(\\d*[\\+\\-\\*\\/\\%]\\d*\\)")) {
					return false;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}
	
	/**
	 * <p>The user can't divide by zero. It takes in the the tokenized string array input and returns 
	 * true if the array is not divided by zero.</p>
	 * @param s
	 * @return true
	 */
	public boolean validateDivision(String[] s) {
		for (int i = 0; i < s.length-1; i++) {
			if (i != s.length) {
				if (s[i].matches("\\/*|\\%") && s[i+1].matches("0")) {
					return false;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param str
	 * @param s
	 */
	public void validator(String[] str, String s) {
		//Declare instances.
		Tree T = new Tree();
		//Run validateSize.
		if (validateSize(str)==false) {
			System.out.println("There is a minimum of 3 characters and a maximum of 50 characters!");
		}
		//Run validateChar.
		if (validateChar(str)==false) {
			System.out.println("Only put numbers, operands, and parentheses!");
		}
		//Run validateSpace.
		else if (validateSpace(str)==false) {
			System.out.println("Put spaces between your elements!");
		}
		//Run validateParentheses.
		else if (validateParentheses(str)==false) {
			System.out.println("Close all opening parentheses!");
		}
		//Run validateElement.
		else if (validateElement(str)==false) {
			System.out.println("Equation must start or end with a number or parentheses!");
		}
		//Run validateOrder.
		else if (validateOrder(str)==false) {
			System.out.println("Put the string in the right order!");
		}
		//Run validateOrder.
		else if (validateDivision(str)==false) {
			System.out.println("Can't Divide by zero!");
		}
		//Insert Input into the tree.
		else {
			System.out.println("Thank you for your input! Converting...");
			//Inserts the user string into the tree.
		    T.insert(s);
		    //Traverses it as post fix.
		    T.traverse(1);
		}
	}
}