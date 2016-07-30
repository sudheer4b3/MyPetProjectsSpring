package net.ipsoft.training.chatroom.dao.impl;

import net.ipsoft.training.chatroom.dao.MessageDao;
import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sjairaj on 13/7/16.
 */
@Repository
@Qualifier("cassandra")
public class CassandraMessageDao implements MessageDao {
    @Override
    public MessagesInfo getMessagesAfterIndex(int index) {
        return null;
    }

    @Override
    public void storeMessage(Message message) {

    }
}
