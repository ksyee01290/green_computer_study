package implementa;

public class RemoteControlExample {
    public static void main(String[] args) {
        // RemoteControl rc;
        // rc = new Television();
        // rc = new Audio();

        // rc.turnOn();
        // rc.setVolume(8);
        // rc.setMute(true);
        // rc.setVolume(10);
        // rc.setMute(false);
        // rc.turnOff();
        // System.out.println(rc);

        //아래와 같이 인스턴스 내부의 메소드를 불러올수있다
        //static이기때문
        // RemoteControl.changeBattery();


        // 아래와 같이 쓰는것을 익명 구현 객체라불린다
        //인터페이스를 직접 선언
        RemoteControl rc = new RemoteControl(){
            public void turnOn() {System.out.println("이렇게쓰는건가");}
            public void turnOff() {System.out.println("아니면 이렇게?");}
            public void setVolume(int volume){
                System.out.println("그것또한 아니라면 이거");
                System.out.println("불륨은 이거: "+volume);
            }
        };
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(9);
    }
}
