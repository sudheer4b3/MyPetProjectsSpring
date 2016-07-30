package net.ipsoft.training.chatroom.web.controllers;

import net.ipsoft.training.chatroom.domain.Message;
import net.ipsoft.training.chatroom.domain.MessagesInfo;
import net.ipsoft.training.chatroom.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sjairaj on 4/7/16.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @RequestMapping("/echo")
    @ResponseBody
    public String echo(String sentence) {
        return sentence;
    }

    @RequestMapping("/postmessage")
    @ResponseBody
    public String postMessage(@RequestParam("userName") String userName,
                              @RequestParam("text") String text) {
        Message message = new Message();
        message.setText(text);
        message.setUserName(userName);
        chatService.saveMessage(message);
        return "true";
    }
    @RequestMapping("/getmessages")
    @ResponseBody
    public MessagesInfo getAllMessagesBefore(Integer index) {
        return chatService.getAllMessagesAfter(index);
    }

}
