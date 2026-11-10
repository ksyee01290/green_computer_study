import java.util.*;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");
        boolean run = true;
        int speed = 0;

        runs(sc, run, speed);
    }
    public static void runs(Scanner sc, boolean run, int speed){
        while(run){
            System.out.println("---------------------------");
            System.out.println("1.증속 | 2.감속 | 3.중지");
            System.out.println("---------------------------");
            System.out.println("선택: ");
            
            String strNum = sc.nextLine();

            if(strNum.equals("1")){
                speed++;
                System.out.println("현재 속도 = "+speed);
            }else if(strNum.equals("2")){
                speed--;
                System.out.println("현재 속도= " + speed);
            }else if(strNum.equals("3")){
                run = false;
            }
        }
    }
}
