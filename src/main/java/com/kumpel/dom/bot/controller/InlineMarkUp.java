package com.kumpel.dom.bot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kumpel.dom.bot.model.ConnectionServer;
import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class InlineMarkUp {


    InlineKeyboardMarkup InlineNodes() {
        JSONObject node = new ConnectionServer().getJson();
        Map<Integer, String> map = new parser.JsonParser().parserNode(node);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<List<InlineKeyboardButton>>();
        List<InlineKeyboardButton> row1 = new ArrayList<InlineKeyboardButton>();

        for (int x : map.keySet()) {
            row1.add(new InlineKeyboardButton().setText(map.get(x)).setCallbackData("" + x));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    InlineKeyboardMarkup InlineAreas(int node) {
        JSONObject json = new ConnectionServer().getJson();
        Map<String, String> map = new parser.JsonParser().parserArea(json, node);

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<List<InlineKeyboardButton>>();
        List<InlineKeyboardButton> row1 = new ArrayList<InlineKeyboardButton>();

        for (String x : map.keySet()) {
            row1.add(new InlineKeyboardButton().setText(map.get(x)).setCallbackData(x));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    InlineKeyboardMarkup ligar() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<List<InlineKeyboardButton>>();
        List<InlineKeyboardButton> row1 = new ArrayList<InlineKeyboardButton>();
        for (int i = 0; i < 9; i++) {
            if (!State.d[i]) {
                row1.add(new InlineKeyboardButton().setText("liga led " + (i + 1)).setCallbackData(i + "on"));
            } else {
                row1.add(new InlineKeyboardButton().setText("desliga led " + (i + 1)).setCallbackData(i + "off"));
            }
            if (i % 2 == 0 || i == 0) {
                rowsInline.add(row1);
                row1 = new ArrayList<InlineKeyboardButton>();
            }
        }
        rowsInline.add(acionaTodos());
        rowsInline.add(desacionaTodos());
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    List<InlineKeyboardButton> acionaTodos() {

        List<InlineKeyboardButton> row1 = new ArrayList<InlineKeyboardButton>();
        row1.add(new InlineKeyboardButton().setText("liga todos").setCallbackData("todos"));

        return row1;
    }

    List<InlineKeyboardButton> desacionaTodos() {

        List<InlineKeyboardButton> row1 = new ArrayList<InlineKeyboardButton>();
        row1.add(new InlineKeyboardButton().setText("desliga todos").setCallbackData("desligaTodos"));

        return row1;
    }
}
