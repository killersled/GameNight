/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.wordle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author jkelley
 */
public class Wordle_GameScreen implements ActionListener {
    
    private final Font normal = new Font("Digital", Font.PLAIN, 24);
    private final ArrayList<JTextField> board = new ArrayList<>();
    private final ArrayList<JButton> alphabet = new ArrayList<>();
    private final JFrame frame = new JFrame("5 letter Word Game");
    private Integer lettersGuessed = 0;
    private Integer turn = 0;
    private String targetWord = "check";
    private Wordle_WordMap myWM = new Wordle_WordMap();
    private JLabel responseLabel = new JLabel();
    private boolean complete = false;
    private final JButton resetButton = new JButton("Reset");
    
    public void display() {
        myWM.loadWordList();
        myWM.loadDictionary();
        myWM.loadDictionary2();
        myWM.show25();
        targetWord = myWM.selectWord();
        System.out.println(targetWord);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 450);
        
        //the field of 25
        setupBoard();
        
        //the alpabet field
        setupAlphabet();

        //the label for chatting
        responseLabel.setBounds(350, 300, 300, 50);
        responseLabel.setText("Enter Guess 1");
        frame.add(responseLabel);
        
        //reset button
        resetButton.setBounds(675, 325, 100, 50);
        resetButton.setVisible(false);
        resetButton.addActionListener(this);
        frame.add(resetButton);
        
        //Logo label
        ImageIcon logo = new ImageIcon("./images/hfg_logo.jpg");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(10, 310, 120, 120);
        logoLabel.setBorder(new LineBorder(Color.BLACK));
        frame.add(logoLabel);
        
        JPanel junk = new JPanel();
        frame.add(junk);
        frame.setVisible(true);
    }
    
    private void setupBoard() {
        int height = 40;
        int width = 40;
        int row1Y = 50;
        int row2Y = 100;
        int row3Y = 150;
        int row4Y = 200;
        int row5Y = 250;
        int col1X = 50;
        int col2X = 100;
        int col3X = 150;
        int col4X = 200;
        int col5X = 250;
        
        for (int a = 0; a < 25; a++) {
            JTextField curBlock = new JTextField();
            curBlock.setHorizontalAlignment(SwingConstants.CENTER);
            curBlock.setBorder(new LineBorder(Color.BLACK));
            curBlock.setEditable(false);
            curBlock.setFont(normal);
            curBlock.setBackground(Color.WHITE);
            switch (a) {                
                case 0:
                    curBlock.setBounds(col1X, row1Y, width, height);
                    break;
                case 1:
                    curBlock.setBounds(col2X, row1Y, width, height);
                    break;
                case 2:
                    curBlock.setBounds(col3X, row1Y, width, height);
                    break;
                case 3:
                    curBlock.setBounds(col4X, row1Y, width, height);
                    break;
                case 4:
                    curBlock.setBounds(col5X, row1Y, width, height);
                    break;
                case 5:
                    curBlock.setBounds(col1X, row2Y, width, height);
                    break;
                case 6:
                    curBlock.setBounds(col2X, row2Y, width, height);
                    break;
                case 7:
                    curBlock.setBounds(col3X, row2Y, width, height);
                    break;
                case 8:
                    curBlock.setBounds(col4X, row2Y, width, height);
                    break;
                case 9:
                    curBlock.setBounds(col5X, row2Y, width, height);
                    break;
                case 10:
                    curBlock.setBounds(col1X, row3Y, width, height);
                    break;
                case 11:
                    curBlock.setBounds(col2X, row3Y, width, height);
                    break;
                case 12:
                    curBlock.setBounds(col3X, row3Y, width, height);
                    break;
                case 13:
                    curBlock.setBounds(col4X, row3Y, width, height);
                    break;
                case 14:
                    curBlock.setBounds(col5X, row3Y, width, height);
                    break;
                case 15:
                    curBlock.setBounds(col1X, row4Y, width, height);
                    break;
                case 16:
                    curBlock.setBounds(col2X, row4Y, width, height);
                    break;
                case 17:
                    curBlock.setBounds(col3X, row4Y, width, height);
                    break;
                case 18:
                    curBlock.setBounds(col4X, row4Y, width, height);
                    break;
                case 19:
                    curBlock.setBounds(col5X, row4Y, width, height);
                    break;
                case 20:
                    curBlock.setBounds(col1X, row5Y, width, height);
                    break;
                case 21:
                    curBlock.setBounds(col2X, row5Y, width, height);
                    break;
                case 22:
                    curBlock.setBounds(col3X, row5Y, width, height);
                    break;
                case 23:
                    curBlock.setBounds(col4X, row5Y, width, height);
                    break;
                case 24:
                    curBlock.setBounds(col5X, row5Y, width, height);
                    break;
                default:
                    break;
            }
            frame.add(curBlock);
            board.add(curBlock);
        }
    }
    
    private void setupAlphabet() {
        int height = 30;
        int width = 30;
        int row1Y = 75;
        int row2Y = 115;
        int row3Y = 155;
        int row4Y = 195;
        int row5Y = 235;
        int col1X = 450;
        int col2X = 490;
        int col3X = 530;
        int col4X = 570;
        int col5X = 610;
        int col6X = 650;
        int col7X = 690;
        
        //Layout will be:
        //  0  1  2  3  4  5  6
        //  7  8  9 10 11 12 13
        // 14 15 16 17 18 19 20
        //    21 22 23 24 25
        //       26    27 // this two are double width
        
        for (int a = 0; a < 28; a++) {
            JButton curBlock = new JButton();
            curBlock.setBorder(new LineBorder(Color.BLACK));
            curBlock.setForeground(Color.BLACK);
            curBlock.setOpaque(true);
            curBlock.setBackground(Color.WHITE);
            curBlock.addActionListener(this);
            switch (a) {                
                case 0:
                    curBlock.setBounds(col1X, row1Y, width, height);
                    curBlock.setText("A");
                    break;
                case 1:
                    curBlock.setBounds(col2X, row1Y, width, height);
                    curBlock.setText("B");
                    break;
                case 2:
                    curBlock.setBounds(col3X, row1Y, width, height);
                    curBlock.setText("C");
                    break;
                case 3:
                    curBlock.setBounds(col4X, row1Y, width, height);
                    curBlock.setText("D");
                    break;
                case 4:
                    curBlock.setBounds(col5X, row1Y, width, height);
                    curBlock.setText("E");
                    break;
                case 5:
                    curBlock.setBounds(col6X, row1Y, width, height);
                    curBlock.setText("F");
                    break;
                case 6:
                    curBlock.setBounds(col7X, row1Y, width, height);
                    curBlock.setText("G");
                    break;
                case 7:
                    curBlock.setBounds(col1X, row2Y, width, height);
                    curBlock.setText("H");
                    break;
                case 8:
                    curBlock.setBounds(col2X, row2Y, width, height);
                    curBlock.setText("I");
                    break;
                case 9:
                    curBlock.setBounds(col3X, row2Y, width, height);
                    curBlock.setText("J");
                    break;
                case 10:
                    curBlock.setBounds(col4X, row2Y, width, height);
                    curBlock.setText("K");
                    break;
                case 11:
                    curBlock.setBounds(col5X, row2Y, width, height);
                    curBlock.setText("L");
                    break;
                case 12:
                    curBlock.setBounds(col6X, row2Y, width, height);
                    curBlock.setText("M");
                    break;
                case 13:
                    curBlock.setBounds(col7X, row2Y, width, height);
                    curBlock.setText("N");
                    break;
                case 14:
                    curBlock.setBounds(col1X, row3Y, width, height);
                    curBlock.setText("O");
                    break;
                case 15:
                    curBlock.setBounds(col2X, row3Y, width, height);
                    curBlock.setText("P");
                    break;
                case 16:
                    curBlock.setBounds(col3X, row3Y, width, height);
                    curBlock.setText("Q");
                    break;
                case 17:
                    curBlock.setBounds(col4X, row3Y, width, height);
                    curBlock.setText("R");
                    break;
                case 18:
                    curBlock.setBounds(col5X, row3Y, width, height);
                    curBlock.setText("S");
                    break;
                case 19:
                    curBlock.setBounds(col6X, row3Y, width, height);
                    curBlock.setText("T");
                    break;
                case 20:
                    curBlock.setBounds(col7X, row3Y, width, height);
                    curBlock.setText("U");
                    break;
                case 21:
                    curBlock.setBounds(col2X, row4Y, width, height);
                    curBlock.setText("V");
                    break;
                case 22:
                    curBlock.setBounds(col3X, row4Y, width, height);
                    curBlock.setText("W");
                    break;
                case 23:
                    curBlock.setBounds(col4X, row4Y, width, height);
                    curBlock.setText("X");
                    break;
                case 24:
                    curBlock.setBounds(col5X, row4Y, width, height);
                    curBlock.setText("Y");
                    break;
                case 25:
                    curBlock.setBounds(col6X, row4Y, width, height);
                    curBlock.setText("Z");
                    break;
                case 26:
                    curBlock.setBounds(500, row5Y, width*2, height);
                    curBlock.setText("BKSP");
                    break;
                case 27:
                    curBlock.setBounds(col5X, row5Y, width*2, height);
                    curBlock.setText("Enter");
                    break;
                default:
                    break;
            }
            alphabet.add(curBlock);
            frame.add(curBlock);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String curButton = e.getActionCommand();
        
        if (curButton.equals("BKSP")) {
            int offset = 0; //turn 0 offset is 0
            if (turn == 1) {
                offset = 5;
            } else if (turn == 2) {
                offset = 10;
            } else if (turn == 3) {
                offset = 15;
            } else if (turn == 4) {
                offset = 20;
            }
            if (lettersGuessed > 0) {
                lettersGuessed--;
                board.get(lettersGuessed+offset).setText("");
            }
        } else if (curButton.equals("Enter")) {
            if (!complete) {
                checkWord();
            } 
        } else if (curButton.equals("Reset")) {
            resetGame();
        } else {
            int offset = 0; //turn 0 offset is 0
            if (turn == 1) {
                offset = 5;
            } else if (turn == 2) {
                offset = 10;
            } else if (turn == 3) {
                offset = 15;
            } else if (turn == 4) {
                offset = 20;
            }
            if (turn < 5) {
                board.get(lettersGuessed+offset).setText(curButton);                      
            }
            lettersGuessed++;
        }
    }
    
    private void checkWord() {
        //get turn, check letters guessed vs targetWord
        Integer[] cgMatch = {0,0,0,0,0};
        int offset = 0; //turn 0 offset is 0
        if (turn == 1) {
            offset = 5;
        } else if (turn == 2) {
            offset = 10;
        } else if (turn == 3) {
            offset = 15;
        } else if (turn == 4) {
            offset = 20;
        }
        String guess = "";
        for (int i = 0; i < 5; i++) {
            String curLetter = board.get(i+offset).getText();
            guess = guess.concat(curLetter);
        }
        if (!myWM.isWordInDictionary(guess)) {
            responseLabel.setText("Um, I don't know that word.");
            return;
        }
        for (int i = 0; i < 5; i++) {
            String curLetter = board.get(i+offset).getText();
            if (curLetter.equalsIgnoreCase(targetWord.substring(i, i+1))) {
                cgMatch[i] = 1;
                board.get(i+offset).setBackground(Color.GREEN);
                colorLetterGreen(curLetter.charAt(0));
            } 
        }

        System.out.println(guess + " ==> " + targetWord);
        int matches = 0;
        for (int i = 0; i < 5; i++) {
            JTextField letter = board.get(i+offset);
            if (letter.getBackground().equals(Color.WHITE)) {
                continue;
            }
            matches++;
        }
        System.out.println(matches);
        if (matches < 3) { // using 3 because 4 matches means only one non-match and green is the only possible
            for (int i = 0; i < 5; i++) {
                if (cgMatch[i] == 1) {
                    continue; //Current letter in current guess is already accounted for
                }
                JTextField letter = board.get(i+offset);
                String curLetter = letter.getText();
                for (int j = 0; j < 5; j++) {
                    if (cgMatch[j] == 1) {
                        continue;
                    }
                    String wordLetter = new String(targetWord.toUpperCase().substring(j, j+1));
                    System.out.println("Checking for yellow: " + wordLetter + " vs. " + curLetter);
                    boolean isMatch = false;
                    if (curLetter.equals(wordLetter)) {
                        if (letter.getBackground().equals(Color.WHITE)) {
                            letter.setBackground(Color.YELLOW);
                            colorLetterYellow(curLetter.charAt(0));
                            System.out.println("Swapped background color for " + curLetter);
                            cgMatch[j] = 1;
                        } else {
                            System.out.println("Didn't swap background for some reason");
                        }
                        isMatch = true;
                    }
                    if (isMatch) {
                        //matched this letter; move on
                        System.out.println("Matched " + wordLetter + " to " + curLetter);
                        break;
                    }
                }
            }
        }
        switch (turn) {
            case 0:
                if (matches == 5) {
                    responseLabel.setText("Wait...Can you see my cards?");
                    complete = true;
                } else {
                    responseLabel.setText("Enter your second guess");
                }
                break;
            case 1:
                if (matches == 5) {
                    responseLabel.setText("Wow.  I'm impressed.");
                    complete = true;
                } else {
                    responseLabel.setText("Enter your third guess");
                }
                break;
            case 2:
                if (matches == 5) {
                    responseLabel.setText("Nicely done!");
                    complete = true;
                } else {
                    responseLabel.setText("Enter your fourth guess");
                }
                break;
            case 3:
                if (matches == 5) {
                    responseLabel.setText("Got it!");
                    complete = true;
                } else {
                    responseLabel.setText("Enter your last guess");
                }
                break;
            default:
                if (matches == 5) {
                    responseLabel.setText("Darn it, I had money on you failing, again!");
                    complete = true;
                } else {
                    responseLabel.setText("Better luck next time!");
                }
                break;
        }
        if (complete) {
            resetButton.setVisible(true);
        }
        turn++;
        lettersGuessed = 0;
    }
    
    private void resetGame() {
        targetWord = myWM.selectWord();
        System.out.println(targetWord);
        for (int i = 0; i < 25; i++) {
            board.get(i).setBackground(Color.WHITE);
            board.get(i).setText("");
        }
        for (int i = 0; i < 28; i++) {
            alphabet.get(i).setBackground(Color.WHITE);
        }
        responseLabel.setText("");
        turn = 0;
        lettersGuessed = 0;
        complete = false;
        resetButton.setVisible(false);
    }
    
    private void colorLetterGreen(char letter) {
        int letterVal = letter;
        System.out.println(letter + " :: " + letterVal);
        alphabet.get(letterVal-65).setBackground(Color.GREEN);
    }
    
    private void colorLetterYellow(char letter) {
        int letterVal = letter;
        if (alphabet.get(letterVal-65).getBackground().equals(Color.WHITE)) {
            alphabet.get(letterVal-65).setBackground(Color.YELLOW);
        } else {
            System.out.println("bkgd not white, it is: " + alphabet.get(letterVal-65).getBackground());
        }
    }
    
}
