package edu.manhattan.javaprog.firstjavaprog;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		int first, second, temp;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first number ");
		first =in.nextInt();
		System.out.print("Enter second number ");
		second = in.nextInt();
		//check if zero
		if(!(first == 0 | second == 0)) {
			while(first!=second) {
				if (first>second)
					first -= second;
				else
					second -= first;
			}
		}
		System.out.println("GCD = " + first);
	}

}
