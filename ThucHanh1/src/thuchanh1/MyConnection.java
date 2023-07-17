/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh1;

import java.sql.*;

/**
 *
 * @author huyho
 */
public class MyConnection {
    Connection conn = null;
    public Connection getConnect() {
        String database = "quanlytaikhoan";
        String username ="root";
        String password = "011223445aA@";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1:9999;" + "databaseName=" + database + ";user=" + username + ";password=" + password;
            System.out.println(url);
            conn = DriverManager.getConnection(url);
            System.out.println("Da ket noi voi database " + conn.getCatalog());
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}
