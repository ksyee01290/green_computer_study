package calculator;
public class Calculator0Example {
    public static void main(String[] args) {
        Calculator0 myCalc = new Calculator0();
        myCalc.powerOn();

        int result1 = myCalc.plus(5,6);
        System.out.println("result1: "+result1);

        byte x = 10;
        byte y = 4;
        double result2 = myCalc.divide(x,y);
        System.out.println("result2: "+result2);

        myCalc.powerOff();
    }
}
