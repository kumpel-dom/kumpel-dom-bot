package com.kumpel.dom.bot.controller;

import com.kumpel.dom.bot.model.ConnectionServer;
import org.json.JSONObject;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import parser.JsonParser;

public class Message {

    public static SendMessage message(Update update) {
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /start");
            message.setReplyMarkup(new Start().ligar());
            return message;
        } else if (update.getMessage().getText().equals("/sync")) {
            SendMessage message = new SendMessage().setChatId(chat_id).setText("You send /sync");

            // criar um objeto e definor outro objeto para guardar o sub json gerado

           JSONObject node = new ConnectionServer().getJson();

            //message.setText(node.get("area").toString());
           //JsonParser jsonParser = new JsonParser();
           //jsonParser.jsonParser();
            String json = new parser.JsonParser().jsonParser((node));
            System.out.println(json);

           message.setText(json);

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
