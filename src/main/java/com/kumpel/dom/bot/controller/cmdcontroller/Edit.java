package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.model.bd.dao.ActionDAO;
import com.kumpel.dom.bot.model.bd.dao.AreaDAO;
import com.kumpel.dom.bot.model.bd.dao.NodeDAO;
import com.kumpel.dom.bot.model.pojo.Action;
import com.kumpel.dom.bot.model.pojo.Area;
import com.kumpel.dom.bot.model.pojo.Node;

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
