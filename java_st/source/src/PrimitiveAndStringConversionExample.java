public class PrimitiveAndStringConversionExample {
    public static void main(String[] args) {
        //parseInt,Double,Boolean 은 기억해두자
        int value1 = Integer.parseInt("10");
        double value2 = Double.parseDouble("3.14");
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: "+value1);
        System.out.println("value2: "+value2);
        System.out.println("value3: "+value3);

        //Integer.toString(n) n즉 정수를 문자열로 바꾸어준다.
        //String.valueOf(n) 이거는 일반데이터를 특정 문자열로 변환해주는 역할
        //String.valueOf(n) 은 불리언 데이터도 문자열로 반환해준다.
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(3.14);
        String str3 = String.valueOf(true);

        System.out.println("str1: "+str1);
        System.out.println("str2: "+str2);
        System.out.println("str3: "+str3);

    }
}
