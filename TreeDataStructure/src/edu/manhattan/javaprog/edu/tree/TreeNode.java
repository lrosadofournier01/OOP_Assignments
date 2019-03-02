package edu.manhattan.javaprog.edu.tree;

import java.util.ArrayList;
//mvvm paradigm is popular but not very secure, mvs is another good one that is more secure. 
//Read from XML and populate a tree structure. Create Child Elements
//JVM is Java Virtual Machine.
//Hwk: read up on XML and Tree.
/*
 * This is a tree with an array list that can give a dynamic amount of children.
 */
public class TreeNode {

	ResumeElement value;
	ArrayList<TreeNode> children;
	TreeNode parent;
	//Type to be specific about what's there
	
	public TreeNode(ResumeElement value, TreeNode parent) {
		this.value = value;
		this.children = new ArrayList<TreeNode>();
		this.parent = parent;
	}

	public ResumeElement getValue() {
		return value;
	}

	public void setValue(ResumeElement value) {
		this.value = value;
	}

	/**
	 * @return the children
	 */
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public ArrayList<TreeNode> getChildren() {
		return children;
	}
	
	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	public void addChildElement(ResumeElement value) {
		TreeNode newtn = new TreeNode(value, this);
		children.add(newtn);
	}
	
}
