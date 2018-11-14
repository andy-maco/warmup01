package com.mac;

import com.mac.Model.Message;

/**
 * Реализовать класс Player, который умеет отправлять и получать сообщения
 * Player1 должен отправить сообщение Player2 с текстом “test”
 * Player2 дополняет полученное сообщение счетчиком полученных сообщение и отправляет обратно, Player1 отвечает аналогично
 */
public class Player {

    private Message message;

    public int getPlayerNumber() {
        return playerNumber;
    }

    private int playerNumber;

    public Player(int pNum) {
        this.playerNumber = pNum;
    }

    public void sendMessage(String msgText, int playerNumber) {

        if(this.message != null) {
            Message currentMessage = getMessage();
            currentMessage.incrementCount();
        } else {
            Message msg = new Message(msgText, 0);
            EventChannel eventChannel = EventChannel.getInstance();
            eventChannel.updatePlayers(msg, playerNumber);

            System.out.println("First message sent");
        }
    }

    // Update message and sent back
    public void sendMessage(Message msg, int playerNumber) {
        msg.incrementCount();
        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg, playerNumber);

        System.out.println("Message sent");
    }

    // Receive message and sent back
    public void receiveMessage(Message msg) {
        System.out.println("Message received");

        msg.incrementCount();
        this.sendMessage(msg, playerNumber);
        System.out.println("Message sent back");

    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
