package ou.maman14_q2_1;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public class MeetingsDB {
    
    private static HashMap<LocalDate,ArrayList<String>> allMeetings = new HashMap<>();
    
    public static void addNewMeeting(LocalDate date, String meeting){
        ArrayList<String> meetings ;
        meetings = allMeetings.get(date);
        if(meetings == null){
            meetings = new ArrayList<>();
        }
        meetings.add(meeting);
        allMeetings.put(date, meetings);
    }
    
     public static ArrayList<String> getAllMeetingsForDate(LocalDate date){
        return allMeetings.get(date);
    }
    
    
    
}
