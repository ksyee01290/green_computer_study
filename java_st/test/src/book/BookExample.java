package book;

import java.io.File;
import java.util.Scanner;

public class BookExample {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in,"MS949");

        Manageable service = new Bookservice();
        
        filecreate();
        service.loadFromFile();

        while(true){
            Bookservice.printInfo();
            String num = sc.nextLine();

            if(num.equals("1")){
                Book book = new Book();
                System.out.println();
                System.out.println("[도서 등록]");
                System.out.print("ID: ");
                book.setId(Integer.parseInt(sc.nextLine()));

                System.out.print("제목: ");
                book.setTitle(sc.nextLine());

                System.out.print("저자: ");
                book.setAuthor(sc.nextLine());

                service.addItem(book);

                System.out.println();
                
            } else if(num.equals("2")){
                service.displayAll();
                System.out.println();
                
            } else if(num.equals("3")){
                service.saveToFile();
                System.out.println("프로그램을 종료합니다.");
                break;
            } else{
                break;
            }
        }
    }

    //파일 생성하는부분 초기화
    public static void filecreate() throws Exception{
        String filename = "C:/study/java_st/test/src/book/book.txt";
        try {
            File book = new File(filename);
            if(book.exists() == false){
                book.createNewFile();
            }
            System.out.println("성공적인 파일 생성");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
