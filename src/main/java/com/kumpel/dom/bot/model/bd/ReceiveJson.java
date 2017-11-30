package com.kumpel.dom.bot.model.bd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class ReceiveJson {

    private static String readAll(Reader read) throws IOException {
        StringBuilder content = new StringBuilder();
        int copy;
        while ((copy = read.read()) != -1) {
            content.append((char) copy);
        }
        return content.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

        try (InputStream input = new URL(url).openStream()) {
            BufferedReader read = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
            String jsonText = readAll(read);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

}

