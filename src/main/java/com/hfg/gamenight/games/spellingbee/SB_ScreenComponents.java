/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.spellingbee;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author jkelley
 */
public class SB_ScreenComponents {
    public final Double usualH = 0.05;
    public final Double usualW = 0.125;
    public final Double fourX =  0.0625;
    public final Double fiveX = 0.2125;
    public final Double sixX = 0.3625;
    public final Double sevenX = 0.5125;
    public final Double labelRowY = 0.05;
    public final Double rowSevenY = 0.50833;
    public final Double rowSixY = 0.44167;
    public final Double rowFiveY = 0.375;
    public final Double rowFourY = 0.30833;
    public final Double rowThreeY = 0.24167;
    public final Double rowTwoY = 0.175;
    public final Double rowOneY = 0.10833;
    public final Double rootY = 0.08333;
    public final Double rootLabelX = 0.675;
    public final Double rootWordX = 0.8;
    public final Double otherX = 0.75;
    public final Double guessW = 0.1875;
    public final Double submitH = 0.08333;
    public final Double submitW = 0.125;
    public final Double submitWY = 0.33333;
    public final Double guessY = 0.26667;
    public final Double remainW = 0.25;
    public final Double submitBY = 0.43333;
    public final Double remainY = 0.16667;
    public final JFrame frame = new JFrame("SpellingBee");
    public final JLabel four1 = new JLabel();
    public final JLabel four2 = new JLabel();
    public final JLabel four3 = new JLabel();
    public final JLabel four4 = new JLabel();
    public final JLabel four5 = new JLabel();
    public final JLabel four6 = new JLabel();
    public final JLabel four7 = new JLabel();
    public final JLabel five1 = new JLabel();
    public final JLabel five2 = new JLabel();
    public final JLabel five3 = new JLabel();
    public final JLabel five4 = new JLabel();
    public final JLabel five5 = new JLabel();
    public final JLabel five6 = new JLabel();
    public final JLabel five7 = new JLabel();
    public final JLabel six1 = new JLabel();
    public final JLabel six2 = new JLabel();
    public final JLabel six3 = new JLabel();
    public final JLabel six4 = new JLabel();
    public final JLabel six5 = new JLabel();
    public final JLabel six6 = new JLabel();
    public final JLabel six7 = new JLabel();
    public final JLabel seven1 = new JLabel();
    public final JLabel seven2 = new JLabel();
    public final JLabel seven3 = new JLabel();
    public final JLabel seven4 = new JLabel();
    public final JLabel seven5 = new JLabel();
    public final JLabel seven6 = new JLabel();
    public final JLabel seven7 = new JLabel();
    public final Color hiddenLabel = seven7.getBackground();
    public final JButton submitButton = new JButton("Submit");
    public final JTextArea submitWord = new JTextArea();
    public final JLabel fourLetterLabel = new JLabel("4 Letters");
    public final JLabel fiveLetterLabel = new JLabel("5 Letters");
    public final JLabel sixLetterLabel = new JLabel("6 Letters");
    public final JLabel sevenLetterLabel = new JLabel("7 Letters");
    public final JLabel rootWordLabel = new JLabel("Root Word:");
    public final JLabel rootWord = new JLabel("ARGUMENT");
    public final JLabel remainingWords = new JLabel();
    public Integer wordCount = 0;
    public final Color correctWord = new Color(0,150,0);
    public final Color rootWordColor = new Color(0,0,150);
    public final JLabel guessLabel = new JLabel("Enter your guess:");
    public final Integer defaultHeight = 500;
    public final Integer defaultWidth = 800;
    public final ArrayList<Component> wordLabels = new ArrayList<>();
    public final JComboBox resultBox = new JComboBox();
    
    public void addComponentsToFrame() {
        frame.add(fourLetterLabel);
        frame.add(four1);
        frame.add(four2);
        frame.add(four3);
        frame.add(four4);
        frame.add(four5);
        frame.add(four6);
        frame.add(four7);
        frame.add(fiveLetterLabel);
        frame.add(five1);
        frame.add(five2);
        frame.add(five3);
        frame.add(five4);
        frame.add(five5);
        frame.add(five6);
        frame.add(five7);
        frame.add(sixLetterLabel);
        frame.add(six1);
        frame.add(six2);
        frame.add(six3);
        frame.add(six4);
        frame.add(six5);
        frame.add(six6);
        frame.add(six7);
        frame.add(sevenLetterLabel);
        frame.add(seven1);
        frame.add(seven2);
        frame.add(seven3);
        frame.add(seven4);
        frame.add(seven5);
        frame.add(seven6);
        frame.add(seven7);
        frame.add(rootWordLabel);
        frame.add(rootWord);
        frame.add(remainingWords);
        frame.add(submitButton);
        frame.add(submitWord);
        frame.add(guessLabel);
        frame.add(resultBox);
    }
    
    public void loadComponentArray() {
        wordLabels.add(four1);
        wordLabels.add(four2);
        wordLabels.add(four3);
        wordLabels.add(four4);
        wordLabels.add(four5);
        wordLabels.add(four6);
        wordLabels.add(four7);
        wordLabels.add(five1);
        wordLabels.add(five2);
        wordLabels.add(five3);
        wordLabels.add(five4);
        wordLabels.add(five5);
        wordLabels.add(five6);
        wordLabels.add(five7);
        wordLabels.add(six1);
        wordLabels.add(six2);
        wordLabels.add(six3);
        wordLabels.add(six4);
        wordLabels.add(six5);
        wordLabels.add(six6);
        wordLabels.add(six7);
        wordLabels.add(seven1);
        wordLabels.add(seven2);
        wordLabels.add(seven3);
        wordLabels.add(seven4);
        wordLabels.add(seven5);
        wordLabels.add(seven6);
        wordLabels.add(seven7);
    }
}
