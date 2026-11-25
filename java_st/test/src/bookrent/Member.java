package bookrent;

public class Member {
    private String userid;
    private String userps;
    private String username;
    private String usertel;
    private String userdate;
    private boolean userbol;

    public Member(){}

    public Member(String userid,String username,String usertel){
        this.userid=userid;
        this.username=username;
        this.usertel=usertel;
    }

    public Member(String userid,String userps,String username,String usertel,String userdate,boolean userbol){
        this.userid = userid;
        this.userps = userps;
        this.username = username;
        this.usertel = usertel;
        this.userdate = userdate;
        this.userbol = userbol;
    }

    //getter
    public String getUserid(){
        return userid;
    }
    public String getUserps(){
        return userps;
    }
    public String getUsername(){
        return username;
    }
    public String getUsertel(){
        return usertel;
    }
    public String getUserdate(){
        return userdate;
    }
    public boolean getUserbol(){
        return userbol;
    }

    //setter
    public void setUserid(String userid){
        this.userid=userid;
    }
    public void setUserps(String userps){
        this.userps=userps;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setUsertel(String usertel){
        this.usertel=usertel;
    }
    public void setUserdate(String userdate){
        this.userdate=userdate;
    }
    public void setUserbol(boolean userbol){
        this.userbol=userbol;
    }
}
