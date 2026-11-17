package wrapper;

public class BoxingUnBoxing {
    public static void main(String[] args) {
        // 각 포장클래스마다 가지고 있는 클래스 호출
        // BoxingUnBoxingExample();
        // AutoBoxingUnBoxingExample();
        // StringToPrimitiveValueExample();
        ValueCompareExample();
    }

    public static void BoxingUnBoxingExample(){
        Integer obj1 = new Integer(100);
        Integer obj2 = new Integer("200");
        Integer obj3 = Integer.valueOf("300");

        int value1 = obj1.intValue();
        int value2 = obj2.intValue();
        int value3 = obj3.intValue();

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }

    public static void AutoBoxingUnBoxingExample(){
        //자동 Boxing 가 된다
        Integer obj = 100;
        System.out.println("value: "+obj.intValue());
        //대입시 자동으로 unBoxing
        int value = obj;
        System.out.println("vlaue: "+value);
        //연산시 자동 unBoxing
        int result = obj + 100;
        System.out.println("result: "+result);
    }

    public static void StringToPrimitiveValueExample(){
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: "+value1);
        System.out.println("value2: "+value2);
        System.out.println("value3: "+value3);
    }

    public static void ValueCompareExample(){
        System.out.println("[-128~127 초과값일 경우]");
        //Integer 범위값을 초과하면 컴퓨터에서 맘대로 새로운 객체를 만들어버린다.
        Integer obj1 = 300; // 0xe
        Integer obj2 = 300; // 0x15
        //아래와 같이 동등비교연산을 하면 제대로 된값이 나오지 않는다.사용하지않는게좋다
        System.out.println("==결과: " +(obj1 == obj2));
        System.out.println("언박싱후 ==결과: "+(obj1.intValue() == obj2.intValue()));
        System.out.println("equals() 결과: "+obj1.equals(obj2));
        System.out.println();

        System.out.println("[-128~127 범위값일 경우]");
        Integer obj3 = 10;
        Integer obj4 = 10;
        System.out.println("==결과: "+(obj3 == obj4));
        System.out.println("언박싱후 ==결과: "+(obj3.intValue() == obj4.intValue()));
        System.out.println("equals() 결과: "+obj3.equals(obj4));
    }
}
