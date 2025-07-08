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
public class Sources {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Sources = new HashMap<>();
    private String SourceFileName = "sources.txt";
    private Integer numSources = 0;

    public String getSourceFileName() {
        return SourceFileName;
    }

    public Integer getNumSources() {
        return numSources;
    }


    public void loadSources(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + SourceFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Sources.put(count,line);
                count++;
            }
            numSources = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getSource(Integer index) {
        return Sources.get(index);
    }
    
    public void loadFromJSON(JSONObject sourceDataset) {
        JSONArray entries = sourceDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Sources.put(i, entry);
        }
        numSources = entries.length();
    }
}
