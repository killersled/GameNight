/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.fif.subs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class Events {
    
    private final String arrayField = "entries";
    private final HashMap<Integer, String> Events = new HashMap<>();
    private final String EventFileName = "events.txt";
    private Integer numEvents = 0;

    public String getEventFileName() {
        return EventFileName;
    }

    public Integer getNumEvents() {
        return numEvents;
    }

    public void loadEvents(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + EventFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Events.put(count,line);
                count++;
            }
            numEvents = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getEvent(Integer index) {
        return Events.get(index);
    }
    
    public void loadFromJSON(JSONObject eventDataset) {
        JSONArray entries = eventDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Events.put(i, entry);
        }
        numEvents = entries.length();
    }
}
