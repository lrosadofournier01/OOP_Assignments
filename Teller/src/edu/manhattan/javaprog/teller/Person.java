package edu.manhattan.javaprog.teller;

public class Person {
	private String LName;
	private String FName;
	private String task;
	
	public Person(String LName, String FName, String task) {
		this.LName = LName;
		this.FName = FName;
		this.task = task;
	}
	public Person() {
		LName="";
		FName="";
		task="";
	}
}
