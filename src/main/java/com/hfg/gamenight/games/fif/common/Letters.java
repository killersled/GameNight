/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games.fif.common;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author jkelley
 */
public class Letters {
    private HashMap<Integer, String> Alphabet = new HashMap<>();
    private Integer numLetters = 98;
    private Random rando;

    public Random getRando() {
        return rando;
    }

    public void setRando(Random rando) {
        this.rando = rando;
    }

    public void loadAlphabet() {
        //Scrabble distribution
        Alphabet.put(0, "A");
        Alphabet.put(1, "B");
        Alphabet.put(2, "C");
        Alphabet.put(3, "D");
        Alphabet.put(4, "E");
        Alphabet.put(5, "F");
        Alphabet.put(6, "G");
        Alphabet.put(7, "H");
        Alphabet.put(8, "I");
        Alphabet.put(9, "J");
        Alphabet.put(10, "K");
        Alphabet.put(11, "L");
        Alphabet.put(12, "M");
        Alphabet.put(13, "N");
        Alphabet.put(14, "O");
        Alphabet.put(15, "P");
        Alphabet.put(16, "Q");
        Alphabet.put(17, "R");
        Alphabet.put(18, "S");
        Alphabet.put(19, "T");
        Alphabet.put(20, "U");
        Alphabet.put(21, "V");
        Alphabet.put(22, "W");
        Alphabet.put(23, "X");
        Alphabet.put(24, "Y");
        Alphabet.put(25, "Z");
        // Add elements to equal scrabble distribution
        Alphabet.put(26, "A");
        Alphabet.put(27, "A");
        Alphabet.put(28, "A");
        Alphabet.put(29, "A");
        Alphabet.put(30, "A");
        Alphabet.put(31, "A");
        Alphabet.put(32, "A");
        Alphabet.put(33, "A");
        Alphabet.put(34, "B");
        Alphabet.put(35, "C");
        Alphabet.put(36, "D");
        Alphabet.put(37, "D");
        Alphabet.put(38, "D");
        Alphabet.put(39, "E");
        Alphabet.put(40, "E");
        Alphabet.put(41, "E");
        Alphabet.put(42, "E");
        Alphabet.put(43, "E");
        Alphabet.put(44, "E");
        Alphabet.put(45, "E");
        Alphabet.put(46, "E");
        Alphabet.put(47, "E");
        Alphabet.put(48, "E");
        Alphabet.put(49, "E");
        Alphabet.put(50, "F");
        Alphabet.put(51, "G");
        Alphabet.put(52, "G");
        Alphabet.put(53, "H");
        Alphabet.put(54, "I");
        Alphabet.put(55, "I");
        Alphabet.put(56, "I");
        Alphabet.put(57, "I");
        Alphabet.put(58, "I");
        Alphabet.put(59, "I");
        Alphabet.put(60, "I");
        Alphabet.put(61, "I");
        Alphabet.put(62, "L");
        Alphabet.put(63, "L");
        Alphabet.put(64, "L");
        Alphabet.put(65, "M");
        Alphabet.put(66, "N");
        Alphabet.put(67, "N");
        Alphabet.put(68, "N");
        Alphabet.put(69, "N");
        Alphabet.put(70, "N");
        Alphabet.put(71, "O");
        Alphabet.put(72, "O");
        Alphabet.put(73, "O");
        Alphabet.put(74, "O");
        Alphabet.put(75, "O");
        Alphabet.put(76, "O");
        Alphabet.put(77, "O");
        Alphabet.put(78, "P");
        Alphabet.put(79, "R");
        Alphabet.put(80, "R");
        Alphabet.put(81, "R");
        Alphabet.put(82, "R");
        Alphabet.put(83, "R");
        Alphabet.put(84, "S");
        Alphabet.put(85, "S");
        Alphabet.put(86, "S");
        Alphabet.put(87, "T");
        Alphabet.put(88, "T");
        Alphabet.put(89, "T");
        Alphabet.put(90, "T");
        Alphabet.put(91, "T");
        Alphabet.put(92, "U");
        Alphabet.put(93, "U");
        Alphabet.put(94, "U");
        Alphabet.put(95, "V");
        Alphabet.put(96, "W");
        Alphabet.put(97, "Y");
    }

    public Integer getNumLetters() {
        return numLetters;
    }

    public String getLetter(Integer index) {
        return Alphabet.get(index);
    }
    
    public String[] getFiveLetters() {
        String[] retArray = new String[5];
        int uniqueCnt = 0;
        while (uniqueCnt < 5) {
            Integer index = rando.nextInt(getNumLetters());
            if (uniqueCnt > 0) {
                //System.out.println("UC: " + uniqueCnt + ";  index:  " + index);
                boolean duplicate = false;
                for (int x = 0; x < uniqueCnt; x++) {

                    if (retArray[x].equals(getLetter(index))) {
                        System.out.println("Comparing:  " + retArray[x] + "  to  " + getLetter(index));
                        duplicate = true;
                    }
                }
                if (duplicate) {
                    System.out.println(index);
                    continue;
                }
            }
            retArray[uniqueCnt] = getLetter(index);
            uniqueCnt++;
        }
        return retArray;
    }
}
