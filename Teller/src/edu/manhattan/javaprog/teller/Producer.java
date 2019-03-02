package edu.manhattan.javaprog.teller;

public class Producer implements Runnable {
	
	PersonQueue pq;
	Person[] toEnqueue;
	static String[] possibleTasks = {"Open Account", "Withdraw Finds", "Deposit Funds", "Apply for Loan"};

	public Producer(PersonQueue pq) {
		this.pq = pq;
		for (int i=0; i<10; i++) {
			int rnd = (int)(Math.random()*4);
			Person newperson = new Person("Person" + i, "Smith", possibleTasks[rnd]);
			toEnqueue[i] = newperson;
		}
	}
	
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				pq.enqueue(toEnqueue[i]);
				int rnd = (int)(Math.random()*60);
				System.out.println("Produced enqueued" + toEnqueue[i].getFName() + " " + toEnqueue[i].getLName() + " " + toEnqueue[i].getTask());
				Thread.sleep(rnd*1000);
			}
			System.out.println("Producer terminated");
		}
	}

}
