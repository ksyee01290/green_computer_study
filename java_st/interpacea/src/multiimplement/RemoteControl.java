package multiimplement;

public interface RemoteControl {

    // 인터페이스 는 생성자가 없다 변수를 따로 취급하지않고
    // 상수만 취급하는게 좋다. 변수는 다른 메인 필드에 쓰도록하자
    // 인터페이스는 추상메서드를 주로 이용하는거같다
    // 디폴트 메서드나 정적 메소드도 사용가능하다.

    //상수
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    //추상 메서드
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    //디폴드 메서드
    default void setMute(boolean mute){
        if(mute){
            System.out.println("무음 처리합니다.");
        } else {
            System.out.println("무음 해제합니다.");
        }
    }

    //정적 메서드
    static void changeBattery(){
        System.out.println("건전지를 교환합니다.");
    }
}
