package com.example.springboot;
import java.io.Serializable;


public class HomeModel02 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name,first;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

}
