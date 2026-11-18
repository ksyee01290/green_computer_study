package study;

class ClassName1<E>{
    private E element;

    void set(E element){
        this.element = element;
    }

    E get(){
        return element;
    }

    <T> T genericMethod(T o){
        return o;
    }
}

public class Test3 {
    public static void main(String[] args) {
        
        ClassName1<String> a = new ClassName1<String>();
        ClassName1<Integer> b = new ClassName1<Integer>();

        a.set("10");
        b.set(10);

        System.out.println("a data: "+a.get());
        // 반환된 변수의 타입 출력
        System.out.println("a E type: "+a.get().getClass().getName());
        System.out.println();

        System.out.println("b data: "+b.get());
        // 반환된 변수의 타입 출력
        System.out.println("b E type: "+b.get().getClass().getName());
        System.out.println();

        //제네릭 메소드 Integer
        System.out.println("<T> returnType : "+b.genericMethod(3).getClass().getName());
        //제네릭 메소드 String
        System.out.println("<T> returnType : "+a.genericMethod("abcd").getClass().getName());
        //제네릭 return class b
        System.out.println("<T> returnType : "+a.genericMethod(b).getClass().getName());
    }
}
