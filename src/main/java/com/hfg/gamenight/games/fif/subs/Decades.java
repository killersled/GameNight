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
public class Decades {
    
    private HashMap<Integer, String> Decades = new HashMap<>();
    private String DecadeFileName = "decades.txt";
    private Integer numDecades = 0;
    private final String arrayField = "entries";

    public String getDecadeFileName() {
        return DecadeFileName;
    }

    public Integer getNumDecades() {
        return numDecades;
    }


    public void loadDecades(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + DecadeFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Decades.put(count,line);
                count++;
            }
            numDecades = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getDecade(Integer index) {
        return Decades.get(index);
    }
    
    public void loadFromJSON(JSONObject decadeDataset) {
        JSONArray entries = decadeDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Decades.put(i, entry);
        }
        numDecades = entries.length();
    }
}
