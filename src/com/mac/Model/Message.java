package com.mac.Model;

public class Message {

    private String messageText;
    private int messageCount;

    public Message (String msgText, int msgCount) {
        this.messageText = msgText;
        this.messageCount = msgCount;
    }

    public void incrementCount() {
        this.messageCount++;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }
}
