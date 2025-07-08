/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hfg.gamenight.games;

import com.hfg.gamenight.games.connections.CONN_DataMap;
import com.hfg.gamenight.games.connections.CONN_GameScreen;

/**
 *
 * @author jkelley
 */
public class Connections {
    public void runMe() {
        CONN_GameScreen myGS = new CONN_GameScreen();
        
        CONN_DataMap myDM = new CONN_DataMap();
        myDM.readJSONDatasets();
        //0 is General; 1 is Kelley's
        Integer gameSet = 0;
        //Integer gameSet = 1;
        myGS.setPlayingDataset(gameSet);
        myDM.createMapJSON(gameSet);
        
        myGS.shareDM(myDM);
        myGS.Display(0, null);
    }
}
