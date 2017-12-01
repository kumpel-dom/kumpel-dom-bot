package com.kumpel.dom.bot.controller.cmd;

import com.kumpel.dom.bot.model.bd.dao.ActionDAO;
import com.kumpel.dom.bot.model.bd.dao.AreaDAO;
import com.kumpel.dom.bot.model.bd.dao.NodeDAO;
import com.kumpel.dom.bot.model.pojo.Action;
import com.kumpel.dom.bot.model.pojo.Area;
import com.kumpel.dom.bot.model.pojo.Node;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.util.Iterator;
import java.util.List;

public class Sync implements UpdateInterface {

    public static Exception exc = null;

    public Sync() {
        updateNodes();
        updateAreas();
        updateActions();
    }

    @Override
    public void updateNodes() {
        List<Node> list = new parser.NodeParser().nodeParser(json);

        Iterator<Node> ite = list.iterator();
        while (ite.hasNext()) {
            new NodeDAO().update(ite.next());
        }
    }

    @Override
    public void updateAreas() {
        List<Area> list = new parser.AreaParser().areaParser(json);

        Iterator<Area> ite = list.iterator();
        while (ite.hasNext()) {
            new AreaDAO().update(ite.next());
        }
    }

    @Override
    public void updateActions() {
        List<Action> list = new parser.ActionParser().actionParser(json);

        Iterator<Action> ite = list.iterator();
        while (ite.hasNext()) {
            new ActionDAO().update(ite.next());
        }
    }

    public static SendMessage sync(long chatId) {
        new Sync();
        String answer = EmojiParser.parseToUnicode("Sincronização: ✔️");
        return new SendMessage().setChatId(chatId).setText(answer);
    }
}
