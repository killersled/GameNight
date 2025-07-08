/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.connections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class CONN_DataMap {
    public HashMap<String, HashSet<String>> years = new HashMap<>();
    final private int CommonElements = 3;
    final private Random dataMapRand = new Random();
    private boolean hardMode = true;
    private boolean easyMode = false;
    final private int hardModeMax = 4;
    final private int easyModeMin = 20;
    public String dataFileName = "../data/datasets.csv"; //default value
    private JSONArray dsCats;
    private JSONArray datasets;
    private ArrayList<Integer> randomCats = new ArrayList<>();
    private ArrayList<String> termList = new ArrayList<>();    
            

    public CONN_DataMap() {
        dataMapRand.setSeed(System.currentTimeMillis());
    }
    
    public ArrayList<String> getFourCategory() {
        Set keys = years.keySet();
        int size = keys.size();
        ArrayList<String> selectCategories = new ArrayList<>();
        
        boolean haveFourCategories = false;

        while (!haveFourCategories) {
            
        }
        return selectCategories;
    }
    
    
    public HashSet<String> getEvents(Integer year, int eventCount) {
        HashSet<String> events = years.get(year);
        ArrayList<String> eventList = new ArrayList<>();
        HashSet<String> newSet = new HashSet<>();
        
        
        Iterator eventIt = events.iterator();
        while (eventIt.hasNext()) {
            String curEvent = (String) eventIt.next();
            eventList.add(curEvent);
        }
        
        Collections.shuffle(eventList);
        for (int i = 0; i < eventCount; i++) {
            String curEvent = eventList.get(i);
            newSet.add(curEvent);
        }
        return newSet;
    }
    
    public void setHardMode(boolean value) {
        hardMode = value;
    }
    
    public void setEasyMode(boolean value) {
        easyMode = value;
    }
    
    public void setDataFileName(String value) {
        dataFileName = value;
    }
    
    public void resetData() {
        years = new HashMap<>();
    }
    
    public void readJSONDatasets() {
        String filePath = "./data/connections_datasets.json";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // Access data using keys
            this.datasets = jsonObject.getJSONArray("datasets");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
    }
    
    public void createMapJSON(int index) {
        
        JSONObject dsObject = this.datasets.getJSONObject(index);
        
        dsCats = dsObject.getJSONArray("Categories");
        
        
        boolean haveCats = false;
        boolean haveTerms = false;
        
        while (!haveCats) {
            Integer possibleCat = dataMapRand.nextInt(dsCats.length());
            if (randomCats.contains(possibleCat)) {
                continue;
            }
            randomCats.add(possibleCat);
            if (randomCats.size() == 4) {
                haveCats = true;
            }
        }
        
        
        for (int i = 0; i < randomCats.size(); i++) {
            JSONObject cat = dsCats.getJSONObject(randomCats.get(i));
            JSONArray terms = cat.getJSONArray("terms");
            haveTerms = false;
            int termCount = 0;
            ArrayList<String> temptermList = new ArrayList<>();
            while (!haveTerms) {
                for (int y = 0; y < terms.length(); y++) {
                    if (dataMapRand.nextBoolean()) {
                        String term = terms.getString(y);
                        if (temptermList.contains(term)) {
                            continue;
                        }
                        temptermList.add(term);
                        termList.add(term + "^" + randomCats.get(i));
                        termCount++;
                        if (termCount == 4) {
                            haveTerms = true;
                            break;
                        }
                    }
                }
            }
            
        }
        Collections.shuffle(termList);
        
    }
    
    public String getCategoryName(int index) {
        JSONObject ds = dsCats.getJSONObject(index);
        return ds.getString("name");
    }
    
    public String getCategoryTerms(Integer cat) {
        StringBuilder catTermList = new StringBuilder();
        String catString = cat.toString();
        int termCount = 0;
        for (int i = 0; i < termList.size(); i++) {
            String term = termList.get(i);
            if (!term.contains("^" + catString)) {
                continue;
            }
            String[] parts = term.split("\\^");
            if (parts[1].equals(catString)) {
                catTermList.append(parts[0]);
                termCount++;
                if (termCount < 4) {
                   catTermList.append(", ");
                }
            }
        }
        return catTermList.toString();
    }
    
    public Integer getCategoryNumberbyIndex(int index) {
        return randomCats.get(index);
    }
    
    public String getTermbyIndex(int index) {
        String term = termList.get(index);
        String[] parts = term.split("\\^");
        return parts[0];
    }
    
    public String getCatbyIndex(int index) {
        String term = termList.get(index);
        String[] parts = term.split("\\^");
        return parts[1];
    }
    
    public void clearDM() {
        randomCats.clear();
        termList.clear();
    }
}
