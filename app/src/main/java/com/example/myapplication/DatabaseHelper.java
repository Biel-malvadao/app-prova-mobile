package com.example.myapplication;

import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:bdHelper.db";

    public static void connect() {
        try (Connection conn = DriverManager.getConnection(URL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("O driver JDBC é " + meta.getDriverName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " name text NOT NULL,\n"
                + " email text NOT NULL,\n"
                + " phone text NOT NULL,\n"
                + " address text NOT NULL,\n"
                + " city text NOT NULL,\n"
                + " state text NOT NULL,\n"
                + " zipCode text NOT NULL,\n"
                + " country text NOT NULL,\n"
                + " username text NOT NULL,\n"
                + " password text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(User user) {
        String sql = "INSERT INTO users(name, email, phone, address, city, state, zipCode, country, username, password) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getCity());
            pstmt.setString(6, user.getState());
            pstmt.setString(7, user.getZipCode());
            pstmt.setString(8, user.getCountry());
            pstmt.setString(9, user.getUsername());
            pstmt.setString(10, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

