package net.ipsoft.training.chatroom.dao.impl;

import net.ipsoft.training.chatroom.dao.MessageDao;
import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjairaj on 13/7/16.
 */
@Repository
@Qualifier("inmemory")
public class InMemoryDBMessageDao implements MessageDao {

    List<Message> messages = new ArrayList<Message>();

    @Override
    public MessagesInfo getMessagesAfterIndex(int index) {
        MessagesInfo messagesInfo = new MessagesInfo();
        List<Message> output = new ArrayList<Message>();
        if (index >= messages.size()) {
            messagesInfo.setMessages(output);
            messagesInfo.setCurrentMessageIndex(messages.size());
            return messagesInfo;
        } else {
            for( int i = index; i < messages.size(); i++) {
                output.add(messages.get(i));
            }
        }
        messagesInfo.setMessages(output);
        messagesInfo.setCurrentMessageIndex(messages.size());
        return messagesInfo;
    }

    @Override
    public void storeMessage(Message message) {
        synchronized (messages) {
            messages.add(message);
        }
    }


}
