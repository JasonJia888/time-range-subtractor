package com.rbc.test.timerange;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Test;

public class TimeRangeTests {
	
	@Test
	public void getRangeTest() {
		assertNull(TimeRange.getRange(LocalTime.of(5, 10), LocalTime.of(5, 10)));
		assertNotNull(TimeRange.getRange(LocalTime.of(6, 10), LocalTime.of(5, 10)));
		assertNotNull(TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10)));
		assertNull(TimeRange.getRange(null, LocalTime.of(5, 10)));
		assertNull(TimeRange.getRange(LocalTime.of(5, 10), null));
	}
	
	@Test
	public void getStartTest() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		assertTrue(tr.getStart().equals(LocalTime.of(4, 10)));
	}
	
	@Test
	public void getEndTest() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		assertTrue(tr.getEnd().equals(LocalTime.of(5, 10)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setStartTest0() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setStart(LocalTime.of(5, 10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setStartTest1() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setStart(LocalTime.of(6, 10));
	}
	
	@Test
	public void setStartTest2() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setStart(LocalTime.of(2, 10));
		assertTrue(tr.getStart().equals(LocalTime.of(2, 10)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setEndTest0() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setEnd(LocalTime.of(4, 10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setEndTest1() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setEnd(LocalTime.of(3, 10));
	}
	
	@Test
	public void setEndTest2() {
		TimeRange tr = TimeRange.getRange(LocalTime.of(4, 10), LocalTime.of(5, 10));
		tr.setEnd(LocalTime.of(8, 10));
		assertTrue(tr.getEnd().equals(LocalTime.of(8, 10)));
	}

}
