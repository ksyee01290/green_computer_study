package dmbcell;
public class DmbCellPhone extends CellPhone{
    //자바는 단일 상속만 가능 부모클래스를 나열하면 안된다.
    //상속 제한 대상 : private 접근을 갖는 필드와 메소드 제외
    //                  부모클래스가 다른패키지에 있을경우 default
    //                  접근을 갖는 필드와 메소드도 제외

    //필드
    int channel;

    //생성자
    DmbCellPhone(String model, String color, int channel){
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    //메소드
    void turnOnDmb(){
        System.out.println("채널 "+channel+"번 DMB 방송 수신을 시작합니다.");
    }
    void changeChannelDmb(int channel){
        this.channel = channel;
        System.out.println("채널 "+channel+"번으로 바꿉니다.");
    }
    void turnOffDmb(){
        System.out.println("DMB 방송 수신을 멈춥니다.");
    }
}
