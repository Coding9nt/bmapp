package com.baseballmanager.bmapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://192.168.50.37:3306/bmanager?serverTimezone=UTC&characterEncoding=UTF-8";
        String username = "admin";
        String password = "wjdqhqhdks";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
