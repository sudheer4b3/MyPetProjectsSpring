package net.ipsoft.training.chatroom.service;

import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;

/**
 * Created by sjairaj on 13/7/16.
 */
public interface ChatService {

    MessagesInfo getAllMessagesAfter(int messageIndex);
    void saveMessage (Message message);

}
