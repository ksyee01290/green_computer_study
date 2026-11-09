import java.util.*;

public class Test {
    public static int scn(Scanner sc,String mas){
        System.out.println(mas);
        int num = Integer.parseInt(sc.nextLine());
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");

        while(true) {
            System.out.println("연산자 입력:");
            String data = sc.nextLine();
            int num1 = scn(sc,"첫번째입력");
            int num2 = scn(sc,"두번째입력");

            if(data.equals("+")){
                int result = num1+num2;
                System.out.println("x+y = "+result);

            }else if(data.equals("-")){
                int result = num1-num2;
                System.out.println("x-y = "+result);
                
            }else if(data.equals("*")){
                int result = num1*num2;
                System.out.println("x*y = "+result);

            }else if(data.equals("/")){
                if(num2 == 0){
                    System.out.println("두번째값은 0이 될수없다.");
                }
                int result = num1/num2;
                System.out.println("x/y = "+result);
            }else{
                System.out.println("잘못 입력하셧습니다.");
            }
            System.out.println();
        }
    }
}
