package com.rbc.test.timerange;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Keping
 *
 */
public class TimeRangeSubtractor {

	public static TimeRange[] subtractTimeRanges(TimeRange[] timeRanges1, TimeRange[] timeRanges2) {
		Queue<TimeRange> rangeQueue1 = cleanupTimeRanges(timeRanges1);
		Queue<TimeRange> rangeQueue2 = cleanupTimeRanges(timeRanges2);
		List<TimeRange> result = new ArrayList<>();

		TimeRange current1 = null;
		TimeRange current2 = null;
		while (rangeQueue1.size() > 0 || current1 != null) {

			if (current1 == null) {
				current1 = rangeQueue1.remove();
			}

			if (rangeQueue2.size() > 0 || current2 != null) {

				if (current2 == null) {
					current2 = rangeQueue2.remove();
				}

				if (current1.getStart().compareTo(current2.getStart()) < 0) {
					if (current1.getEnd().compareTo(current2.getStart()) <= 0) {
						result.add(current1);
						current1 = null;
					} else if (current1.getEnd().compareTo(current2.getEnd()) <= 0) {
						result.add(TimeRange.getRange(current1.getStart(), current2.getStart()));
						current1 = null;
					} else {
						result.add(TimeRange.getRange(current1.getStart(), current2.getStart()));
						current1.setStart(current2.getEnd());
						current2 = null;
					}

				} else if (current1.getStart().compareTo(current2.getEnd()) < 0) {
					if (current1.getEnd().compareTo(current2.getEnd()) <= 0) {
						current1 = null;
					} else {
						current1.setStart(current2.getEnd());
						current2 = null;
					}
				} else {
					current2 = null;
				}
				
			} else {
				result.add(current1);
				current1 = null;
			}

		}
		return result.toArray(new TimeRange[result.size()]);
	}

	private static Queue<TimeRange> cleanupTimeRanges(TimeRange[] timeRanges) {
		Deque<TimeRange> result = new LinkedList<>();
		
		if (timeRanges == null)
			return result;
		timeRanges = Arrays.stream(timeRanges).filter(s -> s != null).toArray(TimeRange[]::new);
		if (timeRanges.length == 0)
			return result;

		Arrays.sort(timeRanges, new Comparator<TimeRange>() {
			public int compare(TimeRange tr1, TimeRange tr2) {
				return tr1.getStart().compareTo(tr2.getStart());
			}
		});

		result.addLast(timeRanges[0]);

		for (int i = 1; i < timeRanges.length; i++) {
			TimeRange last = result.peekLast();

			if (last.getEnd().compareTo(timeRanges[i].getStart()) < 0) {
				result.addLast(timeRanges[i]);
			} else if (last.getEnd().compareTo(timeRanges[i].getEnd()) < 0) {
				last.setEnd(timeRanges[i].getEnd());
			}
		}

		return result;
	}

}
