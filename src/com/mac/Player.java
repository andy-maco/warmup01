package com.mac;

import com.mac.Model.Message;

/**
 * Реализовать класс Player, который умеет отправлять и получать сообщения
 * Player1 должен отправить сообщение Player2 с текстом “test”
 * Player2 дополняет полученное сообщение счетчиком полученных сообщение и отправляет обратно, Player1 отвечает аналогично
 */
public class Player {

    private Message message;

    public void sendMessage(String msgText) {

        if(this.message != null) {
            Message currentMessage = getMessage();
            currentMessage.incrementCount();
        } else {
            Message msg = new Message(msgText, 0);
            EventChannel eventChannel = EventChannel.getInstance();
            eventChannel.updatePlayers(msg);

            System.out.println("First message sended");
        }
    }

    // Update message and sent back
    public void sendMessage(Message msg) {
        msg.incrementCount();
        EventChannel eventChannel = EventChannel.getInstance();
        eventChannel.updatePlayers(msg);

        System.out.println("Message sended");
    }

    // Receive message and sent back
    public void receiveMessage(Message msg) {
        msg.incrementCount();
        this.sendMessage(msg);

        System.out.println("Message received");
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
