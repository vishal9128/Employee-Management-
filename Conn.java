package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection con;
    public Statement st;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jio", "root", "vishal#12345");
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

