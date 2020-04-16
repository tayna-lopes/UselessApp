package org.Useless;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    String db="RachelBerry";
    String url="jdbc:mysql://localhost:32771/"+db;
    String usuario = "root";
    String senha = "root";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
