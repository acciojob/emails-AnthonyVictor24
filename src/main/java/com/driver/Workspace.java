package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        this.calendar=new ArrayList<>();

        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am.
        Collections.sort(calendar,(m1,m2)-> m1.getEndTime().compareTo(m2.getEndTime()));
        ArrayList<Meeting> list = new ArrayList<>();
        for(Meeting m : calendar){
            if(list.isEmpty()){
                list.add(m);
            }else{
                LocalTime preEnd = list.get(list.size()-1).getEndTime();
                LocalTime currSt = m.getStartTime();
                if(preEnd.isBefore(currSt)){
                    list.add(m);
                }
            }
        }
//        for(Meeting m1 : list){
//            System.out.println(m1);
//        }
        return list.size();
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public void setCalendar(ArrayList<Meeting> calendar) {
        this.calendar = calendar;
    }
}
