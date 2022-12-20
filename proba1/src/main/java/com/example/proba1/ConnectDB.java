package com.example.proba1;
import java.sql.*;

public class ConnectDB {
    Connection dbConnect;

   String userDB = "root";
   String passdB = "admin_123";

    public Connection getConnect() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://127.0.0.1:3306/model5";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnect = DriverManager.getConnection(connectionString, userDB, passdB);
        return dbConnect;
    }

    public ResultSet getUser(String login, String password) throws SQLException, ClassNotFoundException{
        ResultSet resultSet = null;
        String select = "SELECT * FROM model5.user where login = '"+login+"' and password = '"+password+"'";
        PreparedStatement preparedStatement = getConnect().prepareStatement(select);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


}
