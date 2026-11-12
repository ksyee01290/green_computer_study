package Supersonic;
public class SupersonicAirplane extends Airplane{

    //여기에서의 static final은 상수를 의미한다 초기화불가능하고
    //값을 바꿀수 없다
    //여기있는 파이널 값을 읽고싶다면 메인에 클래스이름 (.)원하는 변수이름을
    //작성해야 볼수만 있다 수정불가 public static 이기때문
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flyMode = NORMAL;

    @Override 
    public void fly(){
        if(flyMode == SUPERSONIC) {
            System.out.println("초음속 비행합니다.");
        } else {
            //Airplane 객체의 fly() 메소드 호출
            super.fly();
        }
    }
}
