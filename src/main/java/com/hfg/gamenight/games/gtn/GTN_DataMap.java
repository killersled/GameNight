/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.gtn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class GTN_DataMap {
    public HashMap<Integer, HashSet<String>> years = new HashMap<>();
    final private int CommonElements = 3;
    final private Random dataMapRand = new Random();
    private boolean hardMode = true;
    private boolean easyMode = false;
    final private int hardModeMax = 4;
    final private int easyModeMin = 20;
    public String dataFileName = "../data/events.csv"; //default value
    private JSONArray datasets;
    
            

    public GTN_DataMap() {
        dataMapRand.setSeed(System.currentTimeMillis());
    }
    
    
    public void createMap() throws FileNotFoundException, IOException {
        //read CSV
        BufferedReader br = new BufferedReader(new FileReader(dataFileName));
        try {
            String line = br.readLine();
            while (line != null) {
                
                String[] parts = line.split(",");
                if (!parts[0].equals("Year")) {
                    String event = parts[1];
                    if (parts.length > 2) {
                        for (int i = 2; i < parts.length; i++) {
                            event = event.concat(",");
                            event = event.concat(parts[i]);
                        }
                    }
                    event = event.replaceAll("#", ",");
                    if (years.keySet().contains(parts[0])) {
                        HashSet<String> tempArr = years.get(parts[0]);
                        tempArr.add(event);
                        Integer convertedYear = Integer.parseInt(parts[0]);
                        years.put(convertedYear, tempArr);
                        //System.out.println("Need to append " + event + " to Set for " + parts[0]);
                    } else {
                        HashSet<String> newArr = new HashSet<>();
                        newArr.add(event);
                        Integer convertedYear = Integer.parseInt(parts[0]);
                        years.put(convertedYear, newArr);
                        //System.out.println("Created entry for " + parts[0] + " and need to append " + event);
                    }
                }
                line = br.readLine();
            }
            Set entries = years.keySet();
            Iterator myIt = entries.iterator();
            
        } finally {
            br.close();
        }
        //write JSON
    }
    
    public ArrayList<Integer> getCommonYears(int numYears) {
        Set keys = years.keySet();
        int size = keys.size();
        ArrayList<Integer> commonYears = new ArrayList<>();
        
        for (int x = 0; x < numYears; x++) {
            boolean haveGoodItem = false;

            while (!haveGoodItem) {
                int i = 0;
                int item = dataMapRand.nextInt(size);
                for(Object obj : keys) {
                    if (i == item) {
                        HashSet<String> events = years.get(obj);
                        if (events.size() >= CommonElements && !commonYears.contains((Integer)obj)) {
                            haveGoodItem = true;
                            commonYears.add((Integer) obj);
                            break;
                        } else {
                            //need new target, restart for loop
                            break;
                        }
                    }
                    i++;
                }   
            }
        }
        return commonYears;
    }
    
    public Integer getOtherYear(Integer targetYear) {
        Integer retVal = 0;
        Set keys = years.keySet();
        int size = keys.size();
        
        boolean haveGoodItem = false;
        
        while (!haveGoodItem) {
            int i = 0;
            int item = dataMapRand.nextInt(size);
            for(Object obj : keys) {
                if (i == item) {
                    Integer year = (Integer) obj;
                    if (!hardMode && !easyMode) {
                        if (year != targetYear) {
                            haveGoodItem = true;
                            retVal = (Integer) obj;
                            break;
                        }
                    } else if (easyMode) {
                        if (year != targetYear && (Math.abs(targetYear - year) >= easyModeMin)) {
                            haveGoodItem = true;
                            retVal = (Integer) obj;
                            break;
                        }
                    } else {
                        if (year != targetYear && (Math.abs(targetYear - year) <= hardModeMax)) {
                            haveGoodItem = true;
                            retVal = (Integer) obj;
                            break;
                        }
                    }
                }
                i++;
            }   
        }
        return retVal;
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
        File directory = new File("./"); // Replace with your directory path
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("Directory not found or is not a directory.");
            }
        String filePath = "./data/GTN_datasets.json";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // Access data using keys
            this.datasets = jsonObject.getJSONArray("datasets");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
    }
    
    public JSONArray getDatasets() {
        return this.datasets;
    }
    
    public void createMapJSON(int index) {
        
        JSONObject dsObject = this.datasets.getJSONObject(index);
        String event_tag = dsObject.getString("event_tag");
        JSONArray dsYears = dsObject.getJSONArray("years");
        for (int i = 0; i < dsYears.length(); i++) {
            JSONObject year = dsYears.getJSONObject(i);
            JSONArray events = year.getJSONArray(event_tag);
            Integer curYear = (Integer) year.getNumber("year");
            for (int y = 0; y < events.length(); y++) {
                String event = events.getString(y);
                if (years.keySet().contains(curYear)) {
                    HashSet<String> tempArr = years.get(curYear);
                    tempArr.add(event);
                    years.put(curYear, tempArr);
                } else {
                    HashSet<String> newArr = new HashSet<>();
                    newArr.add(event);
                    years.put(curYear, newArr);
                }
                if (curYear.equals(1973)) {
                    System.out.println(event);
                }
            }
        }
    }
    
    public int getDatasetSize() {
        return this.datasets.length();
    }
}

