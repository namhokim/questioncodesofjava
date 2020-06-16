package com.naver.cafe.javachobostudy.intelryzen;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.google.common.base.Preconditions.checkState;

public class BBSDao {
    /**
     * eg) 2020-06-16 16:30:49
     */
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 게시판(BBS)의 ID는 1부터 시작한다고 가정한다.
     */
    private static final int DEFAULT_BBS_ID = 1;
    private static final int FIRST_COLUMN = 1;

    private Connection conn = null;

    public BBSDao() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/BBS";
            String dbId = "root";
            String dbPassword = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNext() {
        String query = "select ifnull(max(bbsId), 0) as nextId from BBS";
        try {
            final Statement statement = conn.createStatement();
            if (!statement.execute(query)) {
                return DEFAULT_BBS_ID;
            }
            final ResultSet resultSet = statement.getResultSet();
            checkState(resultSet.next(), "쿼리 수행 결과가 반드시 한 개 존재해야 합니다.");
            return resultSet.getInt(FIRST_COLUMN) + 1;
        } catch (Exception e) {
            throw new NextSequenceGenerationException(e);
        }
    }

    public void write(String bbsTitle, String bbsContent, String userId) {
        String query = "insert into BBS (bbsId, title, userId, dt, content, cnt) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, getNext());
            pstmt.setString(2, bbsTitle);
            pstmt.setString(3, userId);
            pstmt.setString(4, now());
            pstmt.setString(5, bbsContent);
            pstmt.setInt(6, 1);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new BbsWriteException(e);
        }
    }

    private String now() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * 다음 bbsId 를 가져오지 못했을때 발생하는 예외
     */
    public static class NextSequenceGenerationException extends RuntimeException {
        public NextSequenceGenerationException(Throwable cause) {
            super(cause);
        }
    }

    public static class BbsWriteException extends RuntimeException {
        public BbsWriteException(Throwable cause) {
            super(cause);
        }
    }

    public static void main(String[] args) {
        BBSDao dao = new BBSDao();
        dao.write("title", "content", "user");
    }
}
