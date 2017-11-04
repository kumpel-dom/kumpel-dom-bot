package com.kumpel.dom.bot.controller.cmdcontroller;

import com.kumpel.dom.bot.model.ConnectionServer;
import org.json.JSONObject;

public interface JsonGetInterface {
    JSONObject json = new ConnectionServer().getJson();
}
