package com.devbian.dao;

import java.sql.*;

/**
 * Created by phnix on 2014/9/7.
 */
public class WorldInfo {
    private static WorldInfo worldInfo;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public WorldInfo() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
    }

    public ResultSet GetInfos() throws SQLException {
        Statement statement =this.connection.createStatement();
        return statement.executeQuery(" select * from city ");
    }

    public void Close() throws SQLException {
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }
}
