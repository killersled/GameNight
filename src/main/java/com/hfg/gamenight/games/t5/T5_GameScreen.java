/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.t5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class T5_GameScreen implements ActionListener {
    
    private final Font normal = new Font("Digital", Font.PLAIN, 24);
    private final JFrame frame = new JFrame("Top Five");
    private final JLabel titleLabel = new JLabel();
    private final JLabel rankLabel = new JLabel();
    private final JLabel num1Label = new JLabel();
    private final JLabel num2Label = new JLabel();
    private final JLabel num3Label = new JLabel();
    private final JLabel num4Label = new JLabel();
    private final JLabel num5Label = new JLabel();
    private final JLabel topFivelabel = new JLabel("Top Five:");
    private final JLabel nameLabel = new JLabel("Name:");
    private final JTextArea num1 = new JTextArea();
    private final JTextArea num2 = new JTextArea();
    private final JTextArea num3 = new JTextArea();
    private final JTextArea num4 = new JTextArea();
    private final JTextArea num5 = new JTextArea();
    private final JTextArea answerBox = new JTextArea();
    private int revealed = 5;
    private final JButton nextButton = new JButton("Next");
    private final JButton revealButton = new JButton("Just Show Me");
    private final JButton guessButton = new JButton("Guess");
    private final JButton correctButton = new JButton("Bingo!");
    private final Random myRand = new Random(System.currentTimeMillis());
    private JSONArray datasets;
    private final String titleTag = "title";
    private final String entryListTag = "entries";
    private final String rankTag = "rank";
    private final String fiveTag = "top_five";
    private final String ogTag = "original_group";
    private final HashMap<Integer, Boolean[]> seenIt = new HashMap<>();
    private JSONObject dataset;
    private JSONArray acts;
    private final JTextArea descript = new JTextArea();
    private final Double rightEdgeX = .025;
    private final Double numLabelX = .030;
    private final Double entriesX = .060;
    private final Double topFiveX = .100;
    private final Double answerX = .300;
    private final Double rankLabelX = .500;
    private final Double buttonsX = .700;
    private final Double correctX = .825;
    private final Double topRowY = .04167;
    private final Double descriptY = .125;
    private final Double topFiveY = .21667;
    private final Double numFiveY = .29167;
    private final Double numFourY = .36667;
    private final Double otherButtonsY = .4;
    private final Double numThreeY = .45;
    private final Double revealY = .51667;
    private final Double numTwoY = .53333;
    private final Double numOneY = .61667;
    private final Double answerLabelY = .7;
    private final Double answerBoxY = .76667;
    private final Double titleLabelW = .45;
    private final Double rankLabelW = .07;
    private final Double numLabelW = .020;
    private final Double numBoxW = .5;
    private final Double buttonsW = .1;
    private final Double nameLabelW = .05;
    private final Double descriptW = .8;
    private final Double regularH = .05;
    private final Double descriptH = .1;
    private final Double buttonH = .08333;
    private final Integer defaultHeight = 600;
    private final Integer defaultWidth = 1000;
    private final T5_MenuHandler menuHandler = new T5_MenuHandler(); 
    
    public void display() {
        
        int action = selectDataset();
        String title = dataset.getString(titleTag);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(defaultWidth, defaultHeight);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem maxItem = new JMenuItem("Maximize");
        maxItem.addActionListener(menuHandler);
        
        menuHandler.setTL(titleLabel);
        menuHandler.setDT(descript);
        menuHandler.setN5L(num5Label);
        menuHandler.setN4L(num4Label);
        menuHandler.setN3L(num3Label);
        menuHandler.setN2L(num2Label);
        menuHandler.setN1L(num1Label);
        menuHandler.setN5(num5);
        menuHandler.setN4(num4);
        menuHandler.setN3(num3);
        menuHandler.setN2(num2);
        menuHandler.setN1(num1);
        menuHandler.setTFL(topFivelabel);
        menuHandler.setNL(nameLabel);
        menuHandler.setAB(answerBox);
        menuHandler.setRL(rankLabel);
        menuHandler.setRB(revealButton);
        menuHandler.setNB(nextButton);
        menuHandler.setGB(guessButton);
        menuHandler.setCB(correctButton);
        menuHandler.setGS(frame);
        fileMenu.add(maxItem);
        fileMenu.addSeparator();

        // Create an "Exit" menu item with an action listener
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(menuHandler);
        
          //Added exit as item in MenuItem
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
       
        setupBoard(title, acts.getJSONObject(action));
        
        
        //Logo label
        //% are: X=.8, Y=.04167, W=.12, H=.2
        ImageIcon logo = new ImageIcon("/Users/jkelley/Desktop/hfg_logo.jpg");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(880, 25, 120, 120);
        logoLabel.setBorder(new LineBorder(Color.BLACK));
        menuHandler.setLL(logoLabel);
        frame.add(logoLabel);
        
        JPanel junk = new JPanel();
        frame.add(junk);
        frame.setVisible(true);
    }
    
    private void setupBoard(String title, JSONObject selectAct) {
        titleLabel.setText("Dataset title: " + title);
        int rank = selectAct.getInt(rankTag);
        rankLabel.setText(String.valueOf("Rank: " + rank));
        String description = dataset.getString("description");
        descript.setText(description);
        descript.setEditable(false);
        descript.setBackground(titleLabel.getBackground());
        frame.add(descript);
        frame.add(titleLabel);
        frame.add(rankLabel);
        num5Label.setText("5.");
        num4Label.setText("4.");
        num3Label.setText("3.");
        num2Label.setText("2.");
        num1Label.setText("1.");
        JSONArray topFive = selectAct.getJSONArray(fiveTag);
        if (selectAct.keySet().contains(ogTag)) {
            System.out.println(selectAct.getString(ogTag));
        }
        Color bgColor = num5.getBackground();
        num5.setText(topFive.getString(4));
        num5.setEditable(false);
        num4.setText(topFive.getString(3));
        num4.setForeground(bgColor);
        num4.setEditable(false);
        num3.setText(topFive.getString(2));
        num3.setForeground(bgColor);
        num3.setEditable(false);        
        num2.setText(topFive.getString(1));
        num2.setForeground(bgColor);
        num2.setEditable(false);   
        num1.setText(topFive.getString(0));
        num1.setForeground(bgColor);
        num1.setEditable(false);
        
        answerBox.setText(selectAct.getString("name"));
        answerBox.setForeground(bgColor);
        answerBox.setEditable(false);
        
        nextButton.addActionListener(this);
        revealButton.addActionListener(this);
        guessButton.addActionListener(this);
        correctButton.addActionListener(this);
        guessButton.setVisible(false);
        correctButton.setVisible(false);
        
        // Setting bounds
        // X and W(idth) are multiplied by defaultWidth
        // Y and H(eight) are multiplied by defaultHeight
        Double X = rightEdgeX * defaultWidth;
        Double Y = topRowY * defaultHeight;
        Double W = titleLabelW * defaultWidth;
        Double H = regularH * defaultHeight;
        titleLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = descriptY * defaultHeight;
        W = descriptW * defaultWidth;
        H = descriptH * defaultHeight;
        descript.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = numLabelX * defaultWidth;
        Y = numFiveY * defaultHeight;
        W = numLabelW * defaultWidth;
        H = regularH * defaultHeight;
        num5Label.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numFourY * defaultHeight;
        num4Label.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numThreeY * defaultHeight;
        num3Label.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numTwoY * defaultHeight;
        num2Label.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numOneY * defaultHeight;
        num1Label.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = entriesX * defaultWidth;
        Y = numFiveY * defaultHeight;
        W = numBoxW * defaultWidth;
        num5.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numFourY * defaultHeight;
        num4.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numThreeY * defaultHeight;
        num3.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numTwoY * defaultHeight;
        num2.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numOneY * defaultHeight;
        num1.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = topFiveX * defaultWidth;
        Y = topFiveY * defaultHeight;
        W = buttonsW * defaultWidth;
        topFivelabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = answerX * defaultWidth;
        Y = answerLabelY * defaultHeight;
        W = nameLabelW * defaultWidth;
        nameLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = answerBoxY * defaultHeight;
        W = numBoxW * defaultWidth;
        answerBox.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = rankLabelX * defaultWidth;
        Y = topRowY * defaultHeight;
        W = rankLabelW * defaultWidth;
        rankLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = buttonsX * defaultWidth;
        Y = revealY * defaultHeight;
        W = buttonsW * defaultWidth;
        H = buttonH * defaultHeight;
        revealButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numFiveY * defaultHeight;
        nextButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = otherButtonsY * defaultHeight;
        guessButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = correctX * defaultWidth;
        correctButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        
        frame.add(answerBox);
        frame.add(revealButton);
        frame.add(nextButton);
        frame.add(num5Label);
        frame.add(num4Label);
        frame.add(num3Label);
        frame.add(num2Label);
        frame.add(num1Label);
        frame.add(num5);
        frame.add(num4);
        frame.add(num3);
        frame.add(num2);
        frame.add(num1);
        frame.add(nameLabel);
        frame.add(topFivelabel);
        frame.add(guessButton);
        frame.add(correctButton);
    }
    
    private void resetBoard() {
        int action = selectDataset();
        String title = dataset.getString(titleTag);
        String description = dataset.getString("description");
        descript.setText(description);
        JSONObject selectAct = acts.getJSONObject(action);
        titleLabel.setText("Dataset title: " + title);
        int rank = selectAct.getInt(rankTag);
        rankLabel.setText(String.valueOf("Rank: " + rank));
        JSONArray topFive = selectAct.getJSONArray(fiveTag);
        if (selectAct.keySet().contains(ogTag)) {
            System.out.println(selectAct.getString(ogTag));
        }
        Color bgColor = num5.getBackground();
        num5.setText(topFive.getString(4));
        num4.setText(topFive.getString(3));
        num4.setForeground(bgColor);
        num3.setText(topFive.getString(2));
        num3.setForeground(bgColor);
        num2.setText(topFive.getString(1));
        num2.setForeground(bgColor);
        num1.setText(topFive.getString(0));
        num1.setForeground(bgColor);
        
        answerBox.setText(selectAct.getString("name"));
        answerBox.setForeground(bgColor);
        revealed = 5;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String curButton = e.getActionCommand();
        if (curButton.equals("Next")) {
            switch (revealed) {
                case 5:
                    num4.setForeground(num5.getForeground());
                    revealed = 4;
                    break;
                case 4:
                    num3.setForeground(num5.getForeground());
                    revealed = 3;
                    break;
                case 3:
                    num2.setForeground(num5.getForeground());
                    revealed = 2;
                    break;
                case 2:
                    num1.setForeground(num5.getForeground());
                    revealed = 1;
                    break;
                case 1:
                    revealed = 0;
                    break;
                default:
                    resetBoard();
            }
        } else if (curButton.equals("Just Show Me")) {
            num4.setForeground(num5.getForeground());
            num3.setForeground(num5.getForeground());
            num2.setForeground(num5.getForeground());
            num1.setForeground(num5.getForeground());
            revealed = 0;
            answerBox.setForeground(num5.getForeground());
        }
    }
    
    private int selectDataset() {
        boolean gotOne = false;
        Integer tempAction = -1;
        Integer tempDataset;
        while (!gotOne) {
            tempDataset = myRand.nextInt(datasets.length());
            dataset = datasets.getJSONObject(tempDataset);
            acts = dataset.getJSONArray(entryListTag);
            tempAction = myRand.nextInt(acts.length());
            Boolean[] checking = seenIt.get(tempDataset);
            
            if (!checking[tempAction]) {
                checking[tempAction] = true;
                seenIt.put(tempDataset, checking);
                //System.out.println("Going with " + tempDataset + " / " + tempAction);
                gotOne = true;
            } else {
                System.out.println("Skipping " + tempDataset + " / " + tempAction);
            }
        }
        return tempAction;        
    }
    
    public void setUpSeenIt(JSONArray datasets) {
        this.datasets = datasets;
        int totalItems = 0;
        for (int i = 0; i < datasets.length();  i++) {
            JSONObject ds = datasets.getJSONObject(i);
            JSONArray items = ds.getJSONArray(entryListTag);
            Boolean[] sIEntry = new Boolean[items.length()];
            for (int j = 0; j < items.length(); j++) {
                sIEntry[j] = false;
                totalItems++;
            }
            seenIt.put(i, sIEntry);
            
        }
        System.out.println("Dataset count: " + datasets.length() + "; Total items:  " + totalItems);
    }
    
}
