/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.ndc;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author jkelley
 */
public class NDC_MenuHandler implements ActionListener {
    private JTextArea AB = null;
    private JLabel SL = null;
    private JLabel RL = null;
    private JLabel WL = null;
    private JComboBox RCB = null;

    
    private JComboBox WCB = null;
    private JComboBox SCB = null;
    private JComboBox RB = null;
    private JButton SB = null;
    private final Double labelRowY = 0.13333;
    private final Double labelH = 0.06667;
    private final Double labelW = 0.095;
    private final Double comboBoxY = 0.11111; 
    private final Double comboBoxW = 0.16;
    private final Double comboBoxH = 0.15;
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
    
    private JFrame gs = null;
    private final Font maxFont = new Font("Digital", Font.PLAIN, 30);
    private boolean maximized = false;
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem curMenuItem = (JMenuItem) e.getSource();
        if (curMenuItem.getText().equals("Exit")) {
            gs.setVisible(false);
            gs.dispose();
        } else if (curMenuItem.getText().equals("Maximize")) {
            maximize(e);
        } 
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
        
        Double Y = labelRowY * h;
        Double H = labelH * h;
        Double W = labelW * w;
        Double X = roomLabelX * w;
        RL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        RL.setFont(maxFont);
        X = suspectLabelX * w;
        SL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        SL.setFont(maxFont);
        X = weaponLabelX * w;
        WL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        WL.setFont(maxFont);
        Y = comboBoxY * h; // also H
        W = comboBoxW * w;
        X = roomComboBoX * w;
        H = comboBoxH * h;
        RCB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        RCB.setFont(maxFont);
        X = suspectComboBoX * w;
        SCB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        SCB.setFont(maxFont);
        X = weaponComboBoX * w;
        WCB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        WCB.setFont(maxFont);
        
        H = comboBoxH * h;
        W = selectButtonW * w;
        X = selectButtonX * w;
        Y = selectButtonY * h;
        SB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        SB.setFont(maxFont);
        W = resultBoxW * w;
        X = resultBoxX * w;
        Y = resultBoxY * h;
        RB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        RB.setFont(maxFont);
       
        maximized = true;
    }
    
    public void setAB(JTextArea AB) {
        this.AB = AB;
    }

    public void setSL(JLabel SL) {
        this.SL = SL;
    }

    public void setRL(JLabel RL) {
        this.RL = RL;
    }

    public void setWL(JLabel WL) {
        this.WL = WL;
    }

    public void setRCB(JComboBox RCB) {
        this.RCB = RCB;
    }

    public void setWCB(JComboBox WCB) {
        this.WCB = WCB;
    }

    public void setSCB(JComboBox SCB) {
        this.SCB = SCB;
    }

    public void setRB(JComboBox RB) {
        this.RB = RB;
    }

    public void setSB(JButton SB) {
        this.SB = SB;
    }
    
    public void setGS(JFrame gScreen) {
        gs = gScreen;
    }
    
    public boolean getMaximized() {
        return maximized;
    }
        
}
