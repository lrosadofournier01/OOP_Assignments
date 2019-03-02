//Get public and Private java doc
//Put javadoc comments over Global variables and every function.Describe what each function does. Example in PersonQueue.java
//Accept all 4's for example as a possibility 
//Order of the b's and w's don't matter to the users answer. so if the code is 1234 and user puts 1835, just output 2 b's
/**
 * 
 */
package edu.manhattan.javaprog.mastermind;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rosado-Fournier
 * <h1>MasterMind Game</h1>
 * <p>The computer generates a random, non-repeating, four digit array of numbers 
 * and the user has to guess the numbers in the right order based on the feedback 
 * given by the computer. If only the number is right, the user is given a w, 
 * if the number and position is right, the user is given a b. The user only has
 * 10 tries.</p>
 *  
 */

public class MasterMind {
	/**
	 * <p>Initialize the scanner</p>
	 */
	static Scanner input = new Scanner(System.in);
	/**
	 * <p>num stores the randomly generated number until it's inserted into the array
	 * code after checking if that number is already in the array. Guess stores the users
	 * guess and TokenGuess stores the tokenized guess.</p>
	 */
	static int num;
	static int[] Code = new int[4];
	static String Guess;
	static String[] TokenGuess;
	
	/**
	 * <p> Checks if the randomly generated number is in the array already</p>
	 */
	static boolean Check() {
		for(int j = 0; j<4; j++){
	         if(num == Code[j]){
	            return true;
	         }
		}
		return false;
	}
	
	/**
	 * <p>Generates the random number, re-generates it if the check is true,
	 * then inserts the number into the array if the check is false. It 
	 * outputs the fully generated Code when done.</p>
	 */
	public static int[] CodeGen() {
		for (int i = 0; i<4; i++) {
			num = (int)(Math.random()*10);
			while (Check() == true) {
				num = (int)(Math.random()*10);
			}
			Code[i] = num;
		}
		return Code;
	}
	
	/**
	 * <p>Validates the user only enters numbers</p>
	 */
	public static boolean ValidateDigit(String[] s) {
		for (int i = 0; i < s.length; i++) {
			if (!s[i].matches(".*\\d+.*")) { 
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>Validates the user only enters numbers from 0-9</p>
	 */
	public static boolean ValidateSingle (String[] s) {
		for (int i=0; i<s.length; i++) {
			//Convert string to int
			int[] IntGuess = new int[s.length];
			IntGuess[i] = Integer.parseInt(s[i]);
			if(IntGuess[i]<0 || IntGuess[i]>9) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>Validates the user only enters unique numbers</p>
	 */
	public static boolean ValidateRepeat (String[] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j=i+1;j<s.length;j++) {
		        if (s[i].equals(s[j])){ // or use .equals()
		        	return false;
		        }
			}
		}
		return true;
	}
	
	/**
	 * <p>Validates the user enters enough numbers</p>
	 */
	public static boolean ValidateLength (String[] s) {
		while (s.length != 4) {
			return false;
		}
		return true;
	}
	
	/**
	 * <p>Starts the game by first generating the code and converting it into a string
	 * array so it can be compared with the tokenized guess. The first for loop lets the 
	 * user try to answer ten times before ending. </p>
	 */
	public static void Play() {
		//Generates the Code
		CodeGen();
		//Converts the code array to a string type array
		String[] StringCode = new String[Code.length];
		for (int k=0; k<Code.length; k++) {
			StringCode[k] = String.valueOf(Code[k]);
		}
		//Starts the attempt count
		for(int n=9; n >= 0; n--){
			System.out.println("\nPlease Enter four unique digits with spaces between each:");
			//Get user input
			Guess = input.nextLine();
			//Tokenize the string
			String[] TokenGuess = Guess.split("\\s");
			//If the user guesses correctly
			if (Arrays.equals(TokenGuess, StringCode)) {
				System.out.println();
				System.out.println("You Win! ");
				//If we succeed, break out of the loop and continue with the rest of the code;
				break;		
			}	
			//If the user inputs an invalid input
			if (ValidateDigit(TokenGuess) == false || ValidateSingle(TokenGuess) == false || ValidateRepeat(TokenGuess) == false || ValidateLength(TokenGuess) == false) {
				System.out.printf("Invalid Input\n");
				System.out.printf("Incorrect Answer, you have " + n + " attempts left!\n");
				continue;
			}
			//Checks the black and white comparisons 
			if (!Arrays.equals(TokenGuess, StringCode)) { 
				System.out.printf("Incorrect Answer, you have " + n + " attempts left!\n");
				//Black and White Counter
				int black=0;
				int white=0;
				for (int i = 0; i <= 3; i++) {
					 for (int j = 0; j <= 3; j++) {
						 if (Integer.parseInt(TokenGuess[j]) == Code[i]) {
						 	black++;
						 }
						 if (Integer.parseInt(TokenGuess[j]) == Code[i] && i == j) {
						 	white++;
					 	}
					 }
				 }
				 for (int i = 0; i < white; i++) {
				 	System.out.print("B ");
				 }
				 for (int i = 0; i < black - white; i++) {
				 	System.out.print("W ");
				 }
			}
			//If the user cannot guess correctly
			if(n == 0){
				System.out.println("\n10 faield attempts made, the correct answer was " + Arrays.toString(StringCode));
				System.exit(0);
			}
		}
	}
	
	/**
	 * Main to just run the play function
	 */
	public static void main(String[] args) {
		//Starts the game
		Play();
	}

}
