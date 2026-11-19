package book;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Bookservice implements Manageable{
    Scanner sc = new Scanner(System.in,"MS949");
    String filename = "C:/study/java_st/test/src/book/book.txt";
    

    Book[] books = new Book[3];
    int count = 0;

    @Override
    public void addItem(Book book) {
        if(count<books.length){
            books[count] = book;
            count++;
            System.out.println("결과: 성공적으로 등록되었습니다.");
            System.out.println("============================");
        } else{
            System.out.println("============================");
            System.out.println("도서관이 꽉참");
        }
        
    }

    @Override
    public void displayAll() {
        if(count == 0){
            System.out.println("============================");
            System.out.println("등록된 도서가 없음");
            System.out.println("============================");
        }else{
            System.out.println("============  등록된 도서목록  ============");
            System.out.println();
            for(int i=0;i<count;i++){
                System.out.println("============================");
                System.out.println("도서 번호: "+books[i].getId());
                System.out.println("도서 제목: "+books[i].getTitle());
                System.out.println("저자명: "+books[i].getAuthor());
            }
        }

    }

    @Override
    public void saveToFile() {
        try {
            File file = new File(filename);
            FileWriter fw = new FileWriter(file, true);

            for(int i=0;i<count;i++){
                fw.write(books[i].getId()+",");
                fw.write(books[i].getTitle()+",");
                fw.write(books[i].getAuthor()+"\n");
            }
            fw.flush();
            fw.close();
            System.out.println("파일에 저장되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        Book book = new Book();
        try {
            FileReader fr = new FileReader(filename);

            String line = "";
            int readCharNo;
            char[] cbuf = new char[100];
            while((readCharNo = fr.read(cbuf))!= -1){
                String data = new String(cbuf, 0, readCharNo);
                System.out.println(data);
                line = data;
            }
            String[] red = line.split(",|\n");

            for(String name : red){
                System.out.println(name);
            }
            for(int i=0;i<books.length;i++){
                
            }
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
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
