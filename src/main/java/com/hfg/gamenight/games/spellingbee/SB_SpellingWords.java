/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.spellingbee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jkelley
 */
public class SB_SpellingWords {
    private final ArrayList<String> wordList = new ArrayList<>();
    private final ArrayList<String> selectedWordList = new ArrayList<>();
    private int numWords = 4800;
    
    public void loadList() {
        BufferedReader reader;
        int wordCount = 0;
        try {
            //reader = new BufferedReader(new FileReader("words.txt"));
            reader = new BufferedReader(new FileReader("data/newWords.txt"));
            String line = reader.readLine();
            
            while (line != null) {
                if (!wordList.contains(line.toUpperCase())) {
                    
                        wordList.add(line.toUpperCase());
                        wordCount++;
                    
                }
                // read next line
                line = reader.readLine();
                if (wordCount%1000 == 0) {
                    System.out.print(".");
                }
            }

            reader.close();
            numWords = wordCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void dumpList() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("updated_words.txt");
            int zz = 0;
            for (int i = 0; i < wordList.size(); i++) {
                if (zz > 0 ) {
                    fw.write("\t");
                }
                fw.write(wordList.get(i).toUpperCase());
                zz++;
                if (zz == 5) {
                    fw.write("\n");
                    zz = 0;
                }
            }
            fw.close();
        } catch (Exception ex) {
            
        } 
    }
    
    public void clearWordList() {
        wordList.clear();
    }
    
    public void dumpSpecifiedLengthWordsFiveColumns(int length) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("updated_words_" + length + ".txt");
            int zz = 0;
            for (int i = 0; i < wordList.size(); i++) {
                
                String curWord = wordList.get(i).toUpperCase();
                if (curWord.length() == length) {
                    if (zz > 0) {
                        fw.write("\t");
                    }
                    fw.write(curWord);
                    zz++;
                    if (zz == 5) {
                        fw.write("\n");
                        zz = 0;
                    }
                    
                }
            }
            fw.close();
        } catch (Exception ex) {
            
        }
    }
    
    public void dumpSpecifiedLengthWordsFourColumns(int length) {
        FileWriter fw = null;
        try {
            int zz = 0;
            fw = new FileWriter("updated_words_" + length + ".txt");
            for (int i = 0; i < wordList.size(); i++) {
                String curWord = wordList.get(i).toUpperCase();
                if (curWord.length() == length) {
                    if (zz > 0) {
                        fw.write("\t");
                    }
                    fw.write(curWord);
                    zz++;
                    if (zz == 4) {
                        fw.write("\n");
                        zz = 0;
                    }
                    
                }
            }
            fw.close();
        } catch (Exception ex) {
            
        }
    }
    
    public void getSelectedWords() {
        boolean done = false;
        Random myRand = new Random();
        myRand.setSeed(System.currentTimeMillis());
        int wordCount = 0;
        while (!done) {
            String word = wordList.get(myRand.nextInt(numWords));
            if (!selectedWordList.contains(word) && word.length() > 4) {
                selectedWordList.add(word);
                wordCount++;
            }
            if (wordCount == 250) {
                done = true;
            }
            
        }
        System.out.println();
        System.out.println();
    }
    
    public void getSelectedFixedLetterWords(int wordLength) {
        boolean done = false;
        Random myRand = new Random();
        myRand.setSeed(System.currentTimeMillis());
        int wordCount = 0;
        while (!done) {
            String word = wordList.get(myRand.nextInt(numWords));
            if (!selectedWordList.contains(word) && word.length() == wordLength) {
                selectedWordList.add(word);
                wordCount++;
            }
            if (wordCount == 250) {
                done = true;
            }
            
        }
        System.out.println();
        System.out.println();
    }
    
    public void getSelectedShorterWords(int length) {
        boolean done = false;
        Random myRand = new Random();
        myRand.setSeed(System.currentTimeMillis());
        int wordCount = 0;
        while (!done) {
            String word = wordList.get(myRand.nextInt(numWords));
            if (!selectedWordList.contains(word) && word.length() < length) {
                selectedWordList.add(word);
                wordCount++;
            }
            if (wordCount == 250) {
                done = true;
            }
            
        }
        System.out.println();
        System.out.println();
    }

    public int getCountByLength(int length) {
        int wordCount = 0;
        for (int i = 0; i < wordList.size(); i++) {
                String curWord = wordList.get(i).toUpperCase();
                if (curWord.length() == length) {
                    wordCount++;
                }
            }
        return wordCount;
    }
    
    public ArrayList<String> getWordList() {
        return wordList;
    }

    public ArrayList<String> getSelectedWordList() {
        return selectedWordList;
    }

    public int getNumWords() {
        return numWords;
    }
}
