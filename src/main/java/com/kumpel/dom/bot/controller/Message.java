package com.kumpel.dom.bot.controller;

import com.kumpel.dom.bot.controller.cmd.*;
import com.kumpel.dom.bot.model.bd.dao.NodeDAO;
import com.kumpel.dom.bot.model.pojo.Node;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import com.vdurmont.emoji.EmojiParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Message {

    private static SendMessage message;

    public static SendMessage message(Update update) {
        long chatId = update.getMessage().getChatId();
        message = new SendMessage().setChatId(chatId).setText("não entendi, o que é isso?");
        if (update.getMessage().getText().equals("/start")) {
            new Start();
            message = Start.start(chatId);
        } else if (update.getMessage().getText().equals("/sync")) {
            message = Sync.sync(chatId);
        } else if (update.getMessage().getText().equals("/node")) {
            message.setReplyMarkup(new ShowNodes().nodes());
        } else if (update.getMessage().getText().equals("/area")) {
            message.setReplyMarkup(new ShowAreas().areas());
        } else if (update.getMessage().getText().equals("/action")) {
            message.setReplyMarkup(new ShowActions().actions());
        } else if (update.getMessage().getText().startsWith("renomear")) {
            message = new SendMessage().setChatId(chatId).setText(update.getMessage().getText().toString());
            rename(chatId, message.getText());
        } else if (update.getMessage().getText().equals("")) {
            return null;
        } else {
            message = new SendMessage().setChatId(chatId).setText("não entendi, o que é isso?");
            // message.setReplyMarkup(new InlineMarkUp().ligar());
        }
        return message;
    }

    public static void rename(long chatId, String callData) {
        String pattern = "(renomear)(\\s)(\\w+)(\\s)([\\w|\\d|\\s]+)(para)(\\s)([\\w|\\d|\\s]+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(callData);
        if (m.find()) {
            if (m.group(3).startsWith("node")) {
                NodeDAO nodeDao = new NodeDAO();
                Node node = new Node();
                node.setName(m.group(5).trim());
                node.setId(0);
                nodeDao.update(node);
            }

          //  System.out.println(m.group(0));
           // System.out.println(m.group(1));
            //System.out.println(m.group(2));
            System.out.println(m.group(3));
            //System.out.println(m.group(4));
            System.out.println(m.group(5));
            //System.out.println(m.group(6));
            //System.out.println(m.group(7));
            //System.out.println(m.group(8));

        }
    }
}
