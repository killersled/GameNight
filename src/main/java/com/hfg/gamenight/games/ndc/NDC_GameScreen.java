/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.ndc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author jkelley
 */
public class NDC_GameScreen implements ActionListener {
    
    private final String[] weaponOptions = {"None", "Candlestick", "Dagger", "Pipe", "Revolver", "Rope", "Wrench"};
    private final String[] suspectOptions = {"None", "Miss Scarlet", "Colonel Mustard", "Mrs. White", "Mr. Green", "Mrs. Peacock", "Professor Plum"};
    private final String[] roomOptions = {"None", "Hall", "Lounge", "Dining Room", "Kitchen", "Ballroom", "Conservatory", "Billiard Room", "Library", "Study"};
    private final String[] winLines = {"Winner Winner, Chicken Dinner!!", 
                                        "Oooh! That’s a Bingo!!", 
                                        "Orange Whips all around!!", 
                                        "You get a car, and you get a…",
                                        "You struck gold!!",
                                        "You hit the jackpot!!"};
    private final Random gsRand = new Random();
    private String selectedWeapon = "";
    private String selectedRoom = "";
    private String selectedSuspect = "";
    private final JComboBox<String> weaponComboBox = new JComboBox<>(weaponOptions);
    private final JComboBox<String> suspectComboBox = new JComboBox<>(suspectOptions);
    private final JComboBox<String> roomComboBox = new JComboBox<>(roomOptions);
    private final JComboBox<String> resultBox = new JComboBox<>();
    private final JButton selectButton = new JButton("Select");
    JLabel roomLabel = new JLabel("Select Room:");
    JLabel suspectLabel = new JLabel("Select Culprit:");
    JLabel weaponLabel = new JLabel("Select Weapon:");
    private final NDC_MenuHandler menuHandler = new NDC_MenuHandler();
    private final JFrame frame = new JFrame("No Dice Clue");
    private final Integer defaultWidth = 1000;
    private final Integer defaultHeight = 450;
    private final Double labelRowY = 0.13333;
    private final Double labelH = 0.06667;
    private final Double labelW = 0.095;
    private final Double comboBoxY = 0.11111; 
    private final Double comboBoxH = 0.11111;
    private final Double comboBoxW = 0.16;
    private final Double roomLabelX = 0.05;
    private final Double suspectLabelX = 0.33;
    private final Double weaponLabelX = 0.61;
    private final Double roomComboBoX = 0.15;
    private final Double suspectComboBoX = 0.43;
    private final Double weaponComboBoX = 0.71;
    private final Double selectButtonW = 0.1;
    private final Double resultBoxW = 0.8;
    private final Double selectButtonX = 0.45;
    private final Double resultBoxX = 0.1;
    private final Double selectButtonY = 0.27778;
    private final Double resultBoxY = 0.44444;

    public NDC_GameScreen() {
        gsRand.setSeed(System.currentTimeMillis());
        selectCrime();
    }
    
    
     public void Display() {
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(defaultWidth, defaultHeight);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem maxItem = new JMenuItem("Maximize");
        maxItem.addActionListener(menuHandler);
        
        menuHandler.setRL(roomLabel);
        menuHandler.setSL(suspectLabel);
        menuHandler.setWL(weaponLabel);
        menuHandler.setWCB(weaponComboBox);
        menuHandler.setRCB(roomComboBox);
        menuHandler.setSCB(suspectComboBox);
        menuHandler.setRB(resultBox);
        menuHandler.setSB(selectButton);
        menuHandler.setGS(frame);
        fileMenu.add(maxItem);
        fileMenu.addSeparator();

        // Create an "Exit" menu item with an action listener
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(menuHandler);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        JPanel panel = new JPanel();
        //panel.setLayout(new FlowLayout());

       
        Double Y = labelRowY * defaultHeight;
        Double H = labelH * defaultHeight;
        Double W = labelW * defaultWidth;
        Double X = roomLabelX * defaultWidth;
        roomLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = suspectLabelX * defaultWidth;
        suspectLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = weaponLabelX * defaultWidth;
        weaponLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = comboBoxY * defaultHeight; // also H
        W = comboBoxW * defaultWidth;
        X = roomComboBoX * defaultWidth;
        roomComboBox.setBounds(X.intValue(), Y.intValue(), W.intValue(), Y.intValue());
        X = suspectComboBoX * defaultWidth;
        suspectComboBox.setBounds(X.intValue(), Y.intValue(), W.intValue(), Y.intValue());
        X = weaponComboBoX * defaultWidth;
        weaponComboBox.setBounds(X.intValue(), Y.intValue(), W.intValue(), Y.intValue());
        frame.add(roomLabel);
        frame.add(roomComboBox);
        frame.add(weaponLabel);
        frame.add(weaponComboBox);
        frame.add(suspectLabel);
        frame.add(suspectComboBox);
        
        H = comboBoxY * defaultHeight;
        W = selectButtonW * defaultWidth;
        X = selectButtonX * defaultWidth;
        Y = selectButtonY * defaultHeight;
        selectButton.addActionListener(this);
        selectButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        frame.add(selectButton);
        W = resultBoxW * defaultWidth;
        X = resultBoxX * defaultWidth;
        Y = resultBoxY * defaultHeight;
        resultBox.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        //resultBox.setFont(normalFont);
        //JScrollPane rb = new JScrollPane(resultBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        frame.add(resultBox);
        frame.add(panel);
        frame.setVisible(true);
    }
     
     private void selectCrime() {
        int weapon = 0;
        int suspect = 0;
        int room = 0;
        while (weapon < 1) {
            weapon = gsRand.nextInt(1, weaponOptions.length);
        }
        selectedWeapon = weaponOptions[weapon];
        while (suspect < 1) {
            suspect = gsRand.nextInt(suspectOptions.length);
        }
        selectedSuspect = suspectOptions[suspect];
        while (room < 1) {
            room = gsRand.nextInt(roomOptions.length);
        }
        selectedRoom = roomOptions[room];
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (selectButton.getText().equals("Reset")) {
            selectCrime();
            resultBox.removeAllItems();
            selectButton.setText("Select");
            roomComboBox.setSelectedIndex(0);
            weaponComboBox.setSelectedIndex(0);
            suspectComboBox.setSelectedIndex(0);
        } else {
            boolean weaponMatch = false;
            boolean suspectMatch = false;
            boolean roomMatch = false;
            String weapon = (String)weaponComboBox.getSelectedItem();
            String suspect = (String)suspectComboBox.getSelectedItem();
            String room = (String)roomComboBox.getSelectedItem();
            if (weapon.equals(selectedWeapon)) {
                weaponMatch = true;
            } 
            if (suspect.equals(selectedSuspect)) {
                suspectMatch = true;
            }
            if (room.equals(selectedRoom)) {
                roomMatch = true;
            }

            if (weaponMatch && roomMatch && suspectMatch) {
                String winLine = winLines[gsRand.nextInt(winLines.length)];
                resultBox.addItem(winLine);
                selectButton.setText("Reset");
            } else if (weaponMatch && roomMatch) {
                resultBox.addItem(suspectComboBox.getSelectedItem() + " has a solid alibi, boss.");
            } else if (weaponMatch && suspectMatch) {
                resultBox.addItem(roomComboBox.getSelectedItem() + " does not seem to be the murder location, boss.");
            } else if (roomMatch && suspectMatch) {
                resultBox.addItem(weaponComboBox.getSelectedItem() + " does not seem to be the right weapon, boss.");
            } else if (weaponMatch) {
                int hint = gsRand.nextInt(2);
                if (hint == 0) {
                    resultBox.addItem(suspectComboBox.getSelectedItem() + " has a solid alibi, boss.");
                } else {
                    resultBox.addItem(roomComboBox.getSelectedItem() + " does not seem to be the murder location, boss.");
                }
            } else if (roomMatch) {
                int hint = gsRand.nextInt(2);
                if (hint == 0) {
                    resultBox.addItem(suspectComboBox.getSelectedItem() + " has a solid alibi, boss.");
                } else {
                    resultBox.addItem(weaponComboBox.getSelectedItem() + " does not seem to be the right weapon, boss.");
                }
            } else if (suspectMatch) {
                int hint = gsRand.nextInt(2);
                if (hint == 0) {
                    resultBox.addItem(roomComboBox.getSelectedItem() + " does not seem to be the right location, boss.");
                } else {
                    resultBox.addItem(weaponComboBox.getSelectedItem() + " does not seem to be the right weapon, boss.");
                }
            } else {
                int hint = gsRand.nextInt(3);
                if (hint == 0) {
                    resultBox.addItem(roomComboBox.getSelectedItem() + " is not the right location, boss.");
                } else if (hint == 0) {
                    resultBox.addItem(suspectComboBox.getSelectedItem() + " has a solid alibi, boss.");
                } else {
                    resultBox.addItem(weaponComboBox.getSelectedItem() + " does not seem to be the right weapon, boss.");
                }
            }  
            int num = resultBox.getItemCount();
            resultBox.setSelectedIndex(num - 1);
        }
    }
    
}
