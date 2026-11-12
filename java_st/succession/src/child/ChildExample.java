package child;
public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        //parent.method3(); 이렇게 쓰면 호출이 불가능하다
        //Parent 를 메인으로 잡으면 override 한 메서드는 사용이 가능하지만
        //지금 method3 를보면 child에 만들어져있다. 이경우에는
        // Parent에 method3가 없기때문에 사용이 불가능하다.
        // 즉 부모를 메인으로 잡을때 자식이였던 애들은 오버라이딩한 겨우에만
        //사용이가능 자식들이 자체적으로 만든 메서드는 사용불가
    }
}
