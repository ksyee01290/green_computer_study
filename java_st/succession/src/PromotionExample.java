class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class PromotionExample {
    public static void main(String[] args) {
        // B b = new B();
        // C c = new C();
        // D d = new D();
        // E e = new E();

        A a1 = new B();
        A a2 = new C();
        A a3 = new D();
        A a4 = new E();

        // 아래 관계는 부분적 사용가능인대 부분적의 의미를 잘모르겠다.
        // 오버라이드 한부분은 사용가능한듯하다
        B b1 = new D();
        C c1 = new E();

        //상속관계에 전혀 포함되어 있지 않는 부분이라 사용불가
        //B b3 = e;
        //C c2 = d;
    }
}
