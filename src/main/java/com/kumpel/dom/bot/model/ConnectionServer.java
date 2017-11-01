
package com.kumpel.dom.bot.model;

// Não está funcionando, pode ser a internet daqui
// import com.google.gson.Gson;
import org.json.JSONObject;

// import java.net.HttpURLConnection;
//import java.net.URL;

public class ConnectionServer {

    // private String stem = "http://172.16.8.68/";
    // private String stem = "http://192.168.1.76/";
    private String stem = "http://www.json-generator.com/api/json/get/cfjXazNiCq?indent=2";
    private JSONObject json;

    public ConnectionServer() {
        try {
           this.json = ReceiveJson.readJsonFromUrl(stem);
            //Albums albums = gson.fromJson(IOUtils.toString(new URL(url)), Albums.class);

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
