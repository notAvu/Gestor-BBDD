package Manager;

import java.sql.*;
import java.util.Properties;

public class DBManager {
    //opciones:
//    Ejecutar cconsulta
//    Ejecutar DML
//    Ejecutar DDL
//    Configuracion de la conexion
//    Salir del programa

    private static Properties properties= new Properties();
    private static String driver=properties.getProperty("driver");
    private static String host=properties.getProperty("host");
    private static String port=properties.getProperty("port");
    private static String dataBase=properties.getProperty("database");
    private static String user=properties.getProperty("user");
    private static String pass=properties.getProperty("pass");
    private static String url=driver + host + ":" + port + ";databaseName=" + dataBase+ ";integratedSecurity=false";

    public static void iniValues()
    {
        properties.put("driver","jdbc:sqlserver://");
        properties.put("host", "localhost");
        properties.put("port","49674");
        properties.put("database","DataExample");
        properties.put("user", "sa");
        properties.put("pass", "mitesoro");
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
        url=driver + host + ":" + port + ";databaseName=" + dataBase+ ";integratedSecurity=false";
    }

    public static Connection createConnection()
    {
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("F");
        }
        return connection;
    }
    public static void close(ResultSet result)
    {
        try {
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Statement statement)
    {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection)
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

