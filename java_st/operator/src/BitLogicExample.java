public class BitLogicExample {
    public static void main(String[] args) {
        
        System.out.println("3 & 2 = " + (3 & 2));
        System.out.println("3 | 2 = " + (3 | 2));
        System.out.println("3 ^ 2 = " + (3 ^ 2));
        System.out.println("~3 = " + (~3));
        System.out.println("---------------------------");

        byte receiveData = -10;

        // 비트 논리곱 연산으로 unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);
        
        // 자바 api를 이용해서 unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println(btest);
    }
}
