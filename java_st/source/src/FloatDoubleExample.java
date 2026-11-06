public class FloatDoubleExample {
    public static void main(String[] args) {
        double var1 = 3.14;
        //float var2 = 3.14; 컴파일 에러가 난다.
        float var3=3.14F;

        // 정밀도 테스트
        //double는 소숫점 16재짜리까지 원본을 유지한다.
        //float는 소숫점 7재짜리까지 원본을 유지해서 보여준다
        double var4 = 0.123456789123456544123;
        float var5 = 0.1234567891789123456F;

        System.out.println("var1: " + var1);
        System.out.println("var2: " + var3);
        System.out.println("var4: " + var4);
        System.out.println("var5: " + var5);
    }
}
