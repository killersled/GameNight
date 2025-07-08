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
public class Regions {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Regions = new HashMap<>();
    private String RegionFileName = "regions.txt";
    private Integer numRegions = 0;

    public String getRegionFileName() {
        return RegionFileName;
    }

    public Integer getNumRegions() {
        return numRegions;
    }


    public void loadRegions(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + RegionFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Regions.put(count,line);
                count++;
            }
            numRegions = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getRegion(Integer index) {
        return Regions.get(index);
    }
    
    public void loadFromJSON(JSONObject regionDataset) {
        JSONArray entries = regionDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Regions.put(i, entry);
        }
        numRegions = entries.length();
    }
}
