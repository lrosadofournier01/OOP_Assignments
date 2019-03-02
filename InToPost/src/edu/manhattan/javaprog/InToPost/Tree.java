package edu.manhattan.javaprog.InToPost;

/**
 * <p>Tree class that populates a tree using the converted information and traverses it.</p>
 */

public class Tree {
    private Node root;
 
    public Tree() {
        root = null;
    }
 
    //Insert elements into the tree.
    public void insert(String s) {
    	//Declare instances.
        Conversion c = new Conversion(s);
        //Set the string to the converted string.
        s = c.inToPost();
        //Set stack size to the string length.
        Stack1 stk = new Stack1(s.length());
        //Insert delimiters.
        s = s + "$";
        int i = 0;
        //Set element to index of the string.
        char element = s.charAt(i);
        //Create a new node.
        Node newNode;
        //While the element is not a space,
        while (element != '$') {
        	//Make a new node when the element is a digit,
            if (element >= '0' && element <= '9') {
                newNode = new Node(element);
                //And push that new node.
                stk.push(newNode);
            } 
            //Make a pointer when the element is an operand,
            else if (element == '+' || element == '-' || element == '/' || element == '*' || element == '%') {
            	//And pop from the stack.
                Node ptr1 = stk.pop();
                Node ptr2 = stk.pop();
                newNode = new Node(element);
                //Declare the popped elements as the children of the new node.
                newNode.leftChild = ptr2;
                newNode.rightChild = ptr1;
                //Push the new node.
                stk.push(newNode);
            }
            //Go to the next element.
            element = s.charAt(++i);
        }
        //Set the root to the popped stack. 
        root = stk.pop();
    }
 
    //Traverse the populated tree.
    public void traverse(int type) {
        switch (type) {
        	//Set the postFix to display the while root.
            case 1:
                System.out.print("PostFix: ");
                postFix(root);
                break;
            //Just in case the wrong value is put into the code. 
            default:
                System.out.println("Invalid Choice");
        }
    }
 
    //Take the root to display the tree.
    private void postFix(Node localRoot) {
    	//If the root is not empty, 
        if (localRoot != null) {
        	//Display the node with it's left and right child.
        	//locally, at a single node, there is only one root and 2 children. 
            postFix(localRoot.leftChild);
            postFix(localRoot.rightChild);
            localRoot.displayNode();
        }
    }
}