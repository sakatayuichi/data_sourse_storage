package com.example.springboot;
import java.io.Serializable;


public class HomeModel02 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name,first,starttime,endtime;

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

	public String getstarttime() {
		return starttime;
	}

	public void setstarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getendtime() {
		return endtime;
	}

	public void setendtime(String endtime) {
		this.endtime = endtime;
	}
}
