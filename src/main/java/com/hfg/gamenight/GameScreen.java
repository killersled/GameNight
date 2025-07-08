/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight;

import com.hfg.gamenight.games.Connections;
import com.hfg.gamenight.games.FactsInFive;
import com.hfg.gamenight.games.GuessTheNumber;
import com.hfg.gamenight.games.NoDiceClue;
import com.hfg.gamenight.games.SpellingBee;
import com.hfg.gamenight.games.TopFive;
import com.hfg.gamenight.games.Wordle;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author jkelley
 */
public class GameScreen implements ActionListener {
    private final JLabel gameLabel = new JLabel("Select Your Game: ");
    private final JButton playButton = new JButton("Play");
    private JList gameList = null;
    private final JFrame frame = new JFrame();
    private String selectedOption = "";
    private final String[] gameNameList = {"Top Five", "Guess The Number", "Connections", "Facts In Five", "No Dice Clue", "Wordle", "SpellingBee"};
    
    public void display() {
        // The button
        playButton.addActionListener(this);
        // Dealing with the list of games.
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String gameName : gameNameList) {
            model.addElement(gameName);
        }
        gameList = new JList<>(model);
        this.gameList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Ensure the event fires only once after selection is complete
                String selectedGame = (String) gameList.getSelectedValue();
                if (selectedGame != null) {
                    selectedOption = selectedGame;
                }
            }
        });
        //Position everything
        setupScreen();
        // Set the frame size and layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 375);
        frame.setLayout(null);

        // Set the frame visibility to true
        frame.setVisible(true);
        
    }
    
    private void setupScreen() {
        //Positioning
        playButton.setBounds(250, 275, 100, 50);
        gameLabel.setBounds(50, 50, 200, 30);
        gameList.setBounds(100, 100, 400, 150);
        
        //Adding elements
        frame.add(playButton);
        frame.add(gameLabel);
        frame.add(this.gameList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (selectedOption.isEmpty()) {
            System.out.println("Uh, what I am I supposed to do here?");
        } else if (selectedOption.equals("Top Five")) {
            TopFive curGame = new TopFive();
            curGame.runMe();
        } else if (selectedOption.equals("Guess The Number")) {
            GuessTheNumber curGame = new GuessTheNumber();
            curGame.runMe();
        } else if (selectedOption.equals("Connections")) {
            Connections curGame = new Connections();
            curGame.runMe();
        } else if (selectedOption.equals("Facts In Five")) {
            FactsInFive curGame = new FactsInFive();
            curGame.runMe();
        } else if (selectedOption.equals("No Dice Clue")) {
            NoDiceClue curGame = new NoDiceClue();
            curGame.runMe();
        } else if (selectedOption.equals("SpellingBee")) {
            SpellingBee curGame = new SpellingBee();
            curGame.runMe();
        } else {
            Wordle curGame = new Wordle();
            curGame.runMe();
        }
                
    }
}
