package net.ipsoft.training.chatroom.domain;

/**
 * Created by sjairaj on 13/7/16.
 */
public class Message {
    private String userName;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
