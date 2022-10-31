package com.rbc.test.timerange;

import java.time.LocalTime;

public class TimeRange {
	private LocalTime start;
	private LocalTime end;
	
	private TimeRange(LocalTime time1, LocalTime time2) {
		if(time1 == null || time2 == null)
			throw new IllegalArgumentException("Time must not be null.");
		if(time1.equals(time2))
			throw new IllegalArgumentException("Zero range is invalid here.");
		start = time1.compareTo(time2)>0?time2:time1;
		end = time1.compareTo(time2)>0?time1:time2;
	}
	
	public static TimeRange getRange(LocalTime time1, LocalTime time2) {
		try {
			return new TimeRange(time1, time2);
		}
		catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		if(start == null)
			throw new IllegalArgumentException("Start time must not be null.");
		if(start.compareTo(end) >= 0)
			throw new IllegalArgumentException("Start time must be smaller than end time.");
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		if(start == null)
			throw new IllegalArgumentException("End time must not be null.");
		if(start.compareTo(end) >= 0)
			throw new IllegalArgumentException("End time must be bigger than start time.");
		this.end = end;
	}

	
}
