package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {
    public static Connection connection;
    public static String URL = "jdbc:postgresql://localhost:5432/Messanger_DB";
    public static String DRIVER = "org.postgresql.Driver";

    public static void connect() {
        try {
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "max12345");
            connection = DriverManager.getConnection(URL, props);
            System.out.println("\nConnection successful...");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Connection failed (class not found)!");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection failed (PostgreSQL exception)!");
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