package com.mac;

import com.mac.Model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Player objects communication
 */
public class EventChannel {

    private static final int STOP_AT = 10;
    private int queueCount;

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
    public void updatePlayers (Message msg, int playerNum) {

        System.out.println("EventChannel - updatePlayers");

        if (queueCount > STOP_AT) {
            System.out.println("EventChannel queue: " + queueCount);
            return;
        } else {
            System.out.println("EventChannel queue: " + queueCount);
            queueCount++;
        }

        if(this.playersList != null) {
            for (Player plr : this.playersList) {
                if (plr.getPlayerNumber() != playerNum) {
                    plr.receiveMessage(msg);

                    System.out.println("EventChannel - message sent to Player" + plr.getPlayerNumber());
                } else {
                    // Do not send to sender player
                }
            }
        } else {
            System.out.println("EventChannel - empty players list");
        }
    }

}
