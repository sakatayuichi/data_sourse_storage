package com.example.springboot;
import java.io.Serializable;


public class HomeModel02 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String StartTimeHour,EndTimeHour,StartTimeMinute,EndTimeMinute;


	public String getStartTimeHour() {
		return StartTimeHour;
	}

	public void setStartTimeHour(String StartTimeHour) {
		this.StartTimeHour = StartTimeHour;
	}

	public String getEndTimeHour() {
		return EndTimeHour;
	}

	public void setEndTimeHour(String EndTimeHour) {
		this.EndTimeHour = EndTimeHour;
	}

	public String getStartTimeMinute() {
		return StartTimeMinute;
	}

	public void setStartTimeMinute(String StartTimeMinute) {
		this.StartTimeMinute = StartTimeMinute;
	}

	public String getEndTimeMinute() {
		return EndTimeMinute;
	}

	public void setEndTimeMinute(String EndTimeMinute) {
		this.EndTimeMinute = EndTimeMinute;
	}
}
