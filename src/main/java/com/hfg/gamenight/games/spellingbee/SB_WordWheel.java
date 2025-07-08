/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.spellingbee;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jkelley
 */
public class SB_WordWheel {
    private String htmlStart = "<html>\n" +
"    <head>\n" +
"        <title>Word Wheel</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body style=\"font-size: 32px\">\n" +
"<div>\n" +
"            <h2>Finding ";
    private String htmlAfterCount = " words in \"";
    private String htmlAfterWord = "\"</h2><br><br>\n" +
"            <center>\n" +
"            <table border=\"1\">";
    
    private String htmlComplete = "</table>\n" +
"            </center>\n" +
"            \n" +
"        </div>        \n" +
"    </body>\n" +
"</html>";
    
    private Long buildID = 0L;

    public Long getBuildID() {
        return buildID;
    }

    public void setBuildID(Long buildID) {
        this.buildID = buildID;
    }

    
    
    private Map<String, Integer> GetLetterMap(String word) {
        Map<String, Integer> charMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i+1);
            Integer curVal = 0;
            if (charMap.containsKey(letter)) {
                curVal = charMap.get(letter);
            }
            curVal += 1;
            charMap.put(letter, curVal);
        }
        return charMap;
    }
    
    /************************************
     * AreMapsEquivalent --
     *    Can the letters (values and quantity) of mapTwo be found within mainMap
     * 
     * @param mainMap -- map of letters making up main word
     * @param mapTwo -- map of letters making up word to check
     * @return boolean, can mapTwo's entries, both number of letters and number of each letter
     */
    private boolean AreMapsEquivalent(Map<String, Integer> mainMap, Map<String, Integer> mapTwo) {
        boolean retVal = false;
        if (mainMap.size() < mapTwo.size()) {
            return retVal;
        }
        Set mainSet = mainMap.keySet();
        Set twoSet = mapTwo.keySet();
        if (mainSet.size() < twoSet.size()) {
            return retVal;
        }
        Iterator myIt = twoSet.iterator();
        while (myIt.hasNext()) {
            String key = (String) myIt.next();
            if (!mainSet.contains(key)) {
                return retVal;
            }
            if (mainMap.get(key) < mapTwo.get(key)) {
                return retVal;
            }
        }
        return true;
    }
    
    /****************************************
     * findAllWheels -- find words from selected word list that can be found 
     * using the letters in the given mainWord  
     * 
     * 
     * @param words -- word list to use
     * @param mainWord -- word to find the words within
     * @return hashset of words found
    *****************************************/
    public HashSet<String> findAllWheels(ArrayList<String> words, String mainWord) {
        HashSet<String> matches = new HashSet<>();
        Map<String, Integer> myMap = GetLetterMap(mainWord);
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            String curWord = words.get(i);
            Map<String, Integer> mapTwo = GetLetterMap(curWord);
            if (AreMapsEquivalent(myMap, mapTwo) && !mainWord.equals(curWord)) {
                matches.add(curWord);
                count++;
            }
        }
        if (count > 100) {
            System.out.println(mainWord + " ==> " + count);
        }
        return matches;
    }
    
    /****************************************
     * find3LetterWheels -- find fixed length words from selected word list that can be found 
     * using the letters in the given mainWord  
     * 
     * @param length -- size words to find
     * @param words -- word list to use
     * @param mainWord -- word to find the words within
     * @return TreeSet of words found
    *****************************************/
    public ArrayList<String> findFixedLetterWheels(int length, ArrayList<String> words, String mainWord) {
        ArrayList<String> matches = new ArrayList<>();
        Map<String, Integer> myMap = GetLetterMap(mainWord);
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            String curWord = words.get(i);
            if (curWord.length() != length) 
                continue;
            Map<String, Integer> mapTwo = GetLetterMap(curWord);
            if (AreMapsEquivalent(myMap, mapTwo) && !mainWord.equals(curWord)) {
                matches.add(curWord);
                count++;
            }
        }
        if (count > 100) {
            System.out.println(mainWord + " ==> " + count);
        }
        return matches;
    }
        
    public void createHTMLPage(String word, TreeSet<String> threeLetterWords, 
            TreeSet<String> fourLetterWords, TreeSet<String> fiveLetterWords, 
            TreeSet<String> sixLetterWords, TreeSet<String> sevenLetterWords, 
            TreeSet<String> eightLetterWords) {
            //print out the table rows
            int threeLSize = threeLetterWords.size();
            int fourLSize = fourLetterWords.size();
            int fiveLSize = fiveLetterWords.size();
            int sixLSize = sixLetterWords.size();
            int sevenLSize = sevenLetterWords.size();
            int eightLSize = eightLetterWords.size();
            int max = threeLSize;
            if (fourLSize > max)
                max = fourLSize;
            if (fiveLSize > max)
                max = fiveLSize;
            if (sixLSize > max)
                max = sixLSize;
            if (sixLSize > max)
                max = sevenLSize;
            if (sevenLSize > max)
                max = eightLSize;
            Integer totalSize = threeLSize + fourLSize + fiveLSize + sixLSize + sevenLSize + eightLSize;
            
            System.out.println("3L : " + threeLSize + ", 4L : " + fourLSize + ", 5L : " + fiveLSize + ", 6L : " + sixLSize);
            System.out.println("7L : " + sevenLSize + ", 8L : " + eightLSize + ", total : " + totalSize);
            Iterator threeLIt = threeLetterWords.iterator();
            Iterator fourLIt = fourLetterWords.iterator();
            Iterator fiveLIt = fiveLetterWords.iterator();
            Iterator sixLIt = sixLetterWords.iterator();
            Iterator sevenLIt = sevenLetterWords.iterator();
            Iterator eightLIt = eightLetterWords.iterator();
            String fileName = getFileName(word);
            
            FileWriter fw = null;
        try {
            int zz = 0;
            fw = new FileWriter(fileName);
            fw.write(htmlStart);
            fw.write(totalSize.toString());
            fw.write(htmlAfterCount);
            fw.write(word);
            fw.write(htmlAfterWord);
            fw.write("\n");
            for (int i = 0; i < max; i++) {
                //<tr><td>1<td style="color: white">IRE<td style="color: white">EMIT<td style="color: white">MERIT</tr>
                StringBuilder rowLine = new StringBuilder();
                rowLine.append("<tr><td>");
                rowLine.append(i+1);
                rowLine.append("<td style=\"color: white\">");
                if (threeLSize > i) {
                    rowLine.append((String)threeLIt.next());
                }
                rowLine.append("<td style=\"color: white\">");
                if (fourLSize > i) {
                    rowLine.append((String)fourLIt.next());
                }
                rowLine.append("<td style=\"color: white\">");
                if (fiveLSize > i) {
                    rowLine.append((String)fiveLIt.next());
                }
                rowLine.append("<td style=\"color: white\">");
                if (sixLSize > i) {
                    rowLine.append((String)sixLIt.next());
                }
                rowLine.append("<td style=\"color: white\">");
                if (sevenLSize > i) {
                    rowLine.append((String)sevenLIt.next());
                }
                rowLine.append("<td style=\"color: white\">");
                if (eightLSize > i) {
                    rowLine.append((String)eightLIt.next());
                }
                rowLine.append("</td>");
                fw.write(rowLine.toString());
                fw.write("\n");
            }
            fw.write(htmlComplete);
            fw.write("\n");
            fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
        }
    }
    
    private String getFileName(String word) {
        StringBuilder fName = new StringBuilder();
        String root = "HTML/";
        File rootDirectory = new File(root);
        if (!rootDirectory.exists()) {
            rootDirectory.mkdir();
        }
        //base
        fName.append("HTML/build_");
        //buildID
        fName.append(buildID);
        //slash
        fName.append("/");
        File baseDirectory = new File(fName.toString());
        if (!baseDirectory.exists()) {
            baseDirectory.mkdir();
        }
        //word
        fName.append(word);
        //file type
        fName.append(".html");
        
        return fName.toString();
    }
}
