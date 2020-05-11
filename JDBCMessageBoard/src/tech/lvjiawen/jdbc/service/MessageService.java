package tech.lvjiawen.jdbc.service;

import tech.lvjiawen.jdbc.bean.Message;
import tech.lvjiawen.jdbc.dao.MessageDAO;

import java.util.Date;
import java.util.List;

/**
 * 消息的 Service
 */
public class MessageService {

    private MessageDAO messageDAO;

    public MessageService() { messageDAO = new MessageDAO(); }

    public List<Message> getMessages(int page, int pageSize) {
        return messageDAO.getMessages(page, pageSize);
    }

    public int countMessages() {
        return messageDAO.countMessages();
    }
    // 减库存什么的，打着什么的在这里计算

    public boolean addMessage(Message message) {
        message.setCreateTime(new Date());
        return messageDAO.save(message);
    }
}
