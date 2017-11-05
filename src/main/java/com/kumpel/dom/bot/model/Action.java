package com.kumpel.dom.bot.model;

public class Action {

    private int actionid;
    private String actionname;
    private int areaid;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
