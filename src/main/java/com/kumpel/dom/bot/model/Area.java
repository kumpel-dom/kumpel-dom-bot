package com.kumpel.dom.bot.model;

public class Area {

    private int areaid;
    private String arename;
    private int nodeid;

    public int getAreaid() {
        return areaid;
    }

    public void setId(int areaid) {
        this.areaid = areaid;
    }

    public String getArename() {
        return arename;
    }

    public void setName(String arename) {
        this.arename = arename;
    }

    public int getForeignid() {
        return nodeid;
    }

    public void setForeignid(int nodeid) {
        this.nodeid = nodeid;
    }


}
