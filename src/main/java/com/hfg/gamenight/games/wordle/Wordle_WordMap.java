/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.wordle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author jkelley
 */
public class Wordle_WordMap {
    private final String baseDir = "./data/";
    private final String wordListFileName = "wordle_wordlist.txt";
    private final String wordleDictionaryFileName = "wordle_dictionary.txt";
    private final String wordleDictionary2FileName = "wordle_dictionary_two.txt";
    private final HashSet<String> dictionary = new HashSet<>();
    private final HashSet<String> wordList = new HashSet<>();
    private final HashSet<String> dictionary2 = new HashSet<>();
    private final Random myRand = new Random(System.currentTimeMillis());
    
    public void loadWordList() {
        String filePath = baseDir + wordListFileName;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\n");
            for (String word : words) {
                if (word.length() == 5) {
                    wordList.add(word);
                } else {
                    System.out.println(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } 
    }
    
    public void loadDictionary() {
        String filePath = baseDir + wordleDictionaryFileName;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\n");
            int count = 0;
            for (String word : words) {
                if (word.length() == 5) {
                    dictionary.add(word);
                } else {
                    System.out.println(count + " :: " + word);
                }
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public void loadDictionary2() {
        String filePath = baseDir + wordleDictionary2FileName;
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] words = content.split("\\n");
            int count = 0;
            for (String word : words) {
                if (word.length() == 5 && !dictionary2.contains(word)) {
                    dictionary2.add(word);
                } else {
                    System.out.println(count + " :: " + word);
                }
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public String selectWord() {
        int index = myRand.nextInt(wordList.size());
        return (String) wordList.toArray()[index];
    }
    
    public boolean isWordInDictionary(String word) {
        boolean retVal = false;
        System.out.println("Checking: " + word + " against dictionary");
        if (dictionary.contains(word)) {
            retVal = true;
        }
        return retVal;
    }
    
    public void show25() {
        int count = 0;
        Iterator dictIt = dictionary.iterator();
        while (dictIt.hasNext()) {
            String word = (String) dictIt.next();
            if (!wordList.contains(word.toLowerCase())) {
                count++;
                System.out.println(count + " :: " + word);
            }
        }
    }
}
