/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.spellingbee;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
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
public class SB_GameScreen implements ActionListener {
    private final String[] sevenLetterWords = {"","","","","","",""};
    private final String[] sixLetterWords = {"","","","","","",""};
    private final String[] fiveLetterWords = {"","","","","","",""};
    private final String[] fourLetterWords = {"","","","","","",""};
    
    private ArrayList<String> matches4 = null;
    private ArrayList<String> matches5 = null;
    private ArrayList<String> matches6 = null;
    private ArrayList<String> matches7 = null;
    private final ArrayList<String> wordList = new ArrayList<>();
    private SB_WordWheel myWheel;
    private SB_SpellingWords myWordList;
    private final SB_ScreenComponents screenComponents = new SB_ScreenComponents();
    private final SB_MenuHandler menuHandler = new SB_MenuHandler();
    
    
    public void display() {
        screenComponents.loadComponentArray();
        setUpWords();
        JMenuBar menuBar = new JMenuBar();
        screenComponents.frame.setJMenuBar(menuBar);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem maxItem = new JMenuItem("Maximize");
        maxItem.addActionListener(menuHandler);
        
        
        fileMenu.add(maxItem);
        fileMenu.addSeparator();

        // Create an "Exit" menu item with an action listener
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(menuHandler);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuHandler.setScreenComponents(screenComponents);
        
        Double W = screenComponents.usualW * screenComponents.defaultWidth;
        Double H = screenComponents.usualH * screenComponents.defaultHeight;
        Double X = screenComponents.rootLabelX * screenComponents.defaultWidth;
        Double Y = screenComponents.rootY * screenComponents.defaultHeight;
        
        screenComponents.rootWordLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = screenComponents.rootWordX * screenComponents.defaultWidth;
        screenComponents.rootWord.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.rootWord.setForeground(screenComponents.rootWordColor);
        
        for (int i = 0; i < screenComponents.wordLabels.size(); i++) {
            JLabel curLabel = (JLabel) screenComponents.wordLabels.get(i);
            curLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            int j;
            if (i < 7) {
                //First column
                j = i;
                X = screenComponents.fourX * screenComponents.defaultWidth;               
            } else if (i < 14) {
                j = i-7;
                X = screenComponents.fiveX * screenComponents.defaultWidth;
            } else if (i < 21) {
                j = i-14;
                X = screenComponents.sixX * screenComponents.defaultWidth;
            } else {
                j = i-21;
                 X = screenComponents.sevenX * screenComponents.defaultWidth;   
            }
            switch(j) {
                case 0:
                    Y = screenComponents.labelRowY * screenComponents.defaultHeight;
                    if (i == 0) {
                        screenComponents.fourLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.fourLetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    } else if (i == 7) {
                        screenComponents.fiveLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.fiveLetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    } else if (i == 14) {
                        screenComponents.sixLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.sixLetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    } else if (i == 21) {
                        screenComponents.sevenLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.sevenLetterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    }
                    Y = screenComponents.rowOneY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 1:
                    Y = screenComponents.rowTwoY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 2:
                    Y = screenComponents.rowThreeY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 3:
                    Y = screenComponents.rowFourY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 4:
                    Y = screenComponents.rowFiveY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 5:
                    Y = screenComponents.rowSixY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                default:
                    Y = screenComponents.rowSevenY * screenComponents.defaultHeight;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;

            }

        }
        
        X = screenComponents.otherX * screenComponents.defaultWidth;
        W = screenComponents.guessW * screenComponents.defaultWidth;
        Y = screenComponents.submitWY * screenComponents.defaultHeight;
        screenComponents.submitWord.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = screenComponents.guessY * screenComponents.defaultHeight;
        screenComponents.guessLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        W = screenComponents.submitW * screenComponents.defaultWidth;
        H = screenComponents.submitH * screenComponents.defaultHeight;
        Y = screenComponents.submitBY * screenComponents.defaultHeight;
        screenComponents.submitButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.submitButton.addActionListener(this);
        W = screenComponents.remainW * screenComponents.defaultWidth;
        H = screenComponents.usualH * screenComponents.defaultHeight;
        Y = screenComponents.remainY * screenComponents.defaultHeight;
        screenComponents.remainingWords.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.resultBox.setBounds(100, 300, 500, 30);

        screenComponents.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screenComponents.frame.setSize(screenComponents.defaultWidth, screenComponents.defaultHeight);
        screenComponents.addComponentsToFrame();
        JPanel junk = new JPanel();
        screenComponents.frame.add(junk);
        screenComponents.frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton curButton = (JButton) e.getSource();
        String action = curButton.getText();
        if (action.equals("Reset")) {
            for (int i = 0; i < screenComponents.wordLabels.size(); i++) {
                JLabel curLabel = (JLabel) screenComponents.wordLabels.get(i);
                curLabel.setForeground(Color.BLACK);
                if (i < 7) {
                    fourLetterWords[i] = "";
                } else if (i < 14) {
                    fiveLetterWords[i-7] = "";
                } else if (i < 21) {
                    sixLetterWords[i-14] = "";
                } else {
                    sevenLetterWords[i-21] = "";
                }
            }
            if (wordList.isEmpty()) {
                screenComponents.frame.setVisible(false);
                screenComponents.frame.dispose();
            } else {
                setUpWords();
            }
            return;
        }
        String guess = screenComponents.submitWord.getText().trim().toUpperCase();
        System.out.println("Guess is: " + guess);
        screenComponents.submitWord.setText("");
        screenComponents.submitWord.requestFocusInWindow();
        boolean found = false;
        int guessLength = guess.length();
        for (int i = 0; i < screenComponents.wordLabels.size(); i++) {
            JLabel curLabel = (JLabel) screenComponents.wordLabels.get(i);
//            if (curLabel.getForeground() == screenComponents.correctWord) {
//                // already found
//                continue;
//            }
            if (curLabel.getText().equals(guess)) {
                curLabel.setForeground(screenComponents.correctWord);
                found = true;
                break;
            }

        }
        
        if (found) {
            screenComponents.wordCount--;
            if (screenComponents.wordCount == 0) {
                screenComponents.remainingWords.setText("WINNER!!!");
                screenComponents.submitButton.setText("Reset");
            } else {
                screenComponents.remainingWords.setText("Remaining words: " + screenComponents.wordCount);
            }
        } else {
            // if not found, we want a note to potentially add to dictionary
            switch (guessLength) {
                case 4:
                    if (!matches4.isEmpty()) {
                        for (String word : matches4) {
                            if (word.equals(guess)) {
                                System.out.println("\tFound guess in word List");
                                found = true;
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    if (!matches5.isEmpty()) {
                        for (String word : matches5) {
                            if (word.equals(guess)) {
                                System.out.println("\tFound guess in word List");
                                found = true;
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    if (!matches6.isEmpty()) {
                        for (String word : matches6) {
                            if (word.equals(guess)) {
                                System.out.println("\tFound guess in word List");
                                found = true;
                                break;
                            }
                        }
                    }
                    break;
                default:
                    if (!matches7.isEmpty()) {
                        for (String word : matches7) {
                            if (word.equals(guess)) {
                                System.out.println("\tFound guess in word List");
                                found = true;
                                break;
                            }
                        }
                    }
                    break;
                    
            }
            if (!found) {
                System.out.println("\tThink about adding " + guess + " to the dictionary file");
                screenComponents.resultBox.addItem("Didn't find that.  Will think about adding " + guess + " to the dictionary.");
            } else {
                screenComponents.resultBox.addItem(guess + " is in the found word list.  Sorry it didn't make the 'screen seven'.");
            }
            int num = screenComponents.resultBox.getItemCount();
            screenComponents.resultBox.setSelectedIndex(num - 1);
        }
        
        
    }
    
    public void addWordtoWordList(String newWord) {
        wordList.add(newWord);
    }
    
    private String getNextWordInWordList() {
        Collections.shuffle(wordList);
        String newWord = wordList.getFirst();
        wordList.removeFirst();
        return newWord;
    }
    
    public void setWordWheel(SB_WordWheel wheel) {
        myWheel = wheel;
    }
    
    public void setWordList(SB_SpellingWords words) {
        myWordList = words;
    }
    
    private void getWordBreakdowns() {
        matches4 = myWheel.findFixedLetterWheels(4, myWordList.getWordList(), screenComponents.rootWord.getText());
        matches5 = myWheel.findFixedLetterWheels(5, myWordList.getWordList(), screenComponents.rootWord.getText());
        matches6 = myWheel.findFixedLetterWheels(6, myWordList.getWordList(), screenComponents.rootWord.getText());
        matches7 = myWheel.findFixedLetterWheels(7, myWordList.getWordList(), screenComponents.rootWord.getText());
        
        System.out.println(matches4.toString());
        System.out.println(matches5.toString());
        System.out.println(matches6.toString());
        System.out.println(matches7.toString());
        
        int iters = matches4.size();
        if (iters > 6) {
            iters = 7;
        }
        for (int i = 0; i < iters; i++) {
            Collections.shuffle(matches4);
            String word = matches4.getFirst();
            fourLetterWords[i] = word;
            matches4.removeFirst();
        }
        iters = matches5.size();
        if (iters > 6) {
            iters = 7;
        }
        for (int i = 0; i < iters; i++) {
            Collections.shuffle(matches5);
            String word = matches5.getFirst();
            fiveLetterWords[i] = word;
            matches5.removeFirst();
        }
        iters = matches6.size();
        if (iters > 6) {
            iters = 7;
        }
        for (int i = 0; i < iters; i++) {
            Collections.shuffle(matches6);
            String word = matches6.getFirst();
            sixLetterWords[i] = word;
            matches6.removeFirst();
        }
        iters = matches7.size();
        if (iters > 6) {
            iters = 7;
        }
        for (int i = 0; i < iters; i++) {
            Collections.shuffle(matches7);
            String word = matches7.getFirst();
            sevenLetterWords[i] = word;
            matches7.removeFirst();
        }
        
        
    }
    
    private void setUpWords() {
        String root = getNextWordInWordList();
        screenComponents.rootWord.setText(root);
        getWordBreakdowns();
        
        for (int i = 0; i < screenComponents.wordLabels.size(); i++) {
            JLabel curLabel = (JLabel) screenComponents.wordLabels.get(i);
            if (i < 7) {
                int j = i;
                String word = fourLetterWords[j];
                if (word.isEmpty()) {
                    word = "---";
                } else {
                    screenComponents.wordCount++;
                }
                curLabel.setText(word);
                if (!word.equals("---"))
                    curLabel.setForeground(screenComponents.hiddenLabel);
                
            } else if (i < 14) {
                int j = i-7;
                String word = fiveLetterWords[j];
                if (word.isEmpty()) {
                    word = "---";
                } else {
                    screenComponents.wordCount++;
                }
                curLabel.setText(word);
                if (!word.equals("---"))
                    curLabel.setForeground(screenComponents.hiddenLabel);
                
            } else if (i < 21) {
                int j = i-14;
                String word = sixLetterWords[j];
                if (word.isEmpty()) {
                    word = "---";
                } else {
                    screenComponents.wordCount++;
                }
                curLabel.setText(word);
                if (!word.equals("---"))
                    curLabel.setForeground(screenComponents.hiddenLabel);
                
            } else {
                int j = i-21;
                String word = sevenLetterWords[j];
                if (word.isEmpty()) {
                    word = "---";
                } else {
                    screenComponents.wordCount++;
                }
                curLabel.setText(word);
                if (!word.equals("---"))
                    curLabel.setForeground(screenComponents.hiddenLabel);
                    
            }

        }
        
        
        screenComponents.remainingWords.setText("Remaining words: " + screenComponents.wordCount);
        screenComponents.submitButton.setText("Submit");
        screenComponents.resultBox.removeAllItems();
    }
}
