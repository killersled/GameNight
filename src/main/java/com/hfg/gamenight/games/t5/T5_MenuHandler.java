/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.t5;

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
public class T5_MenuHandler implements ActionListener{

    private JTextArea AB = null;
    private JLabel NL = null;
    private JLabel RL = null;
    private JLabel TFL = null;
    private JTextArea N1 = null;
    private JTextArea N2 = null;
    private JTextArea N3 = null;
    private JTextArea N4 = null;
    private JTextArea N5 = null;
    private JLabel N1L = null;
    private JLabel N2L = null;
    private JLabel N3L = null;
    private JLabel N4L = null;
    private JLabel N5L = null;
    private JButton l21 = null;
    private JButton l22 = null;
    private JButton RB = null;
    private JButton NB = null;
    private JButton GB = null;
    private JButton CB = null;
    private JTextArea DT = null;
    private JLabel TL = null;
    private JLabel LL = null;
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
        
        Double X = rightEdgeX * w;
        Double Y = topRowY * h;
        Double W = titleLabelW * w;
        Double H = regularH * h;
        TL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        TL.setFont(maxFont);
        Y = descriptY * h;
        W = descriptW * w;
        H = descriptH * h;
        DT.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        DT.setFont(maxFont);
        X = numLabelX * w;
        Y = numFiveY * h;
        W = numLabelW * w;
        H = regularH * h;
        N5L.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numFourY * h;
        N4L.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numThreeY * h;
        N3L.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numTwoY * h;
        N2L.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numOneY * h;
        N1L.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = entriesX * w;
        Y = numFiveY * h;
        W = numBoxW * w;
        N5.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numFourY * h;
        N4.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numThreeY * h;
        N3.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numTwoY * h;
        N2.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = numOneY * h;
        N1.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        N1.setFont(maxFont);
        N2.setFont(maxFont);
        N3.setFont(maxFont);
        N4.setFont(maxFont);
        N5.setFont(maxFont);
        X = topFiveX * w;
        Y = topFiveY * h;
        W = buttonsW * w;
        TFL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = answerX * w;
        Y = answerLabelY * h;
        W = nameLabelW * w;
        NL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = answerBoxY * h;
        W = numBoxW * w;
        AB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        AB.setFont(maxFont);
        X = rankLabelX * w;
        Y = topRowY * h;
        W = rankLabelW * w;
        RL.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        RL.setFont(maxFont);
        X = buttonsX * w;
        Y = revealY * h;
        W = buttonsW * w;
        H = buttonH * h;
        RB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
       
        Y = numFiveY * h;
        NB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        Y = otherButtonsY * h;
        GB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        X = correctX * w;
        CB.setBounds(X.intValue(), Y.intValue(), W.intValue(), H.intValue());
        
        
        //Logo label
        //% are: X (w -120), Y=topRowY (.04167) (keeping W and H at 120)
        Y = topRowY * h;
        
        LL.setBounds((w-120), Y.intValue(), 120, 120);
       
        maximized = true;
    }
    
    public void setTL(JLabel c4) {
        TL = c4;
    }
    
    public void setDT(JTextArea c2) {
        DT = c2;
    }
    
    public void setN5L(JLabel c3) {
        N5L = c3;
    }
    
    public void setN4L(JLabel c1) {
        N4L = c1;
    }
    
    public void setN3L(JLabel l) {
        N3L = l;
    }
    
    public void setN2L(JLabel l) {
        N2L = l;
    }
    
    public void setN1L(JLabel l) {
        N1L = l;
    }
    
    public void setN5(JTextArea l) {
        N5 = l;
    }
    
    public void setN4(JTextArea l) {
        N4 = l;
    }
    
    public void setN3(JTextArea l) {
        N3 = l;
    }
    
    public void setN2(JTextArea l) {
        N2 = l;
    }
    
    public void setN1(JTextArea l) {
        N1 = l;
    }
    
    public void setTFL(JLabel l) {
        TFL = l;
    }
    
    public void setRL(JLabel l) {
        RL = l;
    }
    
    public void setNL(JLabel l) {
        NL = l;
    }
    
    public void setAB(JTextArea l) {
        AB = l;
    }
    
    public void setRB(JButton l) {
        RB = l;
    }
    
    public void setNB(JButton l) {
        NB = l;
    }
    
    public void setGB(JButton l) {
        GB = l;
    }
    
    public void setCB(JButton l) {
        CB = l;
    }
    
    public void setGS(JFrame gScreen) {
        gs = gScreen;
    }
    
    public boolean getMaximized() {
        return maximized;
    }
        
    public void setLL(JLabel l) {
        LL = l;
    }
    
}
