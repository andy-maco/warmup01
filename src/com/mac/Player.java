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
     * Send first message
     *
     * @param msgText
     */
    public void sendMessage(String msgText) {

        System.out.println("First message sent start. By player " + this.playerNumber);

        Message msg = new Message(msgText, 0);
        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg, this.playerNumber);

        System.out.println("First message sent finish. By player " + this.playerNumber);
    }

    /**
     * Sent message
     *
     * @param msg
     */
    public void sendMessage(Message msg) {

        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg, this.playerNumber);

        System.out.println("Message sent. Num: " + msg.getMessageCount() + " by Player " + this.playerNumber);
    }

    /**
     * Receive message, update and sent back
     *
     * @param msg
     */
    public void receiveMessage(Message msg) {
        System.out.println("Player " + this.getPlayerNumber() + " received message #: " + msg.getMessageCount());

        // Update message counter
        msg.incrementCount();
        this.sendMessage(msg);
    }
}
