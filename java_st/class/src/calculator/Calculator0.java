package calculator;
public class Calculator0 {
    public void powerOn(){
        System.out.println("전원을 켭니다.");
    }

    // int로 메서드를 지정했을경우 return 값도 int로 지정되어야한다.
    public int plus(int x, int y){
        int result = x+y;
        return result;
    }
    // double로 메서드를 지정했을경우 return 값도 double 로 지정되어야 한다.
    public double divide(int x, int y){
        double result = (double)x / (double)y;
        return result;
    }
    // void 는 리턴값이 필요없을때 주로 사용한다
    public void powerOff(){
        System.out.println("전원을 끕니다.");
    }
}
