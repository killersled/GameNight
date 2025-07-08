/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.connections;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jkelley
 */
public class CONN_GameScreen implements ActionListener {
    private final JFrame frame = new JFrame();
    private final JButton l11 = new JButton();
    private final JButton l12 = new JButton();
    private final JButton l13 = new JButton();
    private final JButton l14 = new JButton();
    private final JButton l21 = new JButton();
    private final JButton l22 = new JButton();
    private final JButton l23 = new JButton();
    private final JButton l24 = new JButton();
    private final JButton l31 = new JButton();
    private final JButton l32 = new JButton();
    private final JButton l33 = new JButton();
    private final JButton l34 = new JButton();
    private final JButton l41 = new JButton();
    private final JButton l42 = new JButton();
    private final JButton l43 = new JButton();
    private final JButton l44 = new JButton();
    private final JButton selectButton = new JButton();
    private final JLabel badGuesses = new JLabel();
    private final Integer defaultWidth = 1000;
    private final Integer defaultHeight = 600;
    private final Double col1XPct = 0.1;
    private final Double col2XPct = 0.275;
    private final Double col3XPct = 0.45;
    private final Double col4XPct = 0.625;
    
    private final Double row1YPct = 0.08333;
    private final Double row2YPct = 0.2;
    private final Double row3YPct = 0.31667;
    private final Double row4YPct = 0.43333;
    
    private final Double buttonWPct = 0.175;
    private final Double buttonHPct = 0.08333;
    private final Double selectXPct = 0.825;
    private final Double selectYPct = 0.25833;
    private final Double blXPct = 0.45;
    private final Double blYPct = .54167;
    private final Double selectWPct = 0.1;
    private final Double selectHPct = 0.08333;
    private final Double blWPct = 0.15;
    private final Double blHPct = 0.05;
    private final Double catX1Pct = 0.05;
    private final Double catY1Pct = 0.66666;
    private final Double catWPct = 0.4;
    private final Double catHPct = 0.125;
    private final Double catX2Pct = 0.55;
    private final Double catY2Pct = 0.83333;
    private final JTextArea cat1 = new JTextArea();
    private final JTextArea cat2 = new JTextArea();
    private final JTextArea cat3 = new JTextArea();
    private final JTextArea cat4 = new JTextArea();
    private CONN_DataMap curDM;
    private final Color purple = new Color(203, 195, 227);
    private final Font normal = new Font("Digital", Font.PLAIN, 18);
    private final Font small = new Font("Digital", Font.PLAIN, 12);
    private final Font tiny = new Font("Digital", Font.PLAIN, 8);
    private final Font maxFont = new Font("Digital", Font.PLAIN, 30);
    private Integer badGuessCount = 0;
    private Integer playingDataset = 0;
    private CONN_MenuHandler menuHandler = new CONN_MenuHandler();        
           
    
    public void Display(int round, ArrayList<String> eventList)
    {
        // Create a frame title
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem settingsItem = new JMenuItem("Settings...");
        JMenuItem maxItem = new JMenuItem("Maximize");
        settingsItem.addActionListener(menuHandler);
        maxItem.addActionListener(menuHandler);
        menuHandler.setCat4(cat4);
        menuHandler.setCat2(cat2);
        menuHandler.setCat3(cat3);
        menuHandler.setCat1(cat1);
        menuHandler.setL44(l44);
        menuHandler.setL43(l43);
        menuHandler.setL42(l42);
        menuHandler.setL41(l41);
        menuHandler.setL14(l14);
        menuHandler.setL24(l24);
        menuHandler.setL34(l34);
        menuHandler.setL11(l11);
        menuHandler.setL12(l12);
        menuHandler.setL13(l13);
        menuHandler.setL21(l21);
        menuHandler.setL22(l22);
        menuHandler.setL23(l23);
        menuHandler.setL31(l31);
        menuHandler.setL32(l32);
        menuHandler.setL33(l33);
        menuHandler.setSelect(selectButton);
        menuHandler.setGuesses(badGuesses);
        menuHandler.setGS(frame);
        fileMenu.add(settingsItem);
        fileMenu.add(maxItem);
        fileMenu.addSeparator();

        // Create an "Exit" menu item with an action listener
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(menuHandler);
        
          //Added exit as item in MenuItem
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        frame.setTitle("Fake Connections");
        setupButtons();
        frame.add(l11);
        frame.add(l12);
        frame.add(l13);
        frame.add(l14);
        frame.add(l21);
        frame.add(l22);
        frame.add(l23);
        frame.add(l24);
        frame.add(l31);
        frame.add(l32);
        frame.add(l33);
        frame.add(l34);
        frame.add(l41);
        frame.add(l42);
        frame.add(l43);
        frame.add(l44);
        frame.add(cat1);
        frame.add(cat2);
        frame.add(cat3);
        frame.add(cat4);
        frame.add(selectButton);
        frame.add(badGuesses);
        // Set the frame size and layout
        frame.setSize(defaultWidth, defaultHeight);
        frame.setLayout(null);

        
        // Set the frame visibility to true fro frame 1, only
        frame.setVisible(true);
    }
    
    private void setupButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(l11);
        buttons.add(l12);
        buttons.add(l13);
        buttons.add(l14);
        buttons.add(l21);
        buttons.add(l22);
        buttons.add(l23);
        buttons.add(l24);
        buttons.add(l31);
        buttons.add(l32);
        buttons.add(l33);
        buttons.add(l34);
        buttons.add(l41);
        buttons.add(l42);
        buttons.add(l43);
        buttons.add(l44);
        Double c1X = defaultWidth * col1XPct;
        Double c2X = defaultWidth * col2XPct;
        Double c3X = defaultWidth * col3XPct;
        Double c4X = defaultWidth * col4XPct;
        Double r1Y = defaultHeight * row1YPct;
        Double r2Y = defaultHeight * row2YPct;
        Double r3Y = defaultHeight * row3YPct;
        Double r4Y = defaultHeight * row4YPct;
        Double bw = defaultWidth * buttonWPct;
        Double bh = defaultHeight * buttonHPct;
        l11.setBounds(c1X.intValue(), r1Y.intValue(), bw.intValue(), bh.intValue());
        l12.setBounds(c2X.intValue(), r1Y.intValue(), bw.intValue(), bh.intValue());
        l13.setBounds(c3X.intValue(), r1Y.intValue(), bw.intValue(), bh.intValue());
        l14.setBounds(c4X.intValue(), r1Y.intValue(), bw.intValue(), bh.intValue());
        l11.setText(curDM.getTermbyIndex(0));
        l12.setText(curDM.getTermbyIndex(1));
        l13.setText(curDM.getTermbyIndex(2));
        l14.setText(curDM.getTermbyIndex(3));
        l21.setBounds(c1X.intValue(), r2Y.intValue(), bw.intValue(), bh.intValue());
        l22.setBounds(c2X.intValue(), r2Y.intValue(), bw.intValue(), bh.intValue());
        l23.setBounds(c3X.intValue(), r2Y.intValue(), bw.intValue(), bh.intValue());
        l24.setBounds(c4X.intValue(), r2Y.intValue(), bw.intValue(), bh.intValue());
        l21.setText(curDM.getTermbyIndex(4));
        l22.setText(curDM.getTermbyIndex(5));
        l23.setText(curDM.getTermbyIndex(6));
        l24.setText(curDM.getTermbyIndex(7));
        l31.setBounds(c1X.intValue(), r3Y.intValue(), bw.intValue(), bh.intValue());
        l32.setBounds(c2X.intValue(), r3Y.intValue(), bw.intValue(), bh.intValue());
        l33.setBounds(c3X.intValue(), r3Y.intValue(), bw.intValue(), bh.intValue());
        l34.setBounds(c4X.intValue(), r3Y.intValue(), bw.intValue(), bh.intValue());
        l31.setText(curDM.getTermbyIndex(8));
        l32.setText(curDM.getTermbyIndex(9));
        l33.setText(curDM.getTermbyIndex(10));
        l34.setText(curDM.getTermbyIndex(11));
        l41.setBounds(c1X.intValue(), r4Y.intValue(), bw.intValue(), bh.intValue());
        l42.setBounds(c2X.intValue(), r4Y.intValue(), bw.intValue(), bh.intValue());
        l43.setBounds(c3X.intValue(), r4Y.intValue(), bw.intValue(), bh.intValue());
        l44.setBounds(c4X.intValue(), r4Y.intValue(), bw.intValue(), bh.intValue());
        l41.setText(curDM.getTermbyIndex(12));
        l42.setText(curDM.getTermbyIndex(13));
        l43.setText(curDM.getTermbyIndex(14));
        l44.setText(curDM.getTermbyIndex(15));
        l11.setName("l11");
        l12.setName("l12");
        l13.setName("l13");
        l14.setName("l14");
        l21.setName("l21");
        l22.setName("l22");
        l23.setName("l23");
        l24.setName("l24");
        l31.setName("l31");
        l32.setName("l32");
        l33.setName("l33");
        l34.setName("l34");
        l41.setName("l41");
        l42.setName("l42");
        l43.setName("l43");
        l44.setName("l44");

        for(JButton curButton : buttons) {
            curButton.setBackground(Color.LIGHT_GRAY);
            curButton.setForeground(Color.BLACK);
            curButton.addActionListener(this);
            curButton.setVisible(true);
            String buttonLabel = curButton.getText();
            if (buttonLabel.length() > 25) {
                curButton.setFont(tiny);
            } else if (buttonLabel.length() > 15) {
                curButton.setFont(small);
            } else {
                curButton.setFont(normal);
            }
        }
        //Categories
        Double x1 = defaultWidth * catX1Pct;
        Double y1 = defaultHeight * catY1Pct;
        Double sW = defaultWidth * catWPct;
        Double sH = defaultHeight * catHPct;
        Double x2 = defaultWidth * catX2Pct;
        Double y2 = defaultHeight * catY2Pct;
        cat1.setBounds(x1.intValue(), y1.intValue(), sW.intValue(), sH.intValue());
        cat2.setBounds(x2.intValue(), y1.intValue(), sW.intValue(), sH.intValue());
        cat3.setBounds(x1.intValue(), y2.intValue(), sW.intValue(), sH.intValue());
        cat4.setBounds(x2.intValue(), y2.intValue(), sW.intValue(), sH.intValue());
        cat1.setBackground(Color.CYAN);
        cat2.setBackground(Color.YELLOW);
        cat3.setBackground(Color.GREEN);
        cat4.setBackground(purple);
        cat1.setVisible(false);
        cat2.setVisible(false);
        cat3.setVisible(false);
        cat4.setVisible(false);
        Integer catNum = curDM.getCategoryNumberbyIndex(0);
        cat1.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        catNum = curDM.getCategoryNumberbyIndex(1);
        cat2.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        catNum = curDM.getCategoryNumberbyIndex(2);
        cat3.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        catNum = curDM.getCategoryNumberbyIndex(3);
        cat4.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        cat1.setVisible(false);
        cat1.setCaretPosition(0);
        cat1.setEditable(false);
        cat2.setVisible(false);
        cat2.setCaretPosition(0);
        cat2.setEditable(false);
        cat3.setVisible(false);
        cat3.setCaretPosition(0);
        cat3.setEditable(false);
        cat4.setVisible(false);
        cat4.setCaretPosition(0);
        cat4.setEditable(false);
        //Select button
        Double sbX = defaultWidth * selectXPct;
        Double sbY = defaultHeight * selectYPct;
        Double sbW = defaultWidth * selectWPct;
        Double sbH = defaultHeight * selectHPct;
        selectButton.setBounds(sbX.intValue(), sbY.intValue(), sbW.intValue(), sbH.intValue());
        selectButton.addActionListener(this);
        selectButton.setText("Select");
        selectButton.setName("selectButton");
        Double bgX = defaultWidth * blXPct;
        Double bgY = defaultHeight * blYPct;
        Double bgW = defaultWidth * blWPct;
        Double bgH = defaultHeight * blHPct;
        badGuesses.setText("Bad Guesses: 0");
        badGuesses.setBounds(bgX.intValue(), bgY.intValue(), bgW.intValue(), bgH.intValue());
    }
    
    private void resetButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(l11);
        buttons.add(l12);
        buttons.add(l13);
        buttons.add(l14);
        buttons.add(l21);
        buttons.add(l22);
        buttons.add(l23);
        buttons.add(l24);
        buttons.add(l31);
        buttons.add(l32);
        buttons.add(l33);
        buttons.add(l34);
        buttons.add(l41);
        buttons.add(l42);
        buttons.add(l43);
        buttons.add(l44);
        
        l11.setText(curDM.getTermbyIndex(0));
        l12.setText(curDM.getTermbyIndex(1));
        l13.setText(curDM.getTermbyIndex(2));
        l14.setText(curDM.getTermbyIndex(3));
        l21.setText(curDM.getTermbyIndex(4));
        l22.setText(curDM.getTermbyIndex(5));
        l23.setText(curDM.getTermbyIndex(6));
        l24.setText(curDM.getTermbyIndex(7));
        l31.setText(curDM.getTermbyIndex(8));
        l32.setText(curDM.getTermbyIndex(9));
        l33.setText(curDM.getTermbyIndex(10));
        l34.setText(curDM.getTermbyIndex(11));
        l41.setText(curDM.getTermbyIndex(12));
        l42.setText(curDM.getTermbyIndex(13));
        l43.setText(curDM.getTermbyIndex(14));
        l44.setText(curDM.getTermbyIndex(15));
        
        for(JButton curButton : buttons) {
            curButton.setBackground(Color.LIGHT_GRAY);
            curButton.setForeground(Color.BLACK);
            curButton.setVisible(true);
            String buttonLabel = curButton.getText();
            if (buttonLabel.length() > 25) {
                if (menuHandler.getMaximized()) {
                    curButton.setFont(normal);
                } else {
                    curButton.setFont(tiny);
                }
            } else if (buttonLabel.length() > 15) {
                if (menuHandler.getMaximized()) {
                    curButton.setFont(normal);
                } else {
                    curButton.setFont(small);
                }
            } else {
                if (menuHandler.getMaximized()) {
                    curButton.setFont(maxFont);
                } else {
                    curButton.setFont(normal);
                }
            }
        }
        //Categories
        Integer catNum = curDM.getCategoryNumberbyIndex(0);
        cat1.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        cat1.setCaretPosition(0);
        catNum = curDM.getCategoryNumberbyIndex(1);
        cat2.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        cat2.setCaretPosition(0);
        catNum = curDM.getCategoryNumberbyIndex(2);
        cat3.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        cat3.setCaretPosition(0);
        catNum = curDM.getCategoryNumberbyIndex(3);
        cat4.setText(curDM.getCategoryName(catNum) + "\n" + curDM.getCategoryTerms(catNum));
        cat4.setCaretPosition(0);
        cat1.setVisible(false);
        cat2.setVisible(false);
        cat3.setVisible(false);
        cat4.setVisible(false);
        //Select button
        selectButton.setText("Select");
        badGuesses.setText("Bad Guesses: 0");
        badGuessCount = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton curButton = (JButton) e.getSource();
        String buttonName = curButton.getName();
        JPanel curPanel = (JPanel) curButton.getParent();
        switch (buttonName) {
            case "selectButton":
                if (curButton.getText().equals("Reset")) {
                    curDM.clearDM();
                    curDM.createMapJSON(playingDataset);
                    resetButtons();
                    frame.repaint();
                } else {
                    isConnection(curPanel);
                }
                break;
            default:
                if (curButton.getBackground() == Color.BLACK) {
                    curButton.setBackground(Color.LIGHT_GRAY);
                    curButton.setForeground(Color.BLACK);
                } else {
                    curButton.setForeground(Color.ORANGE);
                    curButton.setBackground(Color.BLACK);
                }   break;
        }
    }
    
    private void isConnection(JPanel parent) {
        int selectCount = -1;
        int[] selectedTerms = new int[]{-1,-1,-1,-1};
        String[] selectedCats = new String[16];
        for (int i = 0; i < 16; i++) {
            if (parent.getComponent(i).getBackground().equals(Color.BLACK)) {
                selectCount++;
                if (selectCount > 3) {
                    break;
                }
                selectedTerms[selectCount] = i;
                selectedCats[selectCount] = curDM.getCatbyIndex(i);
                
            }        
        }
        if (selectCount == 3) {
            if (selectedCats[0].equals(selectedCats[1]) && selectedCats[1].equals(selectedCats[2]) &&
                    selectedCats[2].equals(selectedCats[3])) {
                Integer temp = Integer.valueOf(selectedCats[0]);
                Integer catNum = -1;
                for (int i = 0; i < 4; i++) {
                    if (temp.equals(curDM.getCategoryNumberbyIndex(i))) {
                        catNum = i;
                        break;
                    }
                } 
                switch (catNum) {
                    case 0:
                        cat1.setVisible(true);
                        break;
                    case 1:
                        cat2.setVisible(true);
                        break;
                    case 2:
                        cat3.setVisible(true);
                        break;
                    default:
                        cat4.setVisible(true);
                }
                for (int i = 0; i < 4; i ++) {
                    JButton but = (JButton) parent.getComponent(selectedTerms[i]);
                    but.setVisible(false);
                    but.setBackground(Color.LIGHT_GRAY);
                }
                if (cat1.isVisible() && cat2.isVisible() && cat3.isVisible() && cat4.isVisible()) {
                    selectButton.setText("Reset");
                }
                
            } else {
                badGuessCount++;
                badGuesses.setText("Bad Guesses: " + badGuessCount);
            }
        }
    }
    
    public void shareDM(CONN_DataMap dm) {
        curDM = dm;
    }
    
    public void setPlayingDataset(Integer num) {
        playingDataset = num;
    }
    
}
