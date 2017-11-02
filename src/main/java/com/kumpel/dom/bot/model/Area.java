package com.kumpel.dom.bot.model;

public class Area {

    private int areaid;
    private String arename;

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getArename() {
        return arename;
    }

    public void setArename(String arename) {
        this.arename = arename;
    }

    public int getNodeid() {
        return nodeid;
    }

    public void setNodeid(int nodeid) {
        this.nodeid = nodeid;
    }

    private int nodeid;
}
