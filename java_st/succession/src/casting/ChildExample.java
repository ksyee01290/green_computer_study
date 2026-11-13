package casting;

public class ChildExample {
    public static void main(String[] args) {
        // 자식 child를 부모클래스인 parent로 객체 생성하는부분
        Parent parent = new Child();

        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        //아래와같이 자식Child를 부모인 parent로 객체를 생성했을때 아래와같이 자식 클래스
        //에있는 메서드나 변수에는 접근 수정을 못한다.
        // parent.field2 = "data2";
        // parent.method3();

        // 부모형으로의 형변환을 강제로 할수있다.
        // 자식에서 부모형으로만 강제로 가능 나머지는 불가능하다.
        // 아래와 같이 parent로 객체가 생성되어있는 상태에서 강제 형변환이 가능하다.
        Child child = (Child) parent;
        child.field2 = "yyy";
        child.method3();
    }
}
