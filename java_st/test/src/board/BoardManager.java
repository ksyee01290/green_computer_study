package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardManager implements Manageable {
    Scanner sc = new Scanner(System.in,"MS949");
    Connection conn = null;
    Board[] boards = new Board[10];
    int count = 0;
    int sct;

    public BoardManager(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@//localhost:1521/XE",
                    "system",
                    "1234");
            System.out.println("연결 성공");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addItem(Board board) {
        try {
            if(count<boards.length){
                String sql = ""+ "INSERT INTO board(bid, btitle, bcontents, bauthor)"
                + "VALUES(SEQ_board.NEXTVAL, ?, ?, ?)";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setString(1,board.getBtitle());
                pstmt.setString(2,board.getBcontents());
                pstmt.setString(3,board.getBauthor());
                
                int rows = pstmt.executeUpdate();
                System.out.println("저장된 행 수: " + rows);
                
                pstmt.close();

                boards[count] = board;
                count ++;
                System.out.println("결과: 성공적으로 등록되었습니다.");
                System.out.println("============================");
            } else{
                System.out.println("============================");
                System.out.println("계시판이 꽉참");
                return;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        load();
        try {
            String sql = ""+
            "SELECT bid,btitle,bcontents,bauthor "+
            "FROM board "+
            "WHERE bid=?";
            System.out.println();
            System.out.print("검색할 id: ");
            sct = Integer.parseInt(sc.nextLine());

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sct);

            ResultSet rs = pstmt.executeQuery();
           
            System.out.println("============ 데이터 베이스 출력부 ============");
            if(rs.next()){
                Boards boardss = new Boards();
                boardss.setBid(rs.getInt("bid"));
                boardss.setBtitle(rs.getString("btitle"));
                boardss.setBcontents(rs.getString("bcontents"));
                boardss.setBauthor(rs.getString("bAuthor"));
                System.out.println(boardss.toString());
                System.out.println("=============================================\n");
            } else {
                System.out.println("사용자 id가 존재하지 않음");
            }            
            System.out.println();

            rs.close();
            pstmt.close();
            if(count == 0){
                System.out.println("============================");
                System.out.println("등록된 도서가 없음");
                System.out.println("============================");
            }else{
                System.out.println("============  객체배열에 등록된 도서목록  ============");
                System.out.println();
                System.out.println("게시판번호      게시판제목              게시판내용                      작성자");
                System.out.println("------------------------------------------------------------------------------");
                for(int i=0;i<count;i++){
                    // System.out.print(boards[i].getBid()+"\t");
                    // System.out.print("\t"+boards[i].getBtitle()+"\t");
                    // System.out.print("\s\s\s\s"+boards[i].getBcontents()+"\t");
                    // System.out.println(boards[i].getBauthor());
                    System.out.println(boards[i].toString());
                    System.out.println();
                }

                while(true){
                    printInfo2();
                    System.out.print("선택: ");
                    String det = sc.nextLine();

                    if(det.equals("1")){
                        updataDB();
                    } else if(det.equals("2")){
                        deletDB();
                    } else if(det.equals("3")){
                        System.out.println("돌아가기");
                        break;
                    } else{
                        System.out.println("잘못 입력하셧습니다.");
                    }
                }
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updataDB() {
        try {
            String sql = new StringBuilder()
                .append("UPDATE board SET ")
                .append("btitle=?, ")
                .append("bcontents=?, ")
                .append("bauthor=? ")
                .append("WHERE bid=?")
                .toString();
            
            PreparedStatement pstmt = conn.prepareStatement(sql);

            System.out.println("[게시물 수정]");
            System.out.print("제목: ");
            String btitle = sc.nextLine();
            System.out.print("내용: ");
            String bcontents = sc.nextLine();
            System.out.print("작성자: ");
            String bauthor = sc.nextLine();

            pstmt.setString(1,btitle);
            pstmt.setString(2,bcontents);
            pstmt.setString(3,bauthor);
            pstmt.setInt(4,sct);

            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수: "+rows);
            
            pstmt.close();
            System.out.println("성공적으로 업데이트 되었습니다.");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletDB() {
        try {

            String sql = "DELETE FROM board "+
            "WHERE bid = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,sct);

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: "+rows);

            System.out.println("정상적으로 삭제 되었습니다.");

            pstmt.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletAllDB() {
        try {
            String sql = "DELETE FROM board ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수: "+rows);

            pstmt.close();
        }catch (SQLException e) {
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
            String sql = ""+
            "SELECT bid,btitle,bcontents,bauthor "+
            "FROM board ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                if(count >= boards.length){
                    System.out.println("도서 저장공간이 가득찼습니다.");
                    break;
                }
                int bid =rs.getInt("bid");
                String btitle = rs.getString("btitle");
                String bcontents = rs.getString("bcontents");
                String bauthor = rs.getString("bauthor");

                Board board = new Board(bid,btitle,bcontents,bauthor);
                boards[count] = board;
                count++;
            }

            rs.close();
            pstmt.close();
            System.out.println("파일불러오기 완료");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        count = 0;
        try {
            String sql = ""+
            "SELECT bid,btitle,bcontents,bauthor "+
            "FROM board ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                if(count >= boards.length){
                    System.out.println("도서 저장공간이 가득찼습니다.");
                    break;
                }
                int bid =rs.getInt("bid");
                String btitle = rs.getString("btitle");
                String bcontents = rs.getString("bcontents");
                String bauthor = rs.getString("bauthor");

                Board board = new Board(bid,btitle,bcontents,bauthor);
                boards[count] = board;
                count++;
            }

            rs.close();
            pstmt.close();
            System.out.println("파일불러오기 완료");

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void printInfo(){
        System.out.println("============  BOARD SYSTEM  ============");
        System.out.println("1. 게시물 등록");
        System.out.println("2. 상세 조회");
        System.out.println("3. 전체 삭제");
        System.out.println("4. Exit");
        System.out.print("메뉴 선택 >> ");
    }
    public static void printInfo2(){
        System.out.println("============  BOARD(DETAIL) SYSTEM  ============");
        System.out.println("1. 게시물 수정");
        System.out.println("2. 게시물 삭제");
        System.out.println("3. 돌아가기");
    }

}
