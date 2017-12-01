package com.kumpel.dom.bot.controller.cmd;

import com.kumpel.dom.bot.model.bd.dao.AreaDAO;
import com.kumpel.dom.bot.model.pojo.Area;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowAreas {
    public InlineKeyboardMarkup areas() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<Area> areas = new AreaDAO().read();
        Iterator<Area> areaIterator = areas.iterator();
        while (areaIterator.hasNext()) {
            Area area = areaIterator.next();
            row1.add(new InlineKeyboardButton().setText(area.getName()).setCallbackData("area" + area.getId()));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}
