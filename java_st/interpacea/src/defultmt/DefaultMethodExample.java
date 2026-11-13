package defultmt;

public class DefaultMethodExample {
    public static void main(String[] args) {
        Myinterface mi1 = new MyClassA();
        mi1.method1();
        mi1.method2();

        Myinterface mi2 = new MyClassB();
        mi2.method1();
        mi2.method2();
    }
}
