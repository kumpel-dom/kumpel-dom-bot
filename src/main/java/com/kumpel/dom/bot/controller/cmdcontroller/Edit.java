package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.controller.bdcontroller.dao.ActionDAO;
import com.kumpel.dom.bot.controller.bdcontroller.dao.AreaDAO;
import com.kumpel.dom.bot.controller.bdcontroller.dao.NodeDAO;
import com.kumpel.dom.bot.model.Action;
import com.kumpel.dom.bot.model.Area;
import com.kumpel.dom.bot.model.Node;

public class Edit implements UpdateInterface {

    private Node node;
    private Area area;
    private Action action;

    public Edit(Node node){
        this.node = node;
    }

    public Edit(Area area){
        this.area = area;
    }

    public Edit(Action action){
        this.action = action;
    }

    @Override
    public void updateNodes(){
        new NodeDAO().update(node);
    }

    @Override
    public void updateAreas(){
        new AreaDAO().update(area);
    }

    @Override
    public void updateActions(){
        new ActionDAO().update(action);
    }
}
