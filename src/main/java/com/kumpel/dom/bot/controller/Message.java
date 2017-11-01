package com.kumpel.dom.bot.controller;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
//import parser.JsonParser;

public class Message {

    public static SendMessage message(Update update) {
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /start");
            message.setReplyMarkup(new InlineMarkUp().ligar());
            return message;
        } else if (update.getMessage().getText().equals("/sync")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /sync");
            return message;
        } else if (update.getMessage().getText().equals("/node")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /node");
            // criar um objeto e definor outro objeto para guardar o sub json gerado
            message.setReplyMarkup(new InlineMarkUp().InlineNodes());
            //message.setText(node.get("area").toString());
            //JsonParser jsonParser = new JsonParser();
            //jsonParser.jsonParser();
            // String json = new parser.JsonParser().jsonParser((node));
            // System.out.println(json);
            // System.out.println(new parser.JsonParser().parserNode(node));
            // message.setText(json);
            return message;
        } else if (update.getMessage().getText().equals("/area")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /area");
            message.setReplyMarkup(new InlineMarkUp().InlineAreas(-1));
            return message;
        } else if (update.getMessage().getText().equals("")) {
            return null;
        } else {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("No hablo chino!");
            message.setReplyMarkup(new InlineMarkUp().ligar());
            return message;
        }
    }

}
