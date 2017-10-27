
package com.kumpel.dom.bot.model;


import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ConnectionServer {

    // private String stem = "http://172.16.8.68/";
    // private String stem = "http://192.168.1.76/";
    private String stem = "http://www.json-generator.com/api/json/get/ckluTNHPGW?indent=2";

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
            System.out.println(ReceiveJson.readJsonFromUrl(stem));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
