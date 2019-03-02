package edu.manhattan.javaprog.InToPost;

/**
 *<p>Stack used in Conversion.</p>
 */

public class Stack2 {
	private char[] n;
    private int pointer, m;
 
    public Stack2(int max) {
        m = max;
        n = new char[m];
        pointer = -1;
    }
 
    public void push(char key) {
        n[++pointer] = key;
    }
 
    public char pop() {
        return (n[pointer--]);
    }
 
    public boolean isEmpty() {
        return (pointer == -1);
    }
}