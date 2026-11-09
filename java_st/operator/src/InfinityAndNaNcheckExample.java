import java.util.*;

public class InfinityAndNaNcheckExample {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in,"MS949")) {
            System.out.println("y값을 입력: ");
            int x = 5;
            double y = Double.parseDouble(sc.nextLine());

            double z = x/y;

            System.out.println(Double.isInfinite(z));
            System.out.println(Double.isNaN(z));

            //잘못된 코드
            System.out.println(z+2);

            //알맞은 코드
            if(Double.isInfinite(z) || Double.isNaN(z)){
                System.out.println("값 산출 불가");
            } else{
                System.out.println(z+2);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
