package edu.manhattan.javaprog.firstjavaprog;

public class Primes {

	public static void main(String[] args) {
		boolean primes[] = new boolean[101];
		int i, p, nextprime, multiple;
		for(i=0; i<101; i++) primes[i] = true; //set all to prime to start with
		p=2;
		while (p<100) {
			multiple=2*p;
			primes[multiple] = false;
			multiple +=p;
		}
		nextprime = p+1;
		while (!primes[nextprime])nextprime++;
		p=nextprime;
	for(i=1;i<100;i++)
		if (primes[1])System.out.println(i + " is prime");


	}

}
