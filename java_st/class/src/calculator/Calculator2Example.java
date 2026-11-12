package calculator;
public class Calculator2Example {
    public static void main(String[] args) {
        
        Calculator2 tesCal = new Calculator2();

        int res1 = tesCal.plus(10,4);
        System.out.println("사용은된다 :"+res1);

        double result1 = 10*10*Calculator2.pi;
        int result2 = Calculator2.plus(10,5);
        int result3 = Calculator2.minus(10,5);

        System.out.println("result1 : "+result1);
        System.out.println("result2 : "+result2);
        System.out.println("result3 : "+result3);
    }
}
