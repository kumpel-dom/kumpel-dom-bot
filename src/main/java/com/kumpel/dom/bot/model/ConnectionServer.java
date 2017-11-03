package com.kumpel.dom.bot.model;

import com.kumpel.dom.bot.model.ReceiveJson;
import org.json.JSONObject;

// Não está funcionando, pode ser a internet daqui

// import java.net.HttpURLConnection;
//import java.net.URL;

public class ConnectionServer {

    // private String stem = "http://172.16.8.68/";
    // private String stem = "http://192.168.1.76/";
    private String stem = "http://www.json-generator.com/api/json/get/bUbkoVhZVe?indent=2";
    private JSONObject json;

    public ConnectionServer() {
        try {
           this.json = ReceiveJson.readJsonFromUrl(stem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConnection(String path) {
        try {

            System.out.println(path);
        /*
            URL url = new URL(stem + path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setReadTimeout(15 * 1000);
            connection.connect();
            connection.getResponseCode();
        */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJson() {
        return json;
    }
}
