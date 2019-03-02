package edu.manhattan.javaprog.InToPost;

/**
 *<p>Converts the in fix input to post fix.</p>
 */

public class Conversion {
    private Stack2 s;
    private String input;
    //Initial output is set to nothing so it can be added onto later.
    private String output = "";
 
    public Conversion(String str) {
        input = str;
        //Makes the stack size equal to the input.
        s = new Stack2(str.length());
    }
 
    public String inToPost() {
    	//For the length of the input,
        for (int i = 0; i < input.length(); i++) {
        	//At index, i, of the input string,
            char inputI = input.charAt(i);
            switch (inputI) {
            	//Lowest order,
                case '+':
                case '-':
                	//Gets the operand type and order,
                    getOperand(inputI, 1);
                    break;
                //Middle order,
                case '*':
                case '/':
                case '%':
                	//Gets the operand type and order,
                    getOperand(inputI, 2);
                    break;
                //Highest Order,
                case '(':
                	//Pushes into the stack, 
                    s.push(inputI);
                    break;
                case ')':
                	//Gets contents between parentheses.
                    getParentheses();
                    break;
                //Anything else (numbers) are added onto the output.
                default:
                    output = output + inputI;
            }
        }
        //After finishing the previous loop, pop the obtained output and return it.
        while (!s.isEmpty()) {
            output = output + s.pop();
        }
        return output;
    }
 
    //Get the operand and it's order of precedence
    private void getOperand(char operand, int order1) {
    	//While the stack isn't empty,
        while (!s.isEmpty()) {
        	//The value on top of the stack is popped.
            char opTop = s.pop();
            //If this value is an open parentheses,
            if (opTop == '(') {
            	//Push the value back onto the stack.
                s.push(opTop);
                break;
            } 
            //Anyhting else, 
            else {
                int order2;
                //Lowest order set to 1.
                if (opTop == '+' || opTop == '-') {
                    order2 = 1;
                }
                //Highest order set to 2
                else {
                    order2 = 2;
                }
                //If the order provided in tree is higher, then push. 
                //Order1 is only higher when order2 is the lowest order, so only push for the higher orders (/*%).
                if (order2 < order1) {
                    s.push(opTop);
                    break;
                } 
                //Anything else is added to the output.
                else {
                    output = output + opTop;
                }
            }
        }
        //Push the operand.
        s.push(operand);
    }
 
    //Gets the contents in-between the open and closed parentheses.
    private void getParentheses() {
    	//While the stack isn't empty,
        while (!s.isEmpty()) {
        	//Pop the value out of the stack.
            char inputI = s.pop();
            //If the value is an opening parentheses, break, 
            if (inputI == '(') {
                break;
            }
            //If it's anything else, add it onto the output
            else {
                output = output + inputI;
            }
        }
    }
}