package Manager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Properties;

public class DBManager {

    private static Properties properties= new Properties();
    private static String host;
    private static String port;
    private static String dataBase;
    private static String user;
    private static String pass;
    private static String url;

    public static void iniProperties() {
        setProperties();
        getPropertiesValues();
        try {
            OutputStream os;
            properties.store(os = new FileOutputStream("Config"),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUrl();
    }
    private static void getPropertiesValues() {
        host=properties.getProperty("host");
        port=properties.getProperty("port");
        dataBase=properties.getProperty("database");
        user=properties.getProperty("user");
        pass=properties.getProperty("pass");
    }
    private static void setProperties() {
        properties.setProperty("host", "localhost");
        properties.setProperty("port", "49674");
        properties.setProperty("database","DataExample");
        properties.setProperty("user", "sa");
        properties.setProperty("pass", "mitesoro");
    }

    public static String getHost() {
        return host;
    }
    public static void setHost(String host) {
        DBManager.properties.setProperty("host", host);
    }
    public static String getPort() {
        return port;
    }
    public static void setPort(String port) {
        DBManager.properties.setProperty("port", port);
    }
    public static String getDataBase() {
        return dataBase;
    }
    public static void setDataBase(String dataBase) {
        DBManager.properties.setProperty("database", dataBase);
    }
    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        DBManager.properties.setProperty("user", user);
    }
    public static String getPass() {
        return pass;
    }
    public static void setPass(String pass) {
        DBManager.properties.setProperty("pass", pass);
    }
    public static String getUrl() {
        return url;
    }
    public static void setUrl() {
        url="jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dataBase+ ";integratedSecurity=false";
    }

    public void executeQuery(String sqlQuery)
    {
        Connection connection= createConnection();
        try (Statement stat = connection.createStatement()) {
            ResultSet rs= stat.executeQuery(sqlQuery);
            while(rs.next())
            {
            }
            close(rs);
            close(stat);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        close(connection);
    }
    public void executeDML()
    {

    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(ResultSet result) {
        try {
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

