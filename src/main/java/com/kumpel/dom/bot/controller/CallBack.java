package com.kumpel.dom.bot.controller;

import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CallBack {

    public static String getCallBack(String callData) {
        String answer = null;
        String pattern = "(\\w+)(\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(callData);
        if (m.find()) {
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            answer = m.group(2);
        }
        return answer;
    }

    public static EditMessageText callBack(Update update) {
        long message_id = update.getCallbackQuery().getMessage().getMessageId();
        long chat_id = update.getCallbackQuery().getMessage().getChatId();
        String answer = getCallBack(update.getCallbackQuery().getData());
        EditMessageText newMessage = new EditMessageText().setChatId(chat_id).setMessageId((int) (message_id))
                .setText(answer);
        return newMessage;
    }
}
