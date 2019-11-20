package com.naver.cafe.javachobostudy.lunaticsn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParenthesisExpected {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/MySQL?useSSL=false&serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "Paper0407291221";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
