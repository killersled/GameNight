/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.spellingbee;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author jkelley
 */
public class SB_MenuHandler implements ActionListener {
    private SB_ScreenComponents screenComponents = new SB_ScreenComponents();
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
            screenComponents.frame.setVisible(false);
            screenComponents.frame.dispose();
        } else if (curMenuItem.getText().equals("Maximize")) {
            maximize(e);
        } 
    }
    
    private void maximize(ActionEvent e) {
        //JPanel jp = e.getParent();
        screenComponents.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        
        Double W = screenComponents.usualW * w;
        Double H = screenComponents.usualH * h;
        Double X = screenComponents.rootLabelX * w;
        Double Y = screenComponents.rootY * h;
        
        screenComponents.rootWordLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.rootWordLabel.setFont(maxFont);
        X = screenComponents.rootWordX * w;
        screenComponents.rootWord.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.rootWord.setFont(maxFont);
        
        for (int i = 0; i < screenComponents.wordLabels.size(); i++) {
            JLabel curLabel = (JLabel) screenComponents.wordLabels.get(i);
            curLabel.setFont(maxFont);
            int j;
            if (i < 7) {
                //First column
                j = i;
                X = screenComponents.fourX * w;               
            } else if (i < 14) {
                j = i-7;
                X = screenComponents.fiveX * w;
            } else if (i < 21) {
                j = i-14;
                X = screenComponents.sixX * w;
            } else {
                j = i-21;
                 X = screenComponents.sevenX * w;   
            }
            switch(j) {
                case 0:
                    Y = screenComponents.labelRowY * h;
                    if (i == 0) {
                        screenComponents.fourLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.fourLetterLabel.setFont(maxFont);
                    } else if (i == 7) {
                        screenComponents.fiveLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.fiveLetterLabel.setFont(maxFont);
                    } else if (i == 14) {
                        screenComponents.sixLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.sixLetterLabel.setFont(maxFont);
                    } else if (i == 21) {
                        screenComponents.sevenLetterLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                        screenComponents.sevenLetterLabel.setFont(maxFont);
                    }
                    Y = screenComponents.rowOneY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 1:
                    Y = screenComponents.rowTwoY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 2:
                    Y = screenComponents.rowThreeY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 3:
                    Y = screenComponents.rowFourY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 4:
                    Y = screenComponents.rowFiveY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                case 5:
                    Y = screenComponents.rowSixY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;
                default:
                    Y = screenComponents.rowSevenY * h;
                    curLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
                    break;

            }

        }
        
        X = screenComponents.otherX * w;
        W = screenComponents.guessW * w;
        Y = screenComponents.submitWY * h;
        screenComponents.submitWord.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.submitWord.setFont(maxFont);
        Y = screenComponents.guessY * h;
        screenComponents.guessLabel.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.guessLabel.setFont(maxFont);
        W = screenComponents.submitW * w;
        H = screenComponents.submitH * h;
        Y = screenComponents.submitBY * h;
        screenComponents.submitButton.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.submitButton.setFont(maxFont);
        W = screenComponents.remainW * w;
        H = screenComponents.usualH * h;
        Y = screenComponents.remainY * h;
        screenComponents.remainingWords.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        screenComponents.remainingWords.setFont(maxFont);
        

        maximized = true;
    }

    public void setScreenComponents(SB_ScreenComponents screenComponents) {
        this.screenComponents = screenComponents;
    }
    
    public boolean getMaximized() {
        return maximized;
    }
    
}
