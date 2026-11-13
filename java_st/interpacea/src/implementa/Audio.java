package implementa;

public class Audio implements RemoteControl{
    //추상메소드를 따로 작성안해주면 클래스 오류난거처럼 보인다.

    //필드
    private int volume;

    //추상메소드의 실체 메서드 추상메서드 이지만 따로 오버라이딩 해주는건
    //아닌듯해보인다.
    public void turnOn(){
        System.out.println("Audio를 켭니다.");
    }

    public void turnOff(){
        System.out.println("Audio를 끕니다.");
    }

    public void setVolume(int volume){
        if(volume>RemoteControl.MAX_VOLUME){
            this.volume = RemoteControl.MAX_VOLUME;
        } else if(volume<RemoteControl.MIN_VOLUME){
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 Audio 볼륨: "+volume);
    }
}
