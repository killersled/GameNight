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
public class Actors {
    private final HashMap<Integer, String> Actors = new HashMap<>();
    private final String ActorFileName = "actors.txt";
    private Integer numActors = 0;
    private final String arrayField = "entries";

    public String getActorFileName() {
        return ActorFileName;
    }

    public Integer getNumActors() {
        return numActors;
    }

    public void loadActors(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + ActorFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Actors.put(count,line);
                count++;
            }
            numActors = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getActor(Integer index) {
        return Actors.get(index);
    }
    
    public void loadFromJSON(JSONObject actorDataset) {
        JSONArray entries = actorDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Actors.put(i, entry);
        }
        numActors = entries.length();
    }
}
