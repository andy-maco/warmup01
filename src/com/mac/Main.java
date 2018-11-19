package com.mac;

import com.mac.service.EventChannel;

public class Main {

    private static final String MSG_TEXT = "test";

    public static void main(String[] args) {

        // Create players
        Player player1 = new Player(1);
        Player player2 = new Player(2);

        // Create singleton instance of queue manager
        EventChannel eventChannel = EventChannel.getInstance();

        // Register players (subscribers)
        eventChannel.registerPlayer(player1);
        eventChannel.registerPlayer(player2);

        player1.sendMessage(MSG_TEXT);

    }
}
