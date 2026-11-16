package hashcode;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        // a 가 A이거나 A를 상속받는 클래스라면 true를 리턴
        System.out.println(a instanceof A);
        // true 를 리턴
        System.out.println(b instanceof A);
        // A를 상속받았기떄문에 true 를 리턴한다.
        System.out.println(a instanceof B);
        // false 를 리턴 a와 b는 상속관계이지만 a가 부모객체이기 때문이다.
        System.out.println(b instanceof B);
        // true 를 리턴한다.
    }
}

class A{}
class B extends A {}

