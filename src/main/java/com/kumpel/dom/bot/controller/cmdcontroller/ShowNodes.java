package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.model.bd.dao.NodeDAO;
import com.kumpel.dom.bot.model.pojo.Node;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowNodes {

    public InlineKeyboardMarkup nodes() {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<Node> nodes = new NodeDAO().read();
        Iterator<Node> nodeIterator = nodes.iterator();
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            row1.add(new InlineKeyboardButton().setText(node.getName()).setCallbackData("node" + node.getId()));
            rowsInline.add(row1);
            row1 = new ArrayList<>();
        }
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }
}
