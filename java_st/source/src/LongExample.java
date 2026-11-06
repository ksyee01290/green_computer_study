public class LongExample {
    public static void main(String[] args) {
        long var1 = 10;
        long var2 = 20L;
        //long var3 = 1000000000000; 컴파일에러남 접미사 없으면 4바이트로처리
        long var4 = 1000000000000L;

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var4);
    }
}
