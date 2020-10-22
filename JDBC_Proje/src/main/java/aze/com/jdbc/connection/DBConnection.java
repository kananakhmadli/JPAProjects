package aze.com.jdbc.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class DBConnection {

    public final Logger logger = LogManager.getLogger();
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/database.properties");
            properties.load(fileInputStream);
            driver = properties.getProperty("db_driver");
            url = properties.getProperty("db_url");
            username = properties.getProperty("db_username");
            password = properties.getProperty("db_password");

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public Connection connect() {
        try {
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(url, username, password);
            System.out.println("**************connected**************");

            return connect;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
