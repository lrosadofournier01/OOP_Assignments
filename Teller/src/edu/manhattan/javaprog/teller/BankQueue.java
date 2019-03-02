package edu.manhattan.javaprog.teller;

//a queue is a linklist: a link from one element to the next. 
public class BankQueue {

	class Person {
		String LName;
		String FName;
		//...constructors...
		//...accessors/setters...
		public String getLName() {
			return LName;
		}
		public void setLName(String lName) {
			LName = lName;
		}
		public String getFName() {
			return FName;
		}
		public void setFName(String fName) {
			FName = fName;
		}
	}
	
	class personQueueElement{
		//person this Element
		//person behind me=null;
	}
	
	class personQueue{
		//personQueueElement head
		//personQueueElement tail
		//depth
	}
	
	//void enQueue(Person)
	//Person deQueue()
	
	//enQueue: use the depth to see if a queue is too long to open another teller
		//Adding to the tail and declaring that new element as a tail
	//deQueue
		//Get the head element and point the element behind as the new head, taking away an element
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
