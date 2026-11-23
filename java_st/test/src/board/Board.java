package board;

public class Board {
    private int bid;
    private String btitle;
    private String bcontents;
    private String bauthor;

    public Board(){}

    public Board(String btitle, String bcontents, String bauthor){
        this.btitle = btitle;
        this.bcontents = bcontents;
        this.bauthor = bauthor;
    }
    public Board(int bid, String btitle, String bcontents, String bauthor){
        this.bid = bid;
        this.btitle = btitle;
        this.bcontents = bcontents;
        this.bauthor = bauthor;
    }

    //getter
    public int getBid(){
        return bid;
    }
    public String getBtitle(){
        return btitle;
    }
    public String getBcontents(){
        return bcontents;
    }
    public String getBauthor(){
        return bauthor;
    }

    //setter
    public void setBid(int bid){
        this.bid=bid;
    }
    public void setBtitle(String btitle){
        this.btitle=btitle;
    }
    public void setBcontents(String bcontents){
        this.bcontents=bcontents;
    }
    public void setBauthor(String bauthor){
        this.bauthor=bauthor;
    }

    @Override 
    public String toString(){
        return bid+"\t\t"+btitle+"\t\t\t"+bcontents+"\t\t\t"+bauthor;
    }

}
