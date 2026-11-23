package bookrent;
//정의
public class User {
    private String userid;
    private String userps;
    private String username;
    private String usertel;

    public User(){}

    public User(String userid,String userps,String username,String usertel){
        this.userid = userid;
        this.userps = userps;
        this.username = username;
        this.usertel = usertel;
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
}
