package by.training.finalproject.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public String DB_USER_NAME ;

    public String DB_PASSWORD ;

    public String DB_URL;

    public String DB_DRIVER;

    public Integer DB_MAX_CONNECTIONS;

    public Configuration(){
        init();
    }
    private static Configuration configuration = new Configuration();

    public static Configuration getInstance(){
        return configuration;
    }

    private void init() {
        DB_USER_NAME = "root";
        DB_PASSWORD = "root";
        DB_URL = "jdbc:mysql://localhost:3306/maintenance_system_db?autoReconnect=true&useSSL=FALSE&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        DB_DRIVER = "com.mysql.jdbc.Driver";
        DB_MAX_CONNECTIONS = 5;
    }

    //TODO init using .properties
    private void initViaProp(){
        Properties props = new Properties();
        try {
            InputStream in = Configuration.class.getClassLoader().getResourceAsStream("database.properties");
            props.load(in);
        }catch (IOException io) {
            System.out.println("io");
        }

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
    }
}
