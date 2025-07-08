/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.fif;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.hfg.gamenight.games.fif.common.Letters;

/**
 *
 * @author jkelley
 */
public class FIF_GameScreen implements ActionListener {

    public FIF_GameScreen(Letters letterKing) {
        this.letterKing = letterKing;
    }
    
    private String[] selectedCats;
    private String[] selectedLetters;
    private Integer round = 0;
    private final JLabel letterZero = new JLabel();
    private final JLabel letterOne = new JLabel();
    private final JLabel letterTwo = new JLabel();
    private final JLabel letterThree = new JLabel();
    private final JLabel letterFour = new JLabel();
    private final JLabel letterFive = new JLabel();
    private final JLabel categoryOne = new JLabel();
    private final JLabel categoryTwo = new JLabel();
    private final JLabel categoryThree = new JLabel();
    private final JLabel categoryFour = new JLabel();
    private final JLabel categoryFive = new JLabel();
    private final JTextArea answer1 = new JTextArea();
    private final JTextArea answer2 = new JTextArea();
    private final JTextArea answer3 = new JTextArea();
    private final JTextArea answer4 = new JTextArea();
    private final JTextArea answer5 = new JTextArea();
    private final JTextArea answer6 = new JTextArea();
    private final JTextArea answer7 = new JTextArea();
    private final JTextArea answer8 = new JTextArea();
    private final JTextArea answer9 = new JTextArea();
    private final JTextArea answer10 = new JTextArea();
    private final JTextArea answer11 = new JTextArea();
    private final JTextArea answer12 = new JTextArea();
    private final JTextArea answer13 = new JTextArea();
    private final JTextArea answer14 = new JTextArea();
    private final JTextArea answer15 = new JTextArea();
    private final JTextArea answer16 = new JTextArea();
    private final JTextArea answer17 = new JTextArea();
    private final JTextArea answer18 = new JTextArea();
    private final JTextArea answer19 = new JTextArea();
    private final JTextArea answer20 = new JTextArea();
    private final JTextArea answer21 = new JTextArea();
    private final JTextArea answer22 = new JTextArea();
    private final JTextArea answer23 = new JTextArea();
    private final JTextArea answer24 = new JTextArea();
    private final JTextArea answer25 = new JTextArea();
    private final JButton nextButton = new JButton("Next Round");
    private final Letters letterKing;
    private final Font normal = new Font("Digital", Font.PLAIN, 18);
    private final Font small = new Font("Digital", Font.PLAIN, 12);
    private final Font tiny = new Font("Digital", Font.PLAIN, 8);    
    
    public void display(String[] cats, String[] letters) {
        selectedCats = cats;
        selectedLetters = letters;
        JFrame frame = new JFrame("Facts in Five");
        frame.setSize(1100, 700);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        letterZero.setHorizontalAlignment(SwingConstants.CENTER);
        letterZero.setBounds(25, 50, 220, 30);
        letterOne.setHorizontalAlignment(SwingConstants.CENTER);
        letterOne.setBounds(280, 50, 140, 50);
        letterOne.setBorder(new LineBorder(Color.BLACK));
        letterTwo.setHorizontalAlignment(SwingConstants.CENTER);
        letterTwo.setBounds(425, 50, 140, 50);
        letterTwo.setBorder(new LineBorder(Color.BLACK));
        letterThree.setHorizontalAlignment(SwingConstants.CENTER);
        letterThree.setBounds(570, 50, 140, 50);
        letterThree.setBorder(new LineBorder(Color.BLACK));
        letterFour.setHorizontalAlignment(SwingConstants.CENTER);
        letterFour.setBounds(715, 50, 140, 50);
        letterFour.setBorder(new LineBorder(Color.BLACK));
        letterFive.setHorizontalAlignment(SwingConstants.CENTER);
        letterFive.setBounds(860, 50, 140, 50);
        letterFive.setBorder(new LineBorder(Color.BLACK));
        frame.add(letterZero);
        frame.add(letterOne);
        frame.add(letterTwo);
        frame.add(letterThree);
        frame.add(letterFour);
        frame.add(letterFive);
        
        categoryOne.setBounds(25, 110, 220, 50);
        categoryOne.setBorder(new LineBorder(Color.BLACK));
        categoryOne.setHorizontalAlignment(SwingConstants.CENTER);
        categoryOne.setVerticalAlignment(SwingConstants.CENTER);
        answer1.setBounds(280, 110, 140, 50);
        answer1.setBorder(new LineBorder(Color.BLACK));
        answer2.setBounds(425, 110, 140, 50);
        answer2.setBorder(new LineBorder(Color.BLACK));
        answer3.setBounds(570, 110, 140, 50);
        answer3.setBorder(new LineBorder(Color.BLACK));
        answer4.setBounds(715, 110, 140, 50);
        answer4.setBorder(new LineBorder(Color.BLACK));
        answer5.setBounds(860, 110, 140, 50);
        answer5.setBorder(new LineBorder(Color.BLACK));
        frame.add(categoryOne);
        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);
        frame.add(answer5);
        
        categoryTwo.setBounds(25, 170, 220, 50);
        categoryTwo.setBorder(new LineBorder(Color.BLACK));
        categoryTwo.setHorizontalAlignment(SwingConstants.CENTER);
        categoryTwo.setVerticalAlignment(SwingConstants.CENTER);
        answer6.setBounds(280, 170, 140, 50);
        answer6.setBorder(new LineBorder(Color.BLACK));
        answer7.setBounds(425, 170, 140, 50);
        answer7.setBorder(new LineBorder(Color.BLACK));
        answer8.setBounds(570, 170, 140, 50);
        answer8.setBorder(new LineBorder(Color.BLACK));
        answer9.setBounds(715, 170, 140, 50);
        answer9.setBorder(new LineBorder(Color.BLACK));
        answer10.setBounds(860, 170, 140, 50);
        answer10.setBorder(new LineBorder(Color.BLACK));
        frame.add(categoryTwo);
        frame.add(answer6);
        frame.add(answer7);
        frame.add(answer8);
        frame.add(answer9);
        frame.add(answer10);
        
        categoryThree.setBounds(25, 230, 220, 50);
        categoryThree.setBorder(new LineBorder(Color.BLACK));
        categoryThree.setHorizontalAlignment(SwingConstants.CENTER);
        categoryThree.setVerticalAlignment(SwingConstants.CENTER);
        answer11.setBounds(280, 230, 140, 50);
        answer11.setBorder(new LineBorder(Color.BLACK));
        answer12.setBounds(425, 230, 140, 50);
        answer12.setBorder(new LineBorder(Color.BLACK));
        answer13.setBounds(570, 230, 140, 50);
        answer13.setBorder(new LineBorder(Color.BLACK));
        answer14.setBounds(715, 230, 140, 50);
        answer14.setBorder(new LineBorder(Color.BLACK));
        answer15.setBounds(860, 230, 140, 50);
        answer15.setBorder(new LineBorder(Color.BLACK));
        frame.add(categoryThree);
        frame.add(answer11);
        frame.add(answer12);
        frame.add(answer13);
        frame.add(answer14);
        frame.add(answer15);
        
        categoryFour.setBounds(25, 290, 220, 50);
        categoryFour.setBorder(new LineBorder(Color.BLACK));
        categoryFour.setHorizontalAlignment(SwingConstants.CENTER);
        categoryFour.setVerticalAlignment(SwingConstants.CENTER);
        answer16.setBounds(280, 290, 140, 50);
        answer16.setBorder(new LineBorder(Color.BLACK));
        answer17.setBounds(425, 290, 140, 50);
        answer17.setBorder(new LineBorder(Color.BLACK));
        answer18.setBounds(570, 290, 140, 50);
        answer18.setBorder(new LineBorder(Color.BLACK));
        answer19.setBounds(715, 290, 140, 50);
        answer19.setBorder(new LineBorder(Color.BLACK));
        answer20.setBounds(860, 290, 140, 50);
        answer20.setBorder(new LineBorder(Color.BLACK));
        frame.add(categoryFour);
        frame.add(answer16);
        frame.add(answer17);
        frame.add(answer18);
        frame.add(answer19);
        frame.add(answer20);
        
        categoryFive.setBounds(25, 350, 220, 50);
        categoryFive.setBorder(new LineBorder(Color.BLACK));
        categoryFive.setHorizontalAlignment(SwingConstants.CENTER);
        categoryFive.setVerticalAlignment(SwingConstants.CENTER);
        answer21.setBounds(280, 350, 140, 50);
        answer21.setBorder(new LineBorder(Color.BLACK));
        answer22.setBounds(425, 350, 140, 50);
        answer22.setBorder(new LineBorder(Color.BLACK));
        answer23.setBounds(570, 350, 140, 50);
        answer23.setBorder(new LineBorder(Color.BLACK));
        answer24.setBounds(715, 350, 140, 50);
        answer24.setBorder(new LineBorder(Color.BLACK));
        answer25.setBounds(860, 350, 140, 50);
        answer25.setBorder(new LineBorder(Color.BLACK));
        frame.add(categoryFive);
        frame.add(answer21);
        frame.add(answer22);
        frame.add(answer23);
        frame.add(answer24);
        frame.add(answer25);
        
        loadLetters();
        loadCategories();
        
        nextButton.setBounds(570, 470, 150, 50);
        nextButton.addActionListener(this);
        
        frame.add(nextButton);
        JPanel junk = new JPanel();
        frame.add(junk);
        frame.setVisible(true);
    }
    
    private void loadLetters() {
        letterOne.setText(selectedLetters[0]);
        letterTwo.setText(selectedLetters[1]);
        letterThree.setText(selectedLetters[2]);
        letterFour.setText(selectedLetters[3]);
        letterFive.setText(selectedLetters[4]);        
    }
    
    private void loadCategories() {
        categoryOne.setFont(normal);
        categoryTwo.setFont(normal);
        categoryThree.setFont(normal);
        categoryFour.setFont(normal);
        categoryFive.setFont(normal);
        switch (round) {
            case 0:
                //0-4
                categoryOne.setText(selectedCats[0]);
                categoryTwo.setText(selectedCats[1]);
                categoryThree.setText(selectedCats[2]);
                categoryFour.setText(selectedCats[3]);
                categoryFive.setText(selectedCats[4]);
                break;
            case 1:
                //5-9
                categoryOne.setText(selectedCats[5]);
                categoryTwo.setText(selectedCats[6]);
                categoryThree.setText(selectedCats[7]);
                categoryFour.setText(selectedCats[8]);
                categoryFive.setText(selectedCats[9]);
                break;
            case 2:
                //10-14
                categoryOne.setText(selectedCats[10]);
                categoryTwo.setText(selectedCats[11]);
                categoryThree.setText(selectedCats[12]);
                categoryFour.setText(selectedCats[13]);
                categoryFive.setText(selectedCats[14]);
                break;
            case 3:
                //15-19
                categoryOne.setText(selectedCats[15]);
                categoryTwo.setText(selectedCats[16]);
                categoryThree.setText(selectedCats[17]);
                categoryFour.setText(selectedCats[18]);
                categoryFive.setText(selectedCats[19]);
                break;
            case 4:
                //20-24
                categoryOne.setText(selectedCats[20]);
                categoryTwo.setText(selectedCats[21]);
                categoryThree.setText(selectedCats[22]);
                categoryFour.setText(selectedCats[23]);
                categoryFive.setText(selectedCats[24]);
                break;
            default:
                break;
        }
        if (categoryOne.getText().length() > 22) {
            categoryOne.setFont(small);
            if (categoryOne.getText().length() > 32) {
                categoryOne.setFont(tiny);
            }
        }
        if (categoryTwo.getText().length() > 22) {
            categoryTwo.setFont(small);
            if (categoryTwo.getText().length() > 32) {
                categoryTwo.setFont(tiny);
            }
        }
        if (categoryThree.getText().length() > 22) {
            categoryThree.setFont(small);
            if (categoryThree.getText().length() > 32) {
                categoryThree.setFont(tiny);
            }
        }
        if (categoryFour.getText().length() > 22) {
            categoryFour.setFont(small);
            if (categoryFour.getText().length() > 32) {
                categoryFour.setFont(tiny);
            }
        }
        if (categoryFive.getText().length() > 22) {
            categoryFive.setFont(small);
            if (categoryFive.getText().length() > 32) {
                categoryFive.setFont(tiny);
            }
        }
    }
    
    private void resetAnswers() {
        answer1.setText("");
        answer2.setText("");
        answer3.setText("");
        answer4.setText("");
        answer5.setText("");
        answer6.setText("");
        answer7.setText("");
        answer8.setText("");
        answer9.setText("");
        answer10.setText("");
        answer11.setText("");
        answer12.setText("");
        answer13.setText("");
        answer14.setText("");
        answer15.setText("");
        answer16.setText("");
        answer17.setText("");
        answer18.setText("");
        answer19.setText("");
        answer20.setText("");
        answer21.setText("");
        answer22.setText("");
        answer23.setText("");
        answer24.setText("");
        answer25.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        round++;
        if (round < 5) {
            resetAnswers();
            selectedLetters = letterKing.getFiveLetters();
            loadLetters();
            loadCategories();
            if (round == 4) {
                nextButton.setText("Close");
            }
        } else {
            System.exit(0);
        }
    }
    
}
