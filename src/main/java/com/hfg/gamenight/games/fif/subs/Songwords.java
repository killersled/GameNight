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
public class Songwords {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> SongWords = new HashMap<>();
    private String SongWordFileName = "songwords.txt";
    private Integer numSongWords = 0;

    public String getSongWordFileName() {
        return SongWordFileName;
    }

    public Integer getNumSongWords() {
        return numSongWords;
    }

    public void loadSongWords(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + SongWordFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                SongWords.put(count,line);
                count++;
            }
            numSongWords = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getSongWord(Integer index) {
        return SongWords.get(index);
    }
    
    public void loadFromJSON(JSONObject songwordDataset) {
        JSONArray entries = songwordDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            SongWords.put(i, entry);
        }
        numSongWords = entries.length();
    }
}
