package com.company.expenseapp.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Connectable {
    default Connection connect() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "PRODUCTION";
        String password = "12345";
        return DriverManager.getConnection(url, user, password);
    }
}
