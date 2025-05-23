// Problem Statement: There is one meeting room in a firm. You are given two arrays, start and end each of 
// size N.For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote the
//  ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one 
//  meeting can happen in the room at a  particular time. Print the order in which these meetings will be performed.

// Example:

// Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}

// Output: 1 2 4 5

// Dry run:

// Step 1: Create a list of meeting objects with start, end, and position.
// Step 2: Sort the meetings based on their end times. If end times are equal, sort based on their positions.
// Step 3: Initialize an ArrayList to store the order of meetings.
// Step 4: Add the first meeting to the answer list.
// Step 5: Set the limit to the end time of the first meeting.
// Step 6: Iterate through the remaining meetings.
//         If the start time of the current meeting is greater than the limit,
//         it means the current meeting can be accommodated without overlapping with the previous meetings.
//         Update the limit to the end time of the current meeting.
//         Add the position of the current meeting to the answer list.
// Step 7: Print the order in which the meetings will be performed.
import java.util.*;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}

// Overall tc : O(n) +O(n log n) + O(n) ~O(n log n)
// sc : o(n)

public class NMeetingInOneRoom{
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();

        for(int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i+1));

        meetingComparator mc = new meetingComparator(); 
        Collections.sort(meet, mc); 
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end; 

        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end; 
                answer.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);

    }
}