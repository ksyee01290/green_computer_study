package abstracta;

public abstract class Phone {
    public String owner;

    public Phone(String owner){
        this.owner = owner;
    }

    // 추상 메서드는 아래와같이 실행부분을 비워둔다.
    // 구체적인 구현부없이
    public void turnOn(){
        System.out.println("폰 전원을 켭니다.");
    }

    public void turnOff(){
        System.out.println("폰 전원을 끕니다.");
    }
}
