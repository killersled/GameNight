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
public class Subjects {
    
    private final String arrayField = "entries";
    private HashMap<Integer, String> Subjects = new HashMap<>();
    private String SubjectFileName = "subjects.txt";
    private Integer numSubjects = 0;

    public String getSubjectFileName() {
        return SubjectFileName;
    }

    public Integer getNumSubjects() {
        return numSubjects;
    }

    public void loadSubjects(String baseDir) {
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader(baseDir + SubjectFileName));
            String line;
            Integer count = 0;
            while ((line = myBuffer.readLine()) != null) {
                Subjects.put(count,line);
                count++;
            }
            numSubjects = count;
            myBuffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getSubject(Integer index) {
        return Subjects.get(index);
    }
    
    
    public void loadFromJSON(JSONObject subjectDataset) {
        JSONArray entries = subjectDataset.getJSONArray(arrayField);
        for (int i = 0; i < entries.length(); i++) {
            String entry = entries.getString(i);
            Subjects.put(i, entry);
        }
        numSubjects = entries.length();
    }
}
