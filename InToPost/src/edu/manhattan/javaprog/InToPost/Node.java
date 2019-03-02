package edu.manhattan.javaprog.InToPost;

/**
 *<p>Class to create the nodes necessary for the tree.</p>
 */

public class Node {
	public char element;
    public Node leftChild;
    public Node rightChild;
 
    //Places the information of the element at the node. In this case, the nodes are operands.
    public Node(char x) {
    	element = x;
    }
 
    //Displays the node.
    public void displayNode() {
    	System.out.print(element);
    }
}