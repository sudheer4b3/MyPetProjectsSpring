package net.ipsoft.training.chatroom.dao;

import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;

import java.util.List;

/**
 * Created by sjairaj on 13/7/16.
 */
public interface MessageDao {
    MessagesInfo getMessagesAfterIndex(int index);
    void storeMessage( Message message);
}
