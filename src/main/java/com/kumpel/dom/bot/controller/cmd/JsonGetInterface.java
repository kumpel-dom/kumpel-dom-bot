package com.kumpel.dom.bot.controller.cmd;

import com.kumpel.dom.bot.controller.ConnectionServer;
import org.json.JSONObject;

public interface JsonGetInterface {
    JSONObject json = new ConnectionServer().getJson();
}
