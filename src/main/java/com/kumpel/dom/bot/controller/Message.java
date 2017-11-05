package com.kumpel.dom.bot.controller;

import com.kumpel.dom.bot.controller.cmdcontroller.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import com.vdurmont.emoji.EmojiParser;

public class Message {

    public static SendMessage message(Update update) {
        SendMessage message;
        long chat_id = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            StringBuilder answer = new StringBuilder();
            answer.append("Inicializando Banco de dados: ✔️\n️");
            answer.append("Sincronizando: ✔️\n");
            answer.append("Idioma: \uD83C\uDDE7\uD83C\uDDF7\n");
            answer.append("Inicializando IA: ✔️\n️");
            answer.append("\n\nBot inicializado com sucesso \uD83D\uDE4C");
            message = new SendMessage().setChatId(chat_id).setText(answer.toString());
            new Start();
        } else if (update.getMessage().getText().equals("/sync")) {
            new Sync();
            String answer = EmojiParser.parseToUnicode("Sincronização: ✔️");
            message = new SendMessage().setChatId(chat_id).setText(answer);
        } else if (update.getMessage().getText().equals("/node")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /node");
            message.setReplyMarkup(new ShowNodes().nodes());
        } else if (update.getMessage().getText().equals("/area")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /area");
            message.setReplyMarkup(new ShowAreas().areas());
        } else if (update.getMessage().getText().equals("/action")) {
            message = new SendMessage().setChatId(chat_id).setText("You send /action");
            message.setReplyMarkup(new ShowActions().actions());
        } else if (update.getMessage().getText().equals("")) {
            return null;
        } else {
            message = new SendMessage().setChatId(chat_id).setText("No hablo chino!");
            // message.setReplyMarkup(new InlineMarkUp().ligar());
        }
        return message;
    }

}
