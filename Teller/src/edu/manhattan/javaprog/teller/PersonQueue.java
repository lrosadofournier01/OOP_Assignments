package edu.manhattan.javaprog.teller;

public class PersonQueue {
	private PersonQueueElement head;
	private PersonQueueElement tail;
	int length;
	//Example Java doc comment. 
	/**
	 * Default Constructor
	 * <p> sets head and tail to null</p>
	 * <p>Sets length to 0</p>
	 */
	public PersonQueue() {
		head = null;
		tail = null;
		length = 0;
	}
	public PersonQueueElement getHead() {
		return head;
	}
	public PersonQueueElement getTail() {
		return tail;
	}
	public int getLength() {
		return length;
	}
	//The person to add to the tail
	public void enqueue(Person p) {
		PersonQueueElement newelement = new PersonQueueElement(p);
		//if empty queue
		if(this.length == 0) {
			this.tail.personBehindMe = newelement;
			this.head = this.tail;
		}
		else {
			this.tail.personBehindMe = newelement;
			this.tail = newelement; 
		}
		this.length++;
	}
	//The person to remove from the head of queue
	public Person dequeue() {
		Person retVal = null;
		if(length > 0) {
			retVal = head.me;
			head = head.personBehindMe;
		}
		return retVal;
	}
}

class PersonQueueElement {
	Person me;
	PersonQueueElement personBehindMe;
	
	public PersonQueueElement(Person me) {
		this.me = me;
		this.personBehindMe = null;
	}
}