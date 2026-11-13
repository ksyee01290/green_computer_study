package instance;

public class InstanceofExample {
    public static void method1(Parent parent){
        if(parent instanceof Child){
            Child child = (Child) parent;
            System.out.println("method1 - Child로 변환 성공: "+child);
        } else {
            System.out.println("method1 - Child로 변환되지 않음");
        }
    }
    public static void method2(Parent parent){
        //아래와 같이 instanceof로 물어보지않고 바로 형변환하면
        // 실행은되지만 에러가 뜬다.
        // Child child = (Child) parent;
        // System.out.println("method2 - Child 로 변환 성공: "+child);
        
        //아래와같이 instanceof로 물어보면 else를 반환해주어
        //실행도 되고 에로는 안뜬다.
        if(parent instanceof Child){
            Child child = (Child) parent;
            System.out.println("method2 - Child 로 변환 성공: "+child);
        } else {
            System.out.println("method2 - Child로 변환되지 않음");
        }
    }

    public static void main(String[] args) {
        Parent parentA = new Child();
        method1(parentA);
        method2(parentA);

        Parent parentB = new Parent();
        method1(parentB);
        method2(parentB);
    }
}
