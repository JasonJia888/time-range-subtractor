package com.rbc.test.timerange;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppRun {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			boolean step1 = true;
			boolean step2 = true;
			TimeRange[] timeRanges1 = null;
			TimeRange[] timeRanges2 = null;
			System.out.println("An example of time range set \"9:30 - 10:00, 11:00 - 12:00\"");
			while (step1) {
				System.out.println("Please enter the first time range set: ");
				String input1 = scanner.nextLine();
				timeRanges1 = processInput(input1);
				step1 = (timeRanges1 == null);
				if(step1)
					System.out.println("Input is invalid!");
			}
			while (step2) {
				System.out.println("Please enter the second time range set: ");
				String input2 = scanner.nextLine();
				timeRanges2 = processInput(input2);
				step2 = (timeRanges2 == null);
				if(step2)
					System.out.println("Input is invalid!");
			}
			
			TimeRange[] result = TimeRangeSubtractor.subtractTimeRanges(timeRanges1, timeRanges2);
			System.out.println("The result is:");
			System.out.println("--------------");
			for(TimeRange tr : result) {
				System.out.println(tr.getStart().toString() + " - "+tr.getEnd().toString());
			}
			System.out.println("--------------");
			
			System.out.println("Do you want to run again (Y/N)? ");
			String runAgain = scanner.nextLine();
			if (!runAgain.toLowerCase().contains("y"))
				break;
		}
	}

	private static TimeRange[] processInput(String input) {
		List<TimeRange> timeRanges = new ArrayList<>();
		try {
			String[] ranges = input.split(",");
			for(String range : ranges) {
				String[] times = range.split("-");
				
					String[] beginTimeParts = times[0].split(":");
					String[] endTimeParts = times[1].split(":");
					timeRanges.add(TimeRange.getRange(LocalTime.of(Integer.valueOf(beginTimeParts[0].trim()), Integer.valueOf(beginTimeParts[1].trim())), 
							                          LocalTime.of(Integer.valueOf(endTimeParts[0].trim()), Integer.valueOf(endTimeParts[1].trim()))));
				
			}
			
		}catch(Exception e)
		{
			return null;
		}
		return timeRanges.toArray(new TimeRange[timeRanges.size()]);
	}

}
