/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games;

import com.hfg.gamenight.games.spellingbee.SB_GameScreen;
import com.hfg.gamenight.games.spellingbee.SB_SpellingWords;
import com.hfg.gamenight.games.spellingbee.SB_WordWheel;
import java.util.ArrayList;

/**
 *
 * @author jkelley
 */
public class SpellingBee {
    private static final SB_SpellingWords myWords = new SB_SpellingWords();
    
    public void runMe() {
        //SpellingWords myWords = new SpellingWords();
        myWords.clearWordList();
        myWords.loadList();
        
        SB_WordWheel myWheel = new SB_WordWheel();
        
        SB_GameScreen myGS = new SB_GameScreen();
        myGS.setWordList(myWords);
        myWords.getSelectedFixedLetterWords(8);
        ArrayList<String> swl = myWords.getSelectedWordList();
        for (String word : swl) {
            myGS.addWordtoWordList(word);
        }
        myWords.getSelectedFixedLetterWords(9);
        swl = myWords.getSelectedWordList();
        for (String word : swl) {
            myGS.addWordtoWordList(word);
        }
        myGS.setWordWheel(myWheel);
        myGS.display();
    }
    
}
