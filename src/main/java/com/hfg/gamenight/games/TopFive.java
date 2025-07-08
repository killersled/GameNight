/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games;

import com.hfg.gamenight.games.t5.T5_GameScreen;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class TopFive {
    public void runMe() {
        T5_GameScreen myGS = new T5_GameScreen();
        String filePath = "./data/top_5_data.json";
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // Access data using keys
            JSONArray datasets = jsonObject.getJSONArray("datasets");
            
            myGS.setUpSeenIt(datasets);
            myGS.display();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
