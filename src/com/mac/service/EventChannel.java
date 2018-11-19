package com.mac.service;

import com.mac.model.Message;
import com.mac.Player;

import java.util.ArrayList;

/**
 * Player objects communication
 */
public class EventChannel {

    private static final int STOP_AT_LIMIT = 10;
    private int stepCount;

    // Singleton
    private EventChannel() { }

    private static class SingletonHolder {
        private static final EventChannel INSTANCE = new EventChannel();
    }

    public static EventChannel getInstance() {
        return SingletonHolder.INSTANCE;
    }


    private ArrayList<Player> subscribersList;

    /**
     * Register subscribers to channel
     *
     * @param plr
     */
    public void registerPlayer(Player plr) {
        if (subscribersList != null) {
            System.out.println("EventChannel - adding player " + plr.getPlayerNumber());
            this.subscribersList.add(plr);
        } else {
            subscribersList = new ArrayList<Player>();
            this.subscribersList.add(plr);
            System.out.println("EventChannel - adding player " + plr.getPlayerNumber());
        }
    }

    public void unregisterPlayer(Player plr) {
        if (subscribersList != null) {
            this.subscribersList.remove(plr);
        }
    }

    /**
     * Send messages to all players (except sender)
     *
     * @param msg
     * @param senderPlayerNum
     */
    public void updatePlayers (Message msg, int senderPlayerNum) {
//        System.out.println("\t EventChannel - updatePlayers (step: " + stepCount + "):");
//        System.out.println("\t EventChannel subscribed players: " + this.subscribersList.size());

        if (stepCount >= STOP_AT_LIMIT) {
            System.out.println("\nEventChannel queue stopped at: " + stepCount + ", constant limit: " + STOP_AT_LIMIT);
            return;
        } else {
            stepCount++;
        }

        if(this.subscribersList != null) {
            for (Player plr : this.subscribersList) {

//                System.out.println("\t EventChannel - current player " + plr.getPlayerNumber());

                if (plr.getPlayerNumber() != senderPlayerNum) {
//                    System.out.println("\t EventChannel - message " + msg.getMessageCount() + " -> sent to Player" + plr.getPlayerNumber());
                    plr.receiveMessage(msg);

                } else {
                    // Do not send to sender player
                }
            }
        } else {
            System.out.println("EventChannel - empty players list");
        }
    }

}
