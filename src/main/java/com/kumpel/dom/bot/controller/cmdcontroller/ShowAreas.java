package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.controller.bdcontroller.dao.AreaDAO;
import com.kumpel.dom.bot.controller.bdcontroller.dao.NodeDAO;
import com.kumpel.dom.bot.model.Area;
import com.kumpel.dom.bot.model.Node;
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
            row1.add(new InlineKeyboardButton().setText(area.getArename()).setCallbackData("area" + area.getAreaid()));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}
