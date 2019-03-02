package edu.manhattan.javaprog.edu.tree;
/**
 *Backend is xml
 *Elements: publication, professional certification, Institution membership, personal information, projects, education, experience, extra curriculers
 */

public class ResumeElement {
	String name; 
	String description;
	String data;
	
	public ResumeElement(String name, String description, String data) {
		this.name = name;
		this.description = description;
		this.data = data;
	}
	
	
}
