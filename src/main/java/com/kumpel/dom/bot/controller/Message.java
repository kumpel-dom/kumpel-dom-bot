package com.kumpel.dom.bot.controller;

import com.kumpel.dom.bot.controller.cmdcontroller.ShowNodes;
import com.kumpel.dom.bot.controller.cmdcontroller.Start;
import com.kumpel.dom.bot.controller.cmdcontroller.Sync;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
//import parser.JsonParser;

public class Message {

    public static SendMessage message(Update update) {
        SendMessage message;
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /start");
            new Start();
            return message;
        } else if (update.getMessage().getText().equals("/sync")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /sync");
            new Sync();
            return message;
        } else if (update.getMessage().getText().equals("/node")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /node");
            message.setReplyMarkup(new ShowNodes().nodes());
            return message;
        } else if (update.getMessage().getText().equals("")) {
            return null;
        } else {
            message = new SendMessage().setChatId(chat_id).setText("No hablo chino!");
            // message.setReplyMarkup(new InlineMarkUp().ligar());
            return message;
        }
    }

}
