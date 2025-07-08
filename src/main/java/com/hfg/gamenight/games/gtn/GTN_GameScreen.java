/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.gtn;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author jkelley
 */
public class GTN_GameScreen implements ActionListener {
    
    private final Color myLightGray = new Color(0.9f, 0.9f, 0.9f);
    private final Integer rbX = 150;
    private final Integer rbHeight = 30;
    private final Integer rbWidth = 100;
    private final Integer rb1Y = 50;
    private final Integer rb2Y = 125;
    private final Integer rb3Y = 200;
    private final Integer rb4Y = 275;
    private final String rbLabel1 = "Reveal";
    private final String rbLabel2 = "Pump It Up";
    private final Font font = new Font("Arial", 2, 24);
    private final String closeButtonName = "closeButton";
    private final String regexString = "\\^\\^\\^";
    private Integer numRounds = 0;
    private ArrayList<ArrayList<String>> allEvents = null;
    private final JFrame frame = new JFrame();
    private TextArea event1 = null;
    private TextArea event2 = null;
    private TextArea event3 = null;
    private TextArea event4 = null;
    private Button button1 = null;
    //private Button button2 = null;
    //private Button button3 = null;
    //private Button button4 = null;
    private TextArea answer1 = null;
    private TextArea answer2 = null;
    private TextArea answer3 = null;
    private TextArea answer4 = null;  
    private boolean selectedOne = false;
    private boolean selectedTwo = false;
    private boolean selectedThree = false;
    private boolean selectedFour = false;
    private final Button closeButton = new Button("Next");
    private int score = 0;
    private Label scoreLabel = new Label("Score: 0");

    
    
    
    /**
    * This method will create a Frame with the appropriate Buttons TextAreas.
    * @param round int the round number
    * @param eventList list of events to use for this round
    */
    public void Display(int round, ArrayList<String> eventList)
    {
        // Create a frame title
        
        frame.setTitle("Round " + round);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Event text areas and reveal button
        setupEventTextAreas(round);
        setupRevealButtons(round);
        setupAnswerTextAreas(round);
    
        //Add check boxes to select
        //Mode
        CheckboxGroup mode = new CheckboxGroup();
        
        Checkbox eventOne = new Checkbox("1.", mode, false);
        Checkbox eventTwo = new Checkbox("2.", mode, false);
        Checkbox eventThree = new Checkbox("3.", mode, false);
        Checkbox eventFour = new Checkbox("4.", mode, false);
        
        eventOne.setName("eventOne");
        eventTwo.setName("eventTwo");
        eventThree.setName("eventThree");
        eventFour.setName("eventFour");
        
        eventOne.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    resetSelectedAnswer(1);
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        eventTwo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    resetSelectedAnswer(2);
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        eventThree.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    resetSelectedAnswer(3);
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        eventFour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Checkbox selected = (Checkbox) e.getSource();
                    resetSelectedAnswer(4);
                    System.out.println("Selected: " + selected.getLabel());
                }
            }
        });
        eventOne.setBounds(50, 60, 90, 30);
        eventTwo.setBounds(50, 135, 90, 30);
        eventThree.setBounds(50, 210, 90, 30);
        eventFour.setBounds(50, 285, 90, 30);
    
        //For loop to load events and answers/years
        int count = 1;
        for (String ev : eventList) {
            String[] parts = ev.split(regexString);
            switch (count) {
                case 1:
                    answer1.setText(parts[0]);
                    event1.setText(parts[1]);
                    event1.setCaretPosition(0);
                    break;
                case 2:
                    answer2.setText(parts[0]);
                    event2.setText(parts[1]);
                    event2.setCaretPosition(0);
                    break;
                case 3:
                    answer3.setText(parts[0]);
                    event3.setText(parts[1]);
                    event3.setCaretPosition(0);
                    break;
                case 4:
                    answer4.setText(parts[0]);
                    event4.setText(parts[1]);
                    event4.setCaretPosition(0);
                    break;
                default:
                    break;
            }
            count++;
        }
        
        //ScoreLabel
        scoreLabel.setBounds(450, 362, 100, 30);
        frame.add(scoreLabel);
        // Identify the close button
        if (round == 1) {
            closeButton.setName(closeButtonName);
            closeButton.addActionListener(this);
            closeButton.setBounds(800, 362, 100, 50);
        }
        // Add everything to the frame
        frame.add(button1);
        frame.add(eventOne);
        frame.add(eventTwo);
        frame.add(eventThree);
        frame.add(eventFour);
        frame.add(closeButton);
        frame.add(event1);
        frame.add(event2);
        frame.add(event3);
        frame.add(event4);
        frame.add(answer1);
        frame.add(answer2);
        frame.add(answer3);
        frame.add(answer4);
        
        // Set the frame size and layout
        frame.setSize(1000, 475);
        frame.setLayout(null);

        // Set the frame visibility to true fro frame 1, only
        frame.setVisible(true);
        
        //Get the "answer" to help "Reveal" the answer
        getOffYear(answer1, answer2, answer3, answer4);
    }
    
    /**
    * This method will create a "reveal" button
    * @param count int identifies the button to create, used to position and name the component
    */
    private void setupRevealButtons(int round) {
        if (round == 1) {
            button1 = new Button(rbLabel1);
            button1.setName("rb_1");
            button1.addActionListener(this);
            button1.setBounds(100, 362, 100, 50);
            //button2 = new Button("Reveal");
            //button2.setName("rb_2");
            //button2.addActionListener(this);
            //button2.setBounds(rbX, rb2Y, rbWidth, rbHeight);
            //button3 = new Button("Reveal");
            //button3.setName("rb_3");
            //button3.addActionListener(this);
            //button3.setBounds(rbX, rb3Y, rbWidth, rbHeight);
            //button4 = new Button("Reveal");
            //button4.setName("rb_4");
            //button4.addActionListener(this);
            //button4.setBounds(rbX, rb4Y, rbWidth, rbHeight);
        } else {
            button1.setLabel(rbLabel1);
            //button2.setLabel(rbLabel1);
            //button3.setLabel(rbLabel1);
            //button4.setLabel(rbLabel1);
        }
        
    }
    
    /**
    * This method will create an "Event" text area to display the event
    * @param count int identifies the event area to create, used to position and name the component
    */
    private void setupEventTextAreas(int round) {
        if (round == 1) {
            event1 = new TextArea("", 2, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
            event1.setBackground(myLightGray);
            event1.setFont(font);
            event1.setBounds(250, 50, 700, 45);
            event2 = new TextArea("", 2, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
            event2.setBackground(myLightGray);
            event2.setFont(font);
            event2.setBounds(250, 125, 700, 45);
            event3 = new TextArea("", 2, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
            event3.setBackground(myLightGray);
            event3.setFont(font);
            event3.setBounds(250, 200, 700, 45);
            event4 = new TextArea("", 2, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
            event4.setBackground(myLightGray);
            event4.setFont(font);
            event4.setBounds(250, 275, 700, 45);
        }
    }
    
    /**
    * This method will create an "Answer" text area to display the year associated with the event
    * @param count int identifies the answer area to create, used to position and name the component
    */
    private void setupAnswerTextAreas(int round) {
        if (round == 1) {
            answer1 = new TextArea();
            answer1.setBackground(myLightGray);
            answer1.setFont(font);
            answer1.setBounds(140, 55, 80, 40);
            answer1.setName("answer1");
            answer2 = new TextArea();
            answer2.setBackground(myLightGray);
            answer2.setFont(font);
            answer2.setBounds(140, 130, 80, 40);
            answer2.setName("answer2");
            answer3 = new TextArea();
            answer3.setBackground(myLightGray);
            answer3.setFont(font);
            answer3.setBounds(140, 205, 80, 40);
            answer3.setName("answer3");
            answer4 = new TextArea();
            answer4.setBackground(myLightGray);
            answer4.setFont(font);
            answer4.setBounds(140, 280, 80, 40);
            answer4.setName("answer4");
        }
        answer1.setForeground(myLightGray);
        answer2.setForeground(myLightGray);
        answer3.setForeground(myLightGray);
        answer4.setForeground(myLightGray);
    }

    /**
    * This method will toggle visibility of an answer area and the label of the clicked button
    * @param curButton Button identifies the Button that has been clicked
    */
    private void revealButtonClick(Button curButton) {
        
        
        Integer offYear = getOffYear(answer1, answer2, answer3, answer4);

        if (null != offYear) switch (offYear) {
            case 1:
                answer1.setForeground(Color.red);
                answer2.setForeground(Color.black);
                answer3.setForeground(Color.black);
                answer4.setForeground(Color.black);
                if (selectedOne) {
                    score++;
                }
                break;
            case 2:
                answer1.setForeground(Color.black);
                answer2.setForeground(Color.red);
                answer3.setForeground(Color.black);
                answer4.setForeground(Color.black);
                if (selectedTwo) {
                    score++;
                }
                break;
            case 3:
                answer1.setForeground(Color.black);
                answer2.setForeground(Color.black);
                answer3.setForeground(Color.red);
                answer4.setForeground(Color.black);
                if (selectedThree) {
                    score++;
                }
                break;
            case 4:
                answer1.setForeground(Color.black);
                answer2.setForeground(Color.black);
                answer3.setForeground(Color.black);
                answer4.setForeground(Color.red);
                if (selectedFour) {
                    score++;
                }
                break;
            default:
                break;
        }
        scoreLabel.setText("Score: " + score);
        System.out.println("Score: " + score);
        curButton.setLabel(rbLabel2);    
    }
       
    /**
    * This method is the implementation of the ActionListener.actionPerformed() method
    * @param e ActionEventidentifies action.  Used to get the button that was clicked and perform the appropriate action
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        Button curButton = (Button) e.getSource();
        String buttonName = curButton.getName();
        JFrame curFrame = (JFrame) curButton.getParent();
        if (buttonName.equals(closeButtonName)) {       
            String fTitle = curFrame.getTitle();
            switch (fTitle) {
                case "Round 1":
                    this.Display(2, allEvents.get(1));
                    break;
                case "Round 2":
                    this.Display(3, allEvents.get(2));
                    break;
                case "Round 3":
                    this.Display(4, allEvents.get(3));
                    break;
                case "Round 4":
                    this.Display(5, allEvents.get(4));
                    break;
                case "Round 5":
                    if (numRounds == 5) {
                        curFrame.dispose();
                    } else {
                        this.Display(6, allEvents.get(5));
                    }
                    break;
                case "Round 6":
                    this.Display(7, allEvents.get(6));
                    break;
                case "Round 7":
                    this.Display(8, allEvents.get(7));
                    break;
                case "Round 8":
                    this.Display(9, allEvents.get(8));
                    break;
                case "Round 9":
                    this.Display(10, allEvents.get(9));
                    break;
                case "Round 10":
                    System.out.println("num rounds:  " + numRounds);
                    if (numRounds == 10) {
                        curFrame.dispose();
                    } else {
                        this.Display(11, allEvents.get(10));
                    }
                    break;
                case "Round 11":
                    this.Display(12, allEvents.get(11));
                    break;
                case "Round 12":
                    this.Display(13, allEvents.get(12));
                    break;
                case "Round 13":
                    this.Display(14, allEvents.get(13));
                    break;
                case "Round 14":
                    this.Display(15, allEvents.get(14));
                    break;
                case "Round 15":
                    this.Display(16, allEvents.get(15));
                    break;
                case "Round 16":
                    this.Display(17, allEvents.get(16));
                    break;
                case "Round 17":
                    this.Display(18, allEvents.get(17));
                    break;
                case "Round 18":
                    this.Display(19, allEvents.get(18));
                    break;
                case "Round 19":
                    this.Display(20, allEvents.get(19));
                    break;
                default:
                    curFrame.dispose();
            }   
        } else {
            revealButtonClick(curButton);
        }
    }
    
    /**
    * This method will calculate the "answer" in order to manage the text colors of the answer textareas
    * @param answer1 TextArea answer1 text area
    * @param answer2 TextArea answer2 text area
    * @param answer3 TextArea answer3 text area
    * @param answer4 TextArea answer4 text area
    */
    private Integer getOffYear(TextArea answer1, TextArea answer2, TextArea answer3, TextArea answer4) {
        int offYear = 0;
        if (answer1.getText().equals(answer2.getText())) {
            if (answer2.getText().equals(answer3.getText())) {
                offYear = 4;
            } else {
                offYear = 3;
            }
        } else {
            if (answer2.getText().equals(answer3.getText())) {
                offYear = 1;
            } else {
                offYear = 2;
            }
        }
        return offYear;
    }
    
    public void setNumRounds(Integer num) {
        numRounds = num;
    }
    
    public void setAllEvents(ArrayList<ArrayList<String>> allEvents) {
        this.allEvents = allEvents;
    }
    
    private void resetSelectedAnswer(int ans) {
        selectedOne = false;
        selectedTwo = false;
        selectedThree = false;
        selectedFour = false;
        switch (ans) {
            case 1 -> selectedOne = true;
            case 2 -> selectedTwo = true;
            case 3 -> selectedThree = true;
            case 4 -> selectedFour = true;
        }
    }
}
