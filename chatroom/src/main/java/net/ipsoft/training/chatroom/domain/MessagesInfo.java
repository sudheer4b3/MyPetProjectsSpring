package net.ipsoft.training.chatroom.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sjairaj on 13/7/16.
 */
public class MessagesInfo implements Serializable {

    List<Message> messages;

    public int getCurrentMessageIndex() {
        return currentMessageIndex;
    }

    public void setCurrentMessageIndex(int currentMessageIndex) {
        this.currentMessageIndex = currentMessageIndex;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    int currentMessageIndex;
}
