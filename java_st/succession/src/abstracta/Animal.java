package abstracta;

public abstract class Animal {
    public String kind;

    public void breathe(){
        System.out.println("숨을 쉽니다.");
    }
    
    //여기부분은 추상매서드 이다 추상메서드를 쓸때는 {}을 지우고 public
    //앞에 abstract를 붙여주어 추상매서드라는것을 인식하게 만들어야한다.
    public abstract void sound();
}
