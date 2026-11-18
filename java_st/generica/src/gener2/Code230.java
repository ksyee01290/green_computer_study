package gener2;

public class Code230 {
    public static void main(String[] args) {
        //제네릭 클래스에 매개변수 두개가 선언되었으면 아래와같이 형두 두개를  추가해야한다.
        //그럼 몇개까지 가능할까?
        TwoGenerics<Integer, String> x = new TwoGenerics<Integer,String>(100, "hello");

        x.showGenericType();
        int y = x.getData1();
        System.out.println("value: "+y);
        String z = x.getData2();
        System.out.println("value: "+z);
    }
}
