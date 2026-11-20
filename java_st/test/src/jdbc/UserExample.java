package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExample {
    //유저 업데이트 부분
    
    //유저 삭제 부분
    public static void UserDelete(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = "DELETE FROM User WHERE userid=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter323");

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
    //유저 검색부분
    public static void UserSelect(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = ""+
            "SELECT userid, username, userpassword, userage, useremail "+
            "FROM users "+
            "WHERE userid=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter2");

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt(4));
                user.setUserEmail(rs.getString(5));
                System.out.println(user);
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

    //유저 추가부분
    public static void UserInsert(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            // 매개변수화 된 sql문 작성
            // "" 쓰는이유는 안정성 강화 역할을한다.
            String sql = ""+
            "INSERT INTO users(userid, username, userpassword, userage, useremail)"
            + "VALUES(?, ?, ?, ?, ?)";

            //preparedstatement 얻기 및 값지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter323");
            pstmt.setString(2,"두겨울");
            pstmt.setString(3,"123444425");
            pstmt.setInt(4,32);
            pstmt.setString(5,"winter@gmail.com");

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
                } catch (SQLException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        UserInsert();
        UserSelect();

    }
}
