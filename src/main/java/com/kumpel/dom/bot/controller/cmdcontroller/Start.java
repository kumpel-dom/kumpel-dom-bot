package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.controller.bdcontroller.dao.*;
import com.kumpel.dom.bot.model.Action;
import com.kumpel.dom.bot.model.Area;
import com.kumpel.dom.bot.model.ConnectionServer;
import com.kumpel.dom.bot.model.Node;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

public class Start {

    private JSONObject json = new ConnectionServer().getJson();

    public Start() {
        createNodes();
        createAreas();
        createActions();
    }

    private void createNodes() {
        List<Node> list = new parser.NodeParser().nodeParser(json);

        Iterator<Node> ite = list.iterator();
        while (ite.hasNext()) {
            new NodeDAO().create(ite.next());
        }
    }

    private void createAreas() {
        List<Area> list = new parser.AreaParser().areaParser(json);

        Iterator<Area> ite = list.iterator();
        while (ite.hasNext()) {
            new AreaDAO().create(ite.next());
        }
    }

    private void createActions() {
        List<Action> list = new parser.ActionParser().actionParser(json);

        Iterator<Action> ite = list.iterator();
        while (ite.hasNext()) {
            new ActionDAO().create(ite.next());
        }
    }
}
