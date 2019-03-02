package edu.manhattan.javaprog.firstjavaprog;

//A class
public class FirstJavaProgram {
	
	int a;
	int b;
	
	//An instance and a method. Name of class and method are the same, making this a constructor
	public FirstJavaProgram() {
		a=5;
		b=18;
	}
	
	//An instance and a method
	public void action() {
		System.out.println ("a + b = " + (a+b));
		System.out.println ("a - b = " + (a-b));
		System.out.println ("a * b = " + a*b);
		System.out.println ("a / b = " + a/b);
		System.out.println ("a % b = " + a%b);

	}
	
	//If everything is in the main below there is no need for the instances above
	//Must have a static to call a static. If you call something in main that's not static that doesn't work, must call the instances in that case
	public static void main(String[] args) {
		
		FirstJavaProgram first;
		first = new FirstJavaProgram();
		first.action();
		
	}

}
