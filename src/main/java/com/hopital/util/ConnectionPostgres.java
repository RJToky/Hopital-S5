package com.hopital.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPostgres {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hopital", "postgres", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
