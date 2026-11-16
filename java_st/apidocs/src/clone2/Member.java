package clone2;

import java.util.Arrays;

// 아래 클래스 선언부에 exment tostring 가 암묵적으로 붙어 있단걸 기억
public class Member implements Cloneable{
    public String name;
    public int age;
    public int[] scores;
    public Car car;

    public Member(String name, int age, int[] scores, Car car){
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override 
    protected Object clone() throws CloneNotSupportedException{
        //super을 해주는 이유 위에서 클래스는 기본적으로 tostring를 상속받고있기때문에
        //super.clone를 해주는거다
        //아래는 얕은 복사를 해서 name, age를 복제한다.
        Member cloned = (Member) super.clone();
        //scores를 복제하는 부분 배열을 복제하는거라 copyOf 를사용한다.
        //다른 배열복제 코드를 사용하여도 상관없다. 다른거로는 for문으로 하나하나 돌리는방법도있다.
        cloned.scores = Arrays.copyOf(this.scores,this.scores.length);
        // car 객체를 복제한다.
        cloned.car = new Car(this.car.model);
        // 깊은 복제된 member 객체를 리턴해준다.
        return cloned;
    }

    public Member getMember(){
        Member cloned = null;
        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }
}
