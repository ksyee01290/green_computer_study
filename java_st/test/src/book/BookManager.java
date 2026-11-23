package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookManager implements Manageable{
    Connection conn = null;
    Scanner sc = new Scanner(System.in,"MS949");
    
    Book[] books = new Book[10];
    int count = 0;

    @Override
    public void addItem(Book book) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");
            // book 객체 배열에 들어가는부분 else로 도서관이꽉찰경우 return으로 매서드를 빠져
            //나온다.
            if(count<books.length){
                books[count] = book;
                count++;

                String sql = ""+ "INSERT INTO books(id,title,author)"
                + "VALUES(?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                for(int i=0;i<count;i++){
                    pstmt.setInt(1,books[i].getId());
                    pstmt.setString(2,books[i].getTitle());
                    pstmt.setString(3,books[i].getAuthor());
                }
                
                int rows = pstmt.executeUpdate();
                System.out.println("저장된 행 수: " + rows);
                
                pstmt.close();
                System.out.println("결과: 성공적으로 등록되었습니다.");
                System.out.println("============================");
            } else{
                System.out.println("============================");
                System.out.println("도서관이 꽉참");
                return;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = ""+
            "SELECT id,title,author "+
            "FROM books ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
           
            System.out.println("============ 데이터 베이스 출력부 ============");
            while(rs.next()){
                Books bookss = new Books();
                bookss.setId(rs.getInt("id"));
                bookss.setTitle(rs.getString("title"));
                bookss.setAuthor(rs.getString("Author"));
                System.out.println(bookss);
            }

            rs.close();
            pstmt.close();
            if(count == 0){
                System.out.println("============================");
                System.out.println("등록된 도서가 없음");
                System.out.println("============================");
            }else{
                System.out.println("============  객체배열에 등록된 도서목록  ============");
                System.out.println();
                System.out.println("도서번호        도서제목                    저자명");
                System.out.println("---------------------------------------------------");
                for(int i=0;i<count;i++){
                    System.out.print(books[i].getId()+"\t");
                    System.out.print("\t"+books[i].getTitle()+"\t");
                    System.out.print("\s\s\s\s"+books[i].getAuthor()+"\t");
                    System.out.println();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveToDB() {
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
    public void loadFromDB() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

            String sql = ""+
            "SELECT id,title,author "+
            "FROM books ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                if(count >= books.length){
                    System.out.println("도서 저장공간이 가득찼습니다.");
                    break;
                }
                int id =rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");

                Book book = new Book(id,title,author);
                books[count] = book;
                count++;
            }
            rs.close();
            pstmt.close();
            System.out.println("파일불러오기 완료");

        } catch (Exception e) {
            System.out.println("불러오기 실패");
        }
    }

    public static void printInfo(){
        System.out.println("============  LIBRARY SYSTEM  ============");
        System.out.println("1. 도서 등록");
        System.out.println("2. 도서 목록 조회");
        System.out.println("3. 저장 및 종료");
        System.out.print("메뉴 선택 >> ");
    }
    
}
