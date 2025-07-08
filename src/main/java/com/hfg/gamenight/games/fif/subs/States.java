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
public class States {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> States = new HashMap<>();
    private String StateFileName = "states.txt";
    private Integer numStates = 0;

    public String getStateFileName() {
        return StateFileName;
    }

    public Integer getNumStates() {
        return numStates;
    }

    public void loadStates(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + StateFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                States.put(count,line);
                count++;
            }
            numStates = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getState(Integer index) {
        return States.get(index);
    }
    
    public void loadFromJSON(JSONObject stateDataset) {
        JSONArray entries = stateDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            States.put(i, entry);
        }
        numStates = entries.length();
    }
}
