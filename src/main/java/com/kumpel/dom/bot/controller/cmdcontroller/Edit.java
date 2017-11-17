package com.kumpel.dom.bot.controller.cmdcontroller;

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

    }

    @Override
    public void updateAreas(){}

    @Override
    public void updateActions(){}
}
