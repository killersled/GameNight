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
public class Colors {
    private HashMap<Integer, String> Colors = new HashMap<>();
    private String ColorFileName = "colors.txt";
    private Integer numColors = 0;
    private final String arrayField = "entries";

    public String getColorFileName() {
        return ColorFileName;
    }

    public Integer getNumColors() {
        return numColors;
    }


    public void loadColors(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + ColorFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Colors.put(count,line);
                count++;
            }
            numColors = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getColor(Integer index) {
        return Colors.get(index);
    }
    
    public void loadFromJSON(JSONObject colorDataset) {
        JSONArray entries = colorDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Colors.put(i, entry);
        }
        numColors = entries.length();
    }
}
