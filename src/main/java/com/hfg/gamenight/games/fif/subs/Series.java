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
public class Series {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Series = new HashMap<>();
    private String SeriesFileName = "series.txt";
    private Integer numSeries = 0;

    public String getSeriesFileName() {
        return SeriesFileName;
    }

    public Integer getNumSeries() {
        return numSeries;
    }

    public void loadSeries(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + SeriesFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Series.put(count,line);
                count++;
            }
            numSeries = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getSeries(Integer index) {
        return Series.get(index);
    }
    
    public void loadFromJSON(JSONObject seriesDataset) {
        JSONArray entries = seriesDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Series.put(i, entry);
        }
        numSeries = entries.length();
    }
}
