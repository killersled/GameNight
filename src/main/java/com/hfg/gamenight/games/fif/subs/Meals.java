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
public class Meals {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Meals = new HashMap<>();
    private String MealFileName = "meals.txt";
    private Integer numMeals = 0;

    public String getMealFileName() {
        return MealFileName;
    }

    public Integer getNumMeals() {
        return numMeals;
    }


    public void loadMeals(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + MealFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Meals.put(count,line);
                count++;
            }
            numMeals = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getMeal(Integer index) {
        return Meals.get(index);
    }
    
    public void loadFromJSON(JSONObject mealDataset) {
        JSONArray entries = mealDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Meals.put(i, entry);
        }
        numMeals = entries.length();
    }
}
