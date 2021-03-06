package com.kumpel.dom.bot.controller.cmd;

import com.kumpel.dom.bot.model.bd.dao.ActionDAO;
import com.kumpel.dom.bot.model.pojo.Action;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowActions {
    public InlineKeyboardMarkup actions() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<Action> actions = new ActionDAO().read();
        Iterator<Action> actionIterator = actions.iterator();
        while (actionIterator.hasNext()) {
            Action action = actionIterator.next();
            row1.add(new InlineKeyboardButton().setText(action.getName()).setCallbackData("action" + action.getId()));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}
