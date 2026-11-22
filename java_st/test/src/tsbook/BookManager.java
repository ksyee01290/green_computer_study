package tsbook;

public class BookManager {
    Book[] books = new Book[5];
    int count=0;

    public void addBook(Book book){
        if(count>=books.length){
            System.out.println("도서관이 꽉찼습니다.");
        }else{
            books[count]=book;
            count++;
        }
    }

    public void displayAll(){
        if(count==0){
            System.out.println("등록된 도서가 없습니다.");
            return;
        }

        for(int i=0;i<count;i++){
            System.out.println(books[i].toString());
        }
    }
    
    public void searchBook(int id){
        boolean found = false;
        for(int i=0;i<count;i++){
            if(books[i].getId()==id){
                System.out.println("제목"+books[i].getTitle());
                System.out.println("저자"+books[i].getAuthor());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("해당도서 검색불가");
        }
    }
}
