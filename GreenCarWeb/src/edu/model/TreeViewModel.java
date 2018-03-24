package edu.model;

import java.util.LinkedList;
import java.util.List;

public class TreeViewModel {
	String text;
	List<TreeViewModel> nodes = new LinkedList<>();
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<TreeViewModel> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeViewModel> nodes) {
		this.nodes = nodes;
	}
	public TreeViewModel(String text, List<TreeViewModel> nodes) {
		super();
		this.text = text;
		this.nodes = nodes;
	}
	public TreeViewModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
