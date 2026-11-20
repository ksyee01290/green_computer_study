package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class BoardExample {
//보더 추가
    public static void boardsInsert(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = ""+
                "INSERT INTO boards(btitle, bcontent, bfilename, bfiledata, bno)"
                + "VALUES(?, ?, ?, ?, ?)";

            //preparedstatement 얻기 및 값지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter2");
            pstmt.setString(2,"두겨울");
            pstmt.setString(3,"123444425");
            pstmt.setBlob(4,null, 12);
            pstmt.setInt(5,2);

            //sql문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);

            pstmt.close();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {}
            }
        }
    }
// 보더 업데이트
    public static void boardsupdata() throws FileNotFoundException{
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = new StringBuilder()
                .append("UPDATE boards SET ")
                .append("btitle=?, ")
                .append("bcontent=?, ")
                .append("bfilename=?, ")
                .append("bfiledata=? ")
                .append("WHERE bno=?")
                .toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"눈사람");
            pstmt.setString(2,"눈으로 만든 사람");
            pstmt.setString(3, "snowman.jpg");
            pstmt.setBlob(4, new FileInputStream("C:\\study\\java_st\\test\\src\\jdbc\\snowman.jpg"));
            pstmt.setInt(5,2);

            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: "+rows);

            pstmt.close();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {}
            }
        }
    }
//보더 삭제
    public static void BoardDelete(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = "DELETE FROM boards WHERE btitle=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람");

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: "+rows);

            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {
                }
            }
        }
    }
//보더 검색
    public static void BoardSelect(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = ""+
            "SELECT btitle, bcontent, bfilename, bfiledata, bno "+
            "FROM boards "+
            "WHERE btitle=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"눈사람");

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Board board = new Board();
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));
                board.setBno(rs.getInt(2));
                System.out.println(board);
            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }
            
            rs.close();
            pstmt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {
                }
            }
        }
    }

    
    public static void main(String[] args) throws FileNotFoundException {
        //boardsInsert();
        //boardsupdata();
        BoardSelect();
        //BoardDelete();
    }
}
