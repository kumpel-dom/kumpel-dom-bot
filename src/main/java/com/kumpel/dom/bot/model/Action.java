package com.kumpel.dom.bot.model;

public class Action {

    private int actionid;
    private String actionname;
    private int areaid;

    public int getActionid() {
        return actionid;
    }

    public void setId(int actionid) {
        this.actionid = actionid;
    }

    public String getActionname() {
        return actionname;
    }

    public void setName(String actionname) {
        this.actionname = actionname;
    }

    public int getForeignid() {
        return areaid;
    }

    public void setForeignid(int areaid) {
        this.areaid = areaid;
    }
}
