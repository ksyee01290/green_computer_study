package study;

class ClassName2<E>{
    private E element;

    void set(E element){
        this.element = element;
    }
    
    E get(){
        return element;
    }
}

public class Test2 {
    public static void main(String[] args) {
        ClassName2<String> a = new ClassName2<String>();
        ClassName2<Integer> b = new ClassName2<Integer>();

        a.set("10");
        b.set(10);

        System.out.println("a data: "+a.get());
        // 반환된 변수의 타입 출력
        System.out.println("a E type: "+a.get().getClass().getName());

        System.out.println();

        System.out.println("b data: "+b.get());
        // 반환된 변수의 타입 출력
        System.out.println("b E type: "+b.get().getClass().getName());
    }
}