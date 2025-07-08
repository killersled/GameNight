/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games;

import com.hfg.gamenight.games.fif.FIF_GameScreen;
import com.hfg.gamenight.games.fif.common.Categories;
import com.hfg.gamenight.games.fif.common.Letters;
import com.hfg.gamenight.games.fif.subs.Actors;
import com.hfg.gamenight.games.fif.subs.Colors;
import com.hfg.gamenight.games.fif.subs.Decades;
import com.hfg.gamenight.games.fif.subs.Events;
import com.hfg.gamenight.games.fif.subs.Leagues;
import com.hfg.gamenight.games.fif.subs.Meals;
import com.hfg.gamenight.games.fif.subs.Regions;
import com.hfg.gamenight.games.fif.subs.Series;
import com.hfg.gamenight.games.fif.subs.Sources;
import com.hfg.gamenight.games.fif.subs.States;
import com.hfg.gamenight.games.fif.subs.Subjects;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jkelley
 */
public class FactsInFive {
    //Random and counts
    private final Random myRando = new Random(System.currentTimeMillis());
    //JSON categories File name
    private final String filePath = "./data/FIF_datasets.json";
    //Categories
    private final Categories myCategories = new Categories();
    //Letters
    private final Letters myLetters = new Letters();
    //Narrowers
    private final Regions myRegions = new Regions();
    private final Meals myMeals = new Meals();
    private final Decades myDecades = new Decades();
    private final Actors myActors = new Actors();
    private final Colors myColors = new Colors();
    private final Sources mySources = new Sources();
    private final Events myEvents = new Events();
    private final Leagues myLeagues = new Leagues();
    private final Series mySeries = new Series();
    private final Subjects mySubjects = new Subjects();
    private final States myStates = new States();
    

    public void runMe() {
        myLetters.loadAlphabet();
        JSONArray categoriesData = readJSONFile();
        //categories are always index 0.
        myCategories.loadFromJSON(categoriesData.getJSONObject(0));

        for (int i = 1; i < categoriesData.length(); i++) {
            JSONObject subCat = categoriesData.getJSONObject(i);
            String subName = subCat.getString("name");
            System.out.println(i + ":  " + subName);
            if (subName.equals("regions")) {
                myRegions.loadFromJSON(subCat);
            } else if (subName.equals("meals")) {
                myMeals.loadFromJSON(subCat);
            } else if (subName.equals("decades")) {
                myDecades.loadFromJSON(subCat);
            } else if (subName.equals("actors")) {
                myActors.loadFromJSON(subCat);
            } else if (subName.equals("colors")) {
                myColors.loadFromJSON(subCat);
            } else if (subName.equals("sources")) {
                mySources.loadFromJSON(subCat);
            } else if (subName.equals("events")) {
                myEvents.loadFromJSON(subCat);
            } else if (subName.equals("leagues")) {
                myLeagues.loadFromJSON(subCat);
            } else if (subName.equals("series")) {
                mySeries.loadFromJSON(subCat);
            } else if (subName.equals("subjects")) {
                mySubjects.loadFromJSON(subCat);
            } else {
                myStates.loadFromJSON(subCat);
            }
        }

        randomizeRando();
        myLetters.setRando(myRando);
        String[] letters = myLetters.getFiveLetters();
        String[] cats = getTwentyfiveCategories();
        
        //HTML Output
        //htmlSheets(cats, letters);
        //GUI Output
        FIF_GameScreen myGS = new FIF_GameScreen(myLetters);
        myGS.display(cats, letters);

    }

    private void randomizeRando() {
        Integer xxx = myRando.nextInt();
        for (int y = 0; y < xxx; y++) {
            Integer zzz = myRando.nextInt();
        }
    }

    public String[] getFiveLetters() {
        String[] retArray = new String[5];
        int uniqueCnt = 0;
        while (uniqueCnt < 5) {
            Integer index = myRando.nextInt(myLetters.getNumLetters());
            if (uniqueCnt > 0) {
                //System.out.println("UC: " + uniqueCnt + ";  index:  " + index);
                boolean duplicate = false;
                for (int x = 0; x < uniqueCnt; x++) {

                    if (retArray[x].equals(myLetters.getLetter(index))) {
                        System.out.println("Comparing:  " + retArray[x] + "  to  " + myLetters.getLetter(index));
                        duplicate = true;
                    }
                }
                if (duplicate) {
                    System.out.println(index);
                    continue;
                }
            }
            retArray[uniqueCnt] = myLetters.getLetter(index);
            uniqueCnt++;
        }
        return retArray;
    }

    public String[] getTwentyfiveCategories() {
        String[] retArray = new String[25];
        int uniqueCnt = 0;

        while (uniqueCnt < 25) {
            Integer index = myRando.nextInt(myCategories.getNumCats());
            if (uniqueCnt > 0) {
                boolean duplicate = false;
                for (int x = 0; x < uniqueCnt; x++) {
                    if (retArray[x].equals(myCategories.getCategory(index))) {
                        duplicate = true;
                    }

                }
                if (duplicate) {
                    System.out.println(index);
                    continue;
                }
            }
            String catName = myCategories.getCategory(index);
            retArray[uniqueCnt] = catName;
            uniqueCnt++;
        }

        for (int x = 0; x < uniqueCnt; x++) {
            String catName = retArray[x];
            System.out.println(catName);
            boolean changed = false;
            if (catName.contains("__ACTOR__")) {
                String xxx = myActors.getActor(myRando.nextInt(myActors.getNumActors()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                catName.replace("__ACTOR__", xxx);
                changed = true;
            } else if (catName.contains("__REGION__")) {
                String xxx = myRegions.getRegion(myRando.nextInt(myRegions.getNumRegions()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                catName.replace("__REGION__", xxx);
                changed = true;
            } else if (catName.contains("__COLOR__")) {
                String xxx = myColors.getColor(myRando.nextInt(myColors.getNumColors()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__DECADE__")) {
                String xxx = myDecades.getDecade(myRando.nextInt(myDecades.getNumDecades()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__MEALTIME__")) {
                String xxx = myMeals.getMeal(myRando.nextInt(myMeals.getNumMeals()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__SOURCE__")) {
                String xxx = mySources.getSource(myRando.nextInt(mySources.getNumSources()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__EVENT__")) {
            	String xxx = myEvents.getEvent(myRando.nextInt(myEvents.getNumEvents()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__LEAGUE__")) {
            	String xxx = myLeagues.getLeague(myRando.nextInt(myLeagues.getNumLeagues()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__SERIES__")) {
            	String xxx = mySeries.getSeries(myRando.nextInt(mySeries.getNumSeries()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__STATE__")) {
            	String xxx = myStates.getState(myRando.nextInt(myStates.getNumStates()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            } else if (catName.contains("__SUBJECT__")) {
            	String xxx = mySubjects.getSubject(myRando.nextInt(mySubjects.getNumSubjects()));
                String[] zzz = catName.split("__");
                catName = zzz[0] + " " + xxx;
                changed = true;
            }
            if (changed)
                retArray[x] = catName;

        }
        return retArray;

    }
    
    private JSONArray readJSONFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(content);

            // Access data using keys
            JSONArray datasets = jsonObject.getJSONArray("categories");
            return datasets;
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return null;
    }
}
