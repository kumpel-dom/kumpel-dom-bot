package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.controller.bdcontroller.dao.ActionDAO;
import com.kumpel.dom.bot.controller.bdcontroller.dao.AreaDAO;
import com.kumpel.dom.bot.controller.bdcontroller.dao.NodeDAO;
import com.kumpel.dom.bot.model.Action;
import com.kumpel.dom.bot.model.Area;
import com.kumpel.dom.bot.model.Node;

import java.util.Iterator;
import java.util.List;

public class Sync implements JsonGetInterface {

    public Sync() {
        updateNodes();
        updateAreas();
        updateActions();
    }

    private void updateNodes() {
        List<Node> list = new parser.NodeParser().nodeParser(json);

        Iterator<Node> ite = list.iterator();
        while (ite.hasNext()) {
            new NodeDAO().update(ite.next());
        }
    }

    private void updateAreas() {
        List<Area> list = new parser.AreaParser().areaParser(json);

        Iterator<Area> ite = list.iterator();
        while (ite.hasNext()) {
            new AreaDAO().update(ite.next());
        }
    }

    private void updateActions() {
        List<Action> list = new parser.ActionParser().actionParser(json);

        Iterator<Action> ite = list.iterator();
        while (ite.hasNext()) {
            new ActionDAO().update(ite.next());
        }
    }
}
