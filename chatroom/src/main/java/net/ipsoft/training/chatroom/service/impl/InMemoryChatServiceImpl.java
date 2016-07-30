package net.ipsoft.training.chatroom.service.impl;

import net.ipsoft.training.chatroom.dao.MessageDao;
import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;
import net.ipsoft.training.chatroom.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sjairaj on 13/7/16.
 */

@Service
public class InMemoryChatServiceImpl implements ChatService {

    @Autowired @Qualifier("inmemory")
    MessageDao messageDao;

    @Override
    public MessagesInfo getAllMessagesAfter(int messageIndex) {
        return messageDao.getMessagesAfterIndex(messageIndex);
    }

    @Override
    public void saveMessage(Message message) {
        messageDao.storeMessage(message);
    }
}
