package abstracta;

public class PhoneExample {
    public static void main(String[] args) {
        //Phone phone = new Phone(); 이렇게 객체를 생성하면 오류가나온다 
        //이유는 phone() 안에 매게변수를 선언안해준것과 추상클래스는 객체생성이 안된다.
        SmartPhone smartphone = new SmartPhone("홍길동");

        smartphone.turnOn();
        smartphone.internetSearch();
        smartphone.turnOff();
    }


}
