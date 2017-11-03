package com.kumpel.dom.bot.controller.bdcontroller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection implements ConnectionInterface {

    public static Connection connection() throws Exception {
        Class.forName(DR);
        Connection conn = DriverManager.getConnection(URL, UN, PW);
        return conn;
    }
}
