package bookrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin implements AdminManageable{
    Connection conn = null;
    Scanner sc = new Scanner(System.in,"MS949");

    Book[] books = new Book[100];
    int count = 0;
    int sct;

    public Admin(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bookcreate(Book book) {
        try {
            if(count<books.length){
                String sql = ""+ "INSERT INTO book(bid,bis,btitle,bauthor,bpublish,bok) "
                + "VALUES(?,?,?,?,?,?)";

                PreparedStatement pstmt = conn.prepareStatement(sql);

                for(int i=0;i<count;i++){
                    pstmt.setInt(1,books[i].getBookid());
                    pstmt.setString(2,books[i].getBookis());
                    pstmt.setString(3,books[i].getBooktitle());
                    pstmt.setString(4,books[i].getBookauthor());
                    pstmt.setString(5,books[i].getBookpublishing());
                }

                int rows = pstmt.executeUpdate();
                System.out.println("저장된 행 수: "+ rows);

                pstmt.close();
                System.out.println("결과: 성공적으로 등록 되었습니다.");

                books[count] = book;
                count++;
            } else {
                System.out.println("도서관이 꽉참");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void bookdelete(Book book) {
        try {
            String sql = "DELETE FROM book "+
            "WHERE bid = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sct);

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: "+rows);

            System.out.println("정상적으로 삭제 되었습니다.");
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bookselect(Book book) {
        
    }

    @Override
    public void bookupdate(Book book) {
    }

    @Override
    public void peoplemanagement() {
    }

    @Override
    public void rentreturn() {
    }

    @Override 
    public void dbclose(){
        try {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void booktotal(Book book) {
    }
    
}
