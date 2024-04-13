package cue.edu.co.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static String url = "jdbc:mysql://127.0.0.1:3306/jakarta_test?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "root123";
    private static Connection connection;
    public static Connection getInstance() throws SQLException {
        if(connection==null){
            connection = DriverManager.getConnection(url,user,password);
        }
        return connection;
    }

}
