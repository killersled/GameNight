/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.connections;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author jkelley
 */
public class CONN_MenuHandler implements ActionListener{

    private JTextArea cat4 = null;
    private JTextArea cat2 = null;
    private JTextArea cat3 = null;
    private JTextArea cat1 = null;
    private JButton l44 = null;
    private JButton l43 = null;
    private JButton l42 = null;
    private JButton l41 = null;
    private JButton l14 = null;
    private JButton l24 = null;
    private JButton l34 = null;
    private JButton l11 = null;
    private JButton l12 = null;
    private JButton l13 = null;
    private JButton l21 = null;
    private JButton l22 = null;
    private JButton l23 = null;
    private JButton l31 = null;
    private JButton l32 = null;
    private JButton l33 = null;
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
    private JButton selectButton = null;
    private JLabel guesses = null;
    private JFrame gs = null;
    private final Font maxFont = new Font("Digital", Font.PLAIN, 30);
    private boolean maximized = false;
    
    public void actionPerformed(ActionEvent e) {
        JMenuItem curMenuItem = (JMenuItem) e.getSource();
        if (curMenuItem.getText().equals("Exit")) {
            gs.setVisible(false);
            gs.dispose();
        } else if (curMenuItem.getText().equals("Maximize")) {
            maximize(e);
        } else {
            openSettings();
        }
    }
    
    private void openSettings() {
        JFrame settingsFrame = new JFrame();
        JTextArea fileLocation = new JTextArea();
        fileLocation.setBounds(150,50, 400, 30);
        JLabel flLabel = new JLabel("Data File: ");
        flLabel.setBounds(20, 50, 100, 30);
        fileLocation.setText("../data/datasets.json");
        JButton okButton = new JButton("OK");
        okButton.setBounds(300, 110, 100, 50);
        settingsFrame.add(okButton);
        settingsFrame.add(flLabel);
        settingsFrame.add(fileLocation);
        settingsFrame.setSize(600, 200);
        settingsFrame.setAlwaysOnTop(true);
        settingsFrame.setLayout(null);
        settingsFrame.setVisible(true);
    }
    
    private void maximize(ActionEvent e) {
        //JPanel jp = e.getParent();
        gs.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();
        int width = 0;
        int height = 0; // use 92% for ease
        for (GraphicsDevice device : devices) {
            if (device.getDefaultConfiguration().getBounds().contains(mouseLocation)){
                width = device.getDisplayMode().getWidth();
                Double h = device.getDisplayMode().getHeight() * .92;
                height = h.intValue();
            }
        }
        int h = height;
        int w = width;
        Double x1 = w * catX1Pct;
        Double y1 = h * catY1Pct;
        Double sW = w * catWPct;
        Double sH = h * catHPct;
        Double x2 = w * catX2Pct;
        Double y2 = h * catY2Pct;
        cat4.setBounds(x2.intValue(), y2.intValue(), sW.intValue(), sH.intValue());
        cat4.setFont(maxFont);
        cat2.setBounds(x2.intValue(), y1.intValue(), sW.intValue(), sH.intValue());
        cat2.setFont(maxFont);
        cat1.setBounds(x1.intValue(), y1.intValue(), sW.intValue(), sH.intValue());
        cat1.setFont(maxFont);
        cat3.setBounds(x1.intValue(), y2.intValue(), sW.intValue(), sH.intValue());
        cat3.setFont(maxFont);
        Double blX = width * blXPct;
        Double blY = height * blYPct;
        Double blW = width * blWPct;
        Double blH = height * blHPct;
        guesses.setBounds(blX.intValue(), blY.intValue(), blW.intValue(), blH.intValue());
        guesses.setFont(maxFont);
        Double col1X = width * col1XPct;
        Double col2X = width * col2XPct;
        Double col3X = width * col3XPct;
        Double col4X = width * col4XPct;
        Double row1Y = height * row1YPct;
        Double row2Y = height * row2YPct;
        Double row3Y = height * row3YPct;
        Double row4Y = height * row4YPct;
        Double buttonWidth = width * buttonWPct;
        Double buttonHeight = height * buttonHPct;
        l44.setBounds(col4X.intValue(), row4Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l44.setFont(maxFont);
        l41.setBounds(col1X.intValue(), row4Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l41.setFont(maxFont);
        l42.setBounds(col2X.intValue(), row4Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l43.setBounds(col3X.intValue(), row4Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l42.setFont(maxFont);
        l43.setFont(maxFont);
        l14.setBounds(col4X.intValue(), row1Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l24.setBounds(col4X.intValue(), row2Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l34.setBounds(col4X.intValue(), row3Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l14.setFont(maxFont);
        l24.setFont(maxFont);
        l34.setFont(maxFont);
        l11.setBounds(col1X.intValue(), row1Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l12.setBounds(col2X.intValue(), row1Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l13.setBounds(col3X.intValue(), row1Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l11.setFont(maxFont);
        l12.setFont(maxFont);
        l13.setFont(maxFont);
        l21.setBounds(col1X.intValue(), row2Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l22.setBounds(col2X.intValue(), row2Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l23.setBounds(col3X.intValue(), row2Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l21.setFont(maxFont);
        l22.setFont(maxFont);
        l23.setFont(maxFont);
        l31.setBounds(col1X.intValue(), row3Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l32.setBounds(col2X.intValue(), row3Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l33.setBounds(col3X.intValue(), row3Y.intValue(), buttonWidth.intValue(), buttonHeight.intValue());
        l31.setFont(maxFont);
        l32.setFont(maxFont);
        l33.setFont(maxFont);
        Double selectX = width * selectXPct;
        Double selectY = height * selectYPct;
        Double selectW = width * selectWPct;
        Double selectH = height * selectHPct;
        selectButton.setBounds(selectX.intValue(), selectY.intValue(), selectW.intValue(), selectH.intValue());
        selectButton.setFont(maxFont);
        
        maximized = true;
    }
    
    public void setCat4(JTextArea c4) {
        cat4 = c4;
    }
    
    public void setCat2(JTextArea c2) {
        cat2 = c2;
    }
    
    public void setCat3(JTextArea c3) {
        cat3 = c3;
    }
    
    public void setCat1(JTextArea c1) {
        cat1 = c1;
    }
    
    public void setL44(JButton l) {
        l44 = l;
    }
    
    public void setL43(JButton l) {
        l43 = l;
    }
    
    public void setL42(JButton l) {
        l42 = l;
    }
    
    public void setL41(JButton l) {
        l41 = l;
    }
    
    public void setL14(JButton l) {
        l14 = l;
    }
    
    public void setL24(JButton l) {
        l24 = l;
    }
    
    public void setL34(JButton l) {
        l34 = l;
    }
    
    public void setL11(JButton l) {
        l11 = l;
    }
    
    public void setL12(JButton l) {
        l12 = l;
    }
    
    public void setL13(JButton l) {
        l13 = l;
    }
    
    public void setL21(JButton l) {
        l21 = l;
    }
    
    public void setL22(JButton l) {
        l22 = l;
    }
    
    public void setL23(JButton l) {
        l23 = l;
    }
    
    public void setL31(JButton l) {
        l31 = l;
    }
    
    public void setL32(JButton l) {
        l32 = l;
    }
    
    public void setL33(JButton l) {
        l33 = l;
    }
    
    public void setSelect(JButton l) {
        selectButton = l;
    }
    
    public void setGuesses(JLabel l) {
        guesses = l;
    }
    
    public void setGS(JFrame gScreen) {
        gs = gScreen;
    }
    
    public boolean getMaximized() {
        return maximized;
    }
    
}
