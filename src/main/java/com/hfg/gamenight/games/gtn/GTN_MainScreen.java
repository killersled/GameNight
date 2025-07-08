/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.gtn;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.JFrame;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class GTN_MainScreen implements ActionListener {
    private final String startButtonName = "StartButton";
    private final String closeButtonName = "CloseButton";
    private final String changeButtonName = "ChangeFileButton";
    private final String cbHardName = "HardMode";
    private final String cbEasyName = "EasyMode";
    private final String cbRandomName = "RandomMode";
    private final String cb5RoundName = "5Round";
    private final String cb10RoundName = "10Round";
    private final String cb20RoundName = "20Round";
    private final String regexString = "^^^";
    private String dataFile = ""; //Use default value in DataMap class
    private GTN_DataMap myData = new GTN_DataMap();
    private final String fileLabelPre = "Data File: ";
    private Label fileLabel = new Label(myData.dataFileName);
    private List datasetList = null;
    private JFrame frame = new JFrame();
    private boolean useJSON = true;

    public void MainScreen(String filePath) {
        
        if (!filePath.isEmpty()) {
            dataFile = filePath;
        }
        // Create a frame
        
        frame.setTitle("Guess the Year");
        frame.setName("GTYMain");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Button startButton = new Button("Start Game");
        startButton.setName(startButtonName);
        startButton.addActionListener(this);
        startButton.setBounds(450, 375, 100, 55);
        
        Button closeButton = new Button("Close");
        closeButton.setName(closeButtonName);
        closeButton.addActionListener(this);
        closeButton.setBounds(450, 500, 100, 30);
        
        // Rounds
        CheckboxGroup rounds = new CheckboxGroup();
        
        Checkbox rounds5 = new Checkbox("5", rounds, false);
        Checkbox rounds10 = new Checkbox("10", rounds, true);
        Checkbox rounds20 = new Checkbox("20", rounds, false);
        rounds5.setName(cb5RoundName);
        rounds10.setName(cb10RoundName);
        rounds20.setName(cb20RoundName);

        rounds5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        rounds20.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        rounds10.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        Label roundsLabel = new Label("Number of Rounds:");
        roundsLabel.setBounds(90, 25, 130, 50);
        
        rounds5.setBounds(220, 50, 50, 30);
        rounds10.setBounds(220, 85, 50, 30);
        rounds20.setBounds(220, 120, 50, 30);
        
        //Mode
        CheckboxGroup mode = new CheckboxGroup();
        
        Checkbox hardMode = new Checkbox("Hard", mode, false);
        Checkbox randomMode = new Checkbox("Random", mode, true);
        Checkbox easyMode = new Checkbox("Easy", mode, false);
        
        hardMode.setName(cbHardName);
        randomMode.setName(cbRandomName);
        easyMode.setName(cbEasyName);
        
        hardMode.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        randomMode.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        easyMode.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        
        Label modeLabel = new Label("Game Mode:");
        modeLabel.setBounds(600, 25, 100, 50);
        
        hardMode.setBounds(700, 50, 90, 30);
        randomMode.setBounds(700, 85, 90, 30);
        easyMode.setBounds(700, 120, 90, 30);
        if (useJSON) {
            myData.readJSONDatasets();
            JSONArray datasetArray = myData.getDatasets();
            datasetList = new List(datasetArray.length());
            Label datasetLabel = new Label("Dataset(s):");
            datasetLabel.setBounds(275, 165, 100, 30);
            // Setting List Postition
            datasetList.setBounds(300, 200, 400, 150);

            for (int i = 0; i < datasetArray.length(); i++) {
                JSONObject curObj = datasetArray.getJSONObject(i);
                datasetList.add(curObj.getString("dataset_name"));
            }
            datasetList.setMultipleMode(true);
            frame.add(datasetLabel);
            frame.add(datasetList);
        } else {
            //Label preFileLabel = new Label(fileLabelPre);
            //preFileLabel.setBounds(225, 200, 90, 30);
            //frame.add(preFileLabel);
            //fileLabel.setBounds(325, 200, 500, 30);
            //frame.add(fileLabel);
            //Button changeButton = new Button("Change File");
            //changeButton.addActionListener(this);
            //changeButton.setBounds(400, 235, 100, 30);
            //changeButton.setName(changeButtonName);
            //frame.add(changeButton);
        }
        // Add everything to the frame
        frame.add(startButton);
        frame.add(closeButton);
        frame.add(rounds5);
        frame.add(rounds10);
        frame.add(rounds20);
        frame.add(roundsLabel);
        frame.add(modeLabel);
        frame.add(hardMode);
        frame.add(randomMode);
        frame.add(easyMode);

        
        // Set the frame size and layout
        frame.setSize(1000, 600);
        frame.setLayout(null);

        // Set the frame visibility to true
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Button curButton = (Button) e.getSource();
        String buttonName = curButton.getName();
        if (buttonName.equals(closeButtonName)) {
            frame.setVisible(false);
            frame.dispose();
        } else if (buttonName.equals(changeButtonName)) {
            // Change data file
            FileDialog fd = new FileDialog(frame, "Choose the csv data file", FileDialog.LOAD);
            fd.setBounds(500, 100, 100, 50);
            fd.setVisible(true);
            if (fd.getFile() != null) {
                String fullPath = fd.getDirectory() + fd.getFile();
                
                System.out.println("Selected file: " + fullPath);
                fileLabel.setText(fullPath);
                myData.setDataFileName(fullPath);  
                myData.resetData();
            }
        } else {
            //Start Game button pressed
            Frame curFrame = (Frame) curButton.getParent();
            GTN_GameScreen myDisplay = new GTN_GameScreen();
            int numRounds = 20; //default
            myData.setHardMode(true); //default
        
            if (useJSON) {
                myData.resetData();
                int[] selectedIndices = datasetList.getSelectedIndexes();
                if (selectedIndices.length == 0) {
                     int numDatasets = myData.getDatasetSize();
                     for (int i = 0; i < numDatasets; i++) {
                         myData.createMapJSON(i);
                     }
                } 
                for (int ind : selectedIndices) {
                    myData.createMapJSON(ind);
                } 
                
                
            } else {
                if (!dataFile.isEmpty()) {
                    myData.setDataFileName(dataFile);
                }
                try {
                    myData.createMap();
                } catch (FileNotFoundException ex) {
                    System.out.println("File was not found.");
                } catch (IOException ex) {
                    System.out.println("An IO Exception occured");
                }
            }
            for (Component comp : curFrame.getComponents()) {
                if (comp.getName().equals(cbHardName) || 
                        comp.getName().equals(cbEasyName) || comp.getName().equals(cbRandomName)) {
                    //Mode
                    Checkbox curBox = (Checkbox) comp;
                    if (curBox.getState()) {
                        //Selected state
                        System.out.println(curBox.getName() + "  ::  " + curBox.getState());
                        if (curBox.getName().equals(cbHardName)) {
                            myData.setHardMode(true);
                        } else {
                            myData.setHardMode(false);
                        }
                        if (curBox.getName().equals(cbEasyName)) {
                            myData.setEasyMode(true);
                        } else {
                            myData.setEasyMode(false);
                        }
                    }
                } else if (comp.getName().equals(cb5RoundName) || 
                                comp.getName().equals(cb10RoundName) || comp.getName().equals(cb20RoundName)) {
                    // Num rounds 
                    Checkbox curBox = (Checkbox) comp;
                    if (curBox.getState()) {
                        //Selected state
                        System.out.println(curBox.getName() + "  ::  " + curBox.getState());
                        if (curBox.getName().equals(cb5RoundName)) {
                            numRounds = 5;
                        } else if (curBox.getName().equals(cb10RoundName)) {
                            numRounds = 10;
                        }
                    }
                } 
            }
        
            //Randomly get target year
            ArrayList<Integer> commonYears = myData.getCommonYears(numRounds);
            ArrayList<ArrayList<String>> allEvents = new ArrayList<>();
            for (Integer targetYear : commonYears) {
                Integer offYear = myData.getOtherYear(targetYear);
                ArrayList<String> events = new ArrayList<>();
                HashSet<String> targetEvents = myData.getEvents(targetYear, 3);
                for (String event : targetEvents) {
                    events.add(targetYear + regexString + event);
                }
                HashSet<String> offEvent = myData.getEvents(offYear, 1);           
                for (String event : offEvent) {
                    events.add(offYear + regexString + event);
                }
                Collections.shuffle(events);
                allEvents.add(events);
            }
            myDisplay.setNumRounds(numRounds);
            myDisplay.setAllEvents(allEvents);
            myDisplay.Display(1, allEvents.get(0));
            System.out.println("Gonna start any second now");
        }
    }
    
}
