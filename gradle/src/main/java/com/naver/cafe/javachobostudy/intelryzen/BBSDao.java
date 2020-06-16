package com.naver.cafe.javachobostudy.intelryzen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BBSDao {
    private Connection conn =null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;

    public BBSDao() {
        try{
        String dbUrl = "jdbc:mysql://localhost:3306/BBS";
        String dbId = "root";
        String dbPassword = "1234";
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDate(){
        String query = "select NOW()";
        try{
            pstmt = conn.prepareStatement(query);
            rs= pstmt.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public int getNext(){
        String query = "select bbsId from BBS order by bbsId desc";
        try{
            pstmt = conn.prepareStatement(query);
            rs= pstmt.executeQuery();
            if (rs.next()){
                return rs.getInt(1)+1;
            }
            return 1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return -4;// 데이터베이스 오류
    }

    public int write(String bbsTitle,String bbsContent,String userId) {
        String query = "insert into BBS values(?, ?, ?, ?, ?, ?)";
        try{
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, getNext());
            pstmt.setString(2, bbsTitle);
            pstmt.setString(3, userId);
            pstmt.setString(4, getDate());
            pstmt.setString(5, bbsContent);
            pstmt.setInt(6, 1);
            return pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return -5;
    }

    public static void main(String[] args) {
        BBSDao dao = new BBSDao();
        dao.write("title", "content", "user");
    }
}
