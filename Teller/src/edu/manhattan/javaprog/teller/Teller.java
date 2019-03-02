package edu.manhattan.javaprog.teller;
/**
 * 
 * @author Rosado-Forunier
 *
 */
public class Teller implements Runnable{
	
	PersonQueue pq;

	public Teller() {
		this.pq = pq;
	}
	
	public void run() {
		try {
			Person p = pq.dequeue();
			if (p == null) {
				Thread.sleep(30000);
			} else {
				if (!p.getTask().equals("end")) {
					int rnd = (int)(Math.random()*60);
					System.out.println();
				}
			}
		} catch (Expectation e) {
			System.out.println(e.getMessage());
		}
	}

}
