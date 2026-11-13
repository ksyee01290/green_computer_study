package implementa;

public class Television implements RemoteControl{
    //implements 는 구현 예약어 이다.
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
}
