package multiimplement;
//구현 클래스
// 아래 implements 옆에 여러게의 인터페이스를 넣을수 있다.
// 여러게의 인터페이스를 넣었으면 각각의 인터페이스에 들어있는 
// 메서드 들을 전부 써주어야 오류가 안난다.
public class SmartTelevision implements RemoteControl, Searchable{
    private int volume;

    public void turnOn(){
        System.out.println("TV를 켭니다.");
    }
    public void turnOff(){
        System.out.println("TV를 끕니다.");
    }
    public void setVolume(int volume){
        if(volume>RemoteControl.MAX_VOLUME){
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume<RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 TV 볼륨: "+volume);
    }
    public void search(String url){
        System.out.println(url+"을 검색합니다.");
    }
}
