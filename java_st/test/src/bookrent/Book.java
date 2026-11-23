package bookrent;

public class Book {
    private String bookid;
    private int bookis;
    private String booktitle;
    private String bookauthor;
    private String bookpublishing;

    public Book(String bookid,int bookis, String booktitle, String bookauthor, String bookpublishing){
        this.bookid=bookid;
        this.bookis=bookis;
        this.booktitle=booktitle;
        this.bookauthor=bookauthor;
        this.bookpublishing=bookpublishing;
    }

    public String getBookid(){
        return bookid;
    }
    public int getBookis(){
        return bookis;
    }
    public String getBooktitle(){
        return booktitle;
    }
    public String getBookauthor(){
        return bookauthor;
    }
    public String getBookpublishing(){
        return bookpublishing;
    }

    //setter
    public void setBookid(String bookid){
        this.bookid=bookid;
    }
    public void setBookis(int bookis){
        this.bookis=bookis;
    }
    public void setBooktitle(String booktitle){
        this.booktitle=booktitle;
    }
    public void setBookauthor(String bookauthor){
        this.bookauthor=bookauthor;
    }
    public void setBookpublishing(String bookpublishing){
        this.bookpublishing=bookpublishing;
    }
}
