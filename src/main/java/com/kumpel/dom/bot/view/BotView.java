package com.kumpel.dom.bot.view;

import com.kumpel.dom.bot.controller.CallBack;
import com.kumpel.dom.bot.controller.Message;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class BotView extends TelegramLongPollingBot implements Token {

    @SuppressWarnings("deprecation")
    public void onUpdateReceived(Update update) {

        boolean messageTest = update.hasMessage() && update.getMessage().hasText();

        if (messageTest) {
            SendMessage message = Message.message(update);
            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            EditMessageText newMessage = CallBack.callBack(update);
            try {
                editMessageText(newMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "homeBot";
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
