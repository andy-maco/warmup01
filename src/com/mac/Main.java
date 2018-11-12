package com.mac;

public class Main {

    private static final String MSG_TEXT = "test";

    public static void main(String[] args) {


        // TODO build players with fabric to write their num into class instance

        Player player1 = new Player();
        Player player2 = new Player();

        // Register players
        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.registerPlayer(player1);
        eventChannel.registerPlayer(player2);

        player1.sendMessage(MSG_TEXT);


    }
}
