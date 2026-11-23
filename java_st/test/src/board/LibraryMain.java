package board;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");
        Manageable service = new BoardManager();

        service.loadFromDB();
        while(true){
            BoardManager.printInfo();
            String num = sc.nextLine();

            if(num.equals("1")){
                System.out.println();
                System.out.println("[게시물 등록]");
                System.out.print("제목: ");
                String btitle = sc.nextLine();

                System.out.print("내용: ");
                String bcontents = sc.nextLine();

                System.out.print("작성자: ");
                String bauthor = sc.nextLine();

                Board board = new Board(btitle,bcontents,bauthor);
                service.addItem(board);

                System.out.println();
                
            } else if(num.equals("2")){
                service.display();
                System.out.println();
                
            } else if(num.equals("3")){
                service.deletAllDB();
                System.out.println("저장된 데이터를 전부 삭제합니다.");

            } else if(num.equals("4")){   
                service.saveToDB();
                System.out.println("프로그램을 종료합니다.");
                break;

            } else{
                System.out.println("잘못 입력하셧습니다.");
                break;
            }
        }
    }
}
