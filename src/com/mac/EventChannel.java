package com.mac;

import com.mac.Model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Player objects communication
 */
public class EventChannel {

    // Singleton
    private EventChannel() { }

    private static class SingletonHolder {
        private static final EventChannel INSTANCE = new EventChannel();
    }

    public static EventChannel getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private ArrayList<Player> playersList;

    public void registerPlayer(Player plr) {
        if (playersList != null) {
            this.playersList.add(plr);
        } else {
            playersList = new ArrayList<Player>();
        }
    }

    public void unregisterPlayer() {
        // TODO
//        this.playersList.
    }

    // Send messages to all players - TODO beside sender !
    public void updatePlayers (Message msg) {

        System.out.println("EventChannel - updatePlayers");

        if(this.playersList == null) {
            return;
        } else {
            for (Player plr : this.playersList) {
                plr.receiveMessage(msg);

            }
        }
    }

}
