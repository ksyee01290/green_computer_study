package computer;
public class Computer extends Calculator{
    //오버라이딩 할때는 부모클래스를 꼭 상속해야한다.
    //조상 의 메서드가 protected라면 범위가 같거나 넓은 protected나
    //좀더 넓은 public 로만 변경가능하다.
    //public를 default나 private로 수정은 불가능하다.
    //default는 public로 수정이 가능
    @Override 
    double areaCircle(double r){
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}
