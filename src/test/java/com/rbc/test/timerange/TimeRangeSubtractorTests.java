package com.rbc.test.timerange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Test;

public class TimeRangeSubtractorTests {
	@Test
	public void subtractTimeRangesTest0() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(10, 0))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 30), result[0].getStart());
		assertEquals(LocalTime.of(10, 0), result[0].getEnd());
		
	}
	
	@Test
	public void subtractTimeRangesTest1() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(10, 0))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(10, 0))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertTrue(result.length == 0);
	}
	
	@Test
	public void subtractTimeRangesTest2() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(10, 30))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 15), LocalTime.of(10, 15))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		for(TimeRange tr : result) {
			System.out.println(tr.getStart().toString() + ","+tr.getEnd().toString());
		}
		assertEquals(LocalTime.of(9, 0), result[0].getStart());
		assertEquals(LocalTime.of(9, 15), result[0].getEnd());
		assertEquals(LocalTime.of(10, 15), result[1].getStart());
		assertEquals(LocalTime.of(10, 30), result[1].getEnd());

	}
	
	@Test
	public void subtractTimeRangesTest3() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(11, 0)),
				TimeRange.getRange(LocalTime.of(13, 0), LocalTime.of(15, 0))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 15)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(10, 15)),
				TimeRange.getRange(LocalTime.of(12, 30), LocalTime.of(16, 0))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 15), result[0].getStart());
		assertEquals(LocalTime.of(10, 0), result[0].getEnd());
		assertEquals(LocalTime.of(10, 15), result[1].getStart());
		assertEquals(LocalTime.of(11, 0), result[1].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest4() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 30), LocalTime.of(19, 15))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 0), result[0].getStart());
		assertEquals(LocalTime.of(9, 30), result[0].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest5() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 20), LocalTime.of(10, 30)),
				TimeRange.getRange(LocalTime.of(13, 0), LocalTime.of(15, 0)),
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(11, 0)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(11, 0))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(12, 30), LocalTime.of(16, 0)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(10, 15)),
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 15))
				
				
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 15), result[0].getStart());
		assertEquals(LocalTime.of(10, 0), result[0].getEnd());
		assertEquals(LocalTime.of(10, 15), result[1].getStart());
		assertEquals(LocalTime.of(11, 0), result[1].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest6() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.MIN, LocalTime.of(10, 30)),
				TimeRange.getRange(LocalTime.of(13, 0), LocalTime.of(15, 0)),
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(11, 0)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.MAX)
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(12, 30), LocalTime.of(16, 0)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(10, 15)),
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 15))
				
				
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.MIN, result[0].getStart());
		assertEquals(LocalTime.of(9, 0), result[0].getEnd());
		assertEquals(LocalTime.of(9, 15), result[1].getStart());
		assertEquals(LocalTime.of(10, 0), result[1].getEnd());
		assertEquals(LocalTime.of(10, 15), result[2].getStart());
		assertEquals(LocalTime.of(12, 30), result[2].getEnd());
		assertEquals(LocalTime.of(16, 0), result[3].getStart());
		assertEquals(LocalTime.MAX, result[3].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest7() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30)),
				null
		};
		TimeRange[] timeRanges2 = {
				null
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 0), result[0].getStart());
		assertEquals(LocalTime.of(9, 30), result[0].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest8() {
		TimeRange[] timeRanges1 = {	};
		TimeRange[] timeRanges2 = { };
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertTrue(result.length == 0);
	}
	
	@Test
	public void subtractTimeRangesTest9() {
		TimeRange[] timeRanges1 = null;
		TimeRange[] timeRanges2 = null;;
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertTrue(result.length == 0);
	}
	
	@Test
	public void subtractTimeRangesTest10() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30)),
				TimeRange.getRange(LocalTime.of(10, 0), LocalTime.of(10, 0)),
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(9, 20), LocalTime.of(9, 20)),
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 0), result[0].getStart());
		assertEquals(LocalTime.of(9, 30), result[0].getEnd());
	}
	
	@Test
	public void subtractTimeRangesTest11() {
		TimeRange[] timeRanges1 = {
				TimeRange.getRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
		};
		TimeRange[] timeRanges2 = {
				TimeRange.getRange(LocalTime.of(8, 15), LocalTime.of(8, 29)),
				TimeRange.getRange(LocalTime.of(9, 15), LocalTime.of(9, 29)),
				TimeRange.getRange(LocalTime.of(9, 45), LocalTime.of(9, 59))
		};
		TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
		assertEquals(LocalTime.of(9, 0), result[0].getStart());
		assertEquals(LocalTime.of(9, 15), result[0].getEnd());
		assertEquals(LocalTime.of(9, 29), result[1].getStart());
		assertEquals(LocalTime.of(9, 30), result[1].getEnd());
	}
}
