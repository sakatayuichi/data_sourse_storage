package com.example.springboot;
import java.io.Serializable;


public class HomeModel02 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String starttimehour,endtimehour,starttimeminute,endtimeminute;


	public String getstarttimehour() {
		return starttimehour;
	}

	public void setstarttimehour(String starttimehour) {
		this.starttimehour = starttimehour;
	}

	public String getendtimehour() {
		return endtimehour;
	}

	public void setendtimehour(String endtimehour) {
		this.endtimehour = endtimehour;
	}

	public String getstarttimeminute() {
		return starttimeminute;
	}

	public void setstarttimeminute(String starttimeminute) {
		this.starttimeminute = starttimeminute;
	}

	public String getendtimeminute() {
		return endtimeminute;
	}

	public void setendtimeminute(String endtimeminute) {
		this.endtimeminute = endtimeminute;
	}
}
