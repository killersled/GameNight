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
public class Leagues {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Leagues = new HashMap<>();
    private String LeagueFileName = "leagues.txt";
    private Integer numLeagues = 0;

    public String getLeagueFileName() {
        return LeagueFileName;
    }

    public Integer getNumLeagues() {
        return numLeagues;
    }

    public void loadLeagues(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + LeagueFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Leagues.put(count,line);
                count++;
            }
            numLeagues = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getLeague(Integer index) {
        return Leagues.get(index);
    }
    
    public void loadFromJSON(JSONObject leagueDataset) {
        JSONArray entries = leagueDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Leagues.put(i, entry);
        }
        numLeagues = entries.length();
    }
}
