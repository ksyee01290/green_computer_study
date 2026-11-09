public class OverflowExample {
    public static void main(String[] args) {
        // int x = 1000000;
        // int y = 1000000;
        // int z = x*y;
        // System.out.println(z);

        long x = 1000000;
        long y = 1000000;
        long z = x*y; // 위의 x와 y는 int로 설정한뒤 마지막 출력만 long로 해도 상관없다.
        System.out.println(z);
    }
}
