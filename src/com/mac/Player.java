package com.mac;

import com.mac.model.Message;
import com.mac.service.EventChannel;

/**
 * Реализовать класс Player, который умеет отправлять и получать сообщения
 * Player1 должен отправить сообщение Player2 с текстом “test”
 * Player2 дополняет полученное сообщение счетчиком полученных сообщение и отправляет обратно, Player1 отвечает аналогично
 */
public class Player {

    public int getPlayerNumber() {
        return playerNumber;
    }

    private int playerNumber;

    public Player(int pNum) {
        this.playerNumber = pNum;
    }

    /**
     * Sent first message
     *
     * @param msgText
     */
    public void sendMessage(String msgText) {
        System.out.println("\nMessage: 0 -> sent by Player " + this.playerNumber);

        Message msg = new Message(msgText, 0);
        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg, this.playerNumber);
    }

    /**
     * Sent message
     *
     * @param msg
     */
    public void sendMessage(Message msg) {
        System.out.println("Message: " + msg.getMessageCount() + " -> sent by Player " + this.playerNumber);

        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg, this.playerNumber);

    }

    /**
     * Receive message, update and sent back
     *
     * @param msg
     */
    public void receiveMessage(Message msg) {
        System.out.println("\t Player " + this.getPlayerNumber() + " <- received message: " + msg.getMessageCount());

        // Update message counter
        msg.incrementCount();
        this.sendMessage(msg);
    }
}
