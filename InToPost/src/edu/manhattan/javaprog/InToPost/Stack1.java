package edu.manhattan.javaprog.InToPost;

/**
 *<p>Stack used to populate the tree</p>
 */

public class Stack1 {
	private Node[] n;
    private int pointer, m;
 
    public Stack1(int max) {
    	m = max;
        n = new Node[m];
        pointer = -1;
    }
 
    public void push(Node key) {
        n[++pointer] = key;
    }
 
    public Node pop() {
        return (n[pointer--]);
    }
 
    public boolean isEmpty() {
        return (pointer == -1);
    }
}