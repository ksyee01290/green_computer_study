package book;

import java.io.File;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in,"MS949");

        Manageable service = new BookManager();
        
        filecreate();
        service.loadFromFile();

        while(true){
            BookManager.printInfo();
            String num = sc.nextLine();

            if(num.equals("1")){
                System.out.println();
                System.out.println("[도서 등록]");
                System.out.print("ID: ");
                int id;
                while(true){
                    try {
                        id = (Integer.parseInt(sc.nextLine()));
                        break;
                    } catch (Exception e) {
                        System.out.println("숫자만 입력 가능합니다.");
                    }
                }

                System.out.print("제목: ");
                String title = sc.nextLine();

                System.out.print("저자: ");
                String author = sc.nextLine();

                Book book = new Book(id,title,author);
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
                System.out.println("잘못 입력하셧습니다.");
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
                System.out.println("성공적인 파일 생성");
            } else {
                System.out.println("파일이 이미 있습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
