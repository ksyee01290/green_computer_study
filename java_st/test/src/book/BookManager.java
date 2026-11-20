package book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BookManager implements Manageable{
    Scanner sc = new Scanner(System.in,"MS949");
    String filename = "C:/study/java_st/test/src/book/book.txt";
    

    Book[] books = new Book[10];
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
            System.out.println("도서번호        도서제목                    저자명");
            System.out.println("---------------------------------------------------");
            for(int i=0;i<count;i++){
                System.out.print(books[i].getId()+"\t");
                System.out.print("\t"+books[i].getTitle()+"\t");
                System.out.print("\s\s\s\s"+books[i].getAuthor()+"\t");
                System.out.println();
            }
        }
    }

    @Override
    public void saveToFile() {
        try {
            File file = new File(filename);
            FileWriter fw = new FileWriter(file,true);

            for(int i=0;i<count;i++){
                fw.write(books[i].toFileString()+"\n");
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
        try {
            FileReader file = new FileReader(filename);
            BufferedReader br = new BufferedReader(file);
            String line;
            while((line = br.readLine())!= null){
                if(count >= books.length){
                    System.out.println("도서 저장공간이 가득찼습니다.");
                    break;
                }
                
                String[] data = line.split(",",-1);
                if(data.length != 3){
                    continue;
                }
                Book book = new Book(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2]
                );

                books[count] = book;
                count++;
            }
            System.out.println("파일불러오기 완료");
            br.close();
            file.close();

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
