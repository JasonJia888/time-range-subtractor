### Code

- Since not explicitly mentioned in the Rubric, comment and logging aspect of the code are intentionally omitted to save time.
- There are 3 classes in total:

1. TimeRange - represent a time section with begin and end time.

2. TimeRangeSubtractor - class that holds the main loggic, it has 2 method:
cleanupTimeRanges - merge overlapping time sections and sort them in asc order.
subtractTimeRanges - do the subtract logic on the sorted time range.
3. AppRun - process user input and print out the result.

### How to run.

- A docker container is created in "hub.docker.com" to run the program.   
1. $  docker image pull kepingjia/time-range-subtractor   
2. $ docker container run -it kepingjia/time-range-subtractor   

- An example run:
keping@keping-Studio-1737:~/Documents$ docker container run -it time-range-subtractor   
An example of time range set "9:30 - 10:00, 11:00 - 12:00"   
Please enter the first time range set:   
9:30 - 10:00, 9:00 - 9:20   
Please enter the second time range set:   
9:00 - 9:45   
The result is:   
09:45 - 10:00   
Do you want to run again (Y/N)?   
n   
