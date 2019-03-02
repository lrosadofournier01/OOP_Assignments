package edu.manhattan.javaprog.structures;

public class Stack {
	private double[] stack;
	private int pointer;

	public Stack() {
		stack = new double[1000];
		pointer = 0;
	}
	public void push(double a) {
		stack[pointer++] = a;
	}
	
	public double pop() {
		//pointer--;
		return stack[--pointer];
	}
}
