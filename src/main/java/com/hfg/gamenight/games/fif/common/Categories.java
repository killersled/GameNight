/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.fif.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class Categories {
    private final HashMap<Integer, String> Categories = new HashMap<>();
    private final String CatFileName = "categories.txt";
    private Integer numCats = 0;
    private final String arrayField = "entries";

    public void loadCategories(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + CatFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Categories.put(count,line);
                count++;
            }
            numCats = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getNumCats() {
        return numCats;
    }

    public String getCategory(Integer index) {
        return Categories.get(index);
    }
    
    public void loadFromJSON(JSONObject categoryDataset) {
        JSONArray entries = categoryDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Categories.put(i, entry);
        }
        numCats = entries.length();
    }
}
