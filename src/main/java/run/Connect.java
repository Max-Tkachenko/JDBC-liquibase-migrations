package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connection;
    public static String URL = "jdbc:mysql://91.238.103.81/messanger_db";
    public static String DRIVER = "com.mysql.jdbc.Driver";

    public static void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, "max", "max12345");
            System.out.println("Connection successful...");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection failed (MySQL exception)!");
        }
    }
    public static void disconnect() {
        try {
            connection.close();
            System.out.println("Connection closed...");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection closing failed!");
        }
    }
}