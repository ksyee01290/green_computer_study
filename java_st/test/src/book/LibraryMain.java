package book;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in,"MS949");
        Manageable service = new BookManager();
        service.loadFromDB();

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
