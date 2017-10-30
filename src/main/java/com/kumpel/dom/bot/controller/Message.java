package com.kumpel.dom.bot.controller;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

public class Message {

    public static SendMessage message(Update update) {
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /start");
            message.setReplyMarkup(new Start().ligar());
            return message;
        } else if (update.getMessage().getText().equals("/sync")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /sync");
            // message.setText(new ConnectionServer().getJson().get("node").toString());
            // new parser.JsonParser();
            // message.setText(parser.JsonParserKt.sum(2,3) + "");
            return message;

        } else if (update.getMessage().getText().equals("")) {
            return null;
        } else {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("No hablo chino!");
            message.setReplyMarkup(new Start().ligar());
            return message;
        }
    }

}
