import java.util.*;
public class TestExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");
        Test obj1 = Test.getInstance();
        Test obj2 = Test.getInstance();

        while(true){
            System.out.println("=========================");
            System.out.println("은행정보이용법");
            System.out.println("1.입금 | 2.출금 | 3.잔액 | 4.종료");
            System.out.println("=========================");
            String num = sc.nextLine();

            if(num.equals("1")){
                System.out.println("입금할 금액을 입력: ");
                int money = Integer.parseInt(sc.nextLine());
                System.out.println(money+"원이 입력되었습니다.");
                obj1.deposit(money);
            }else if(num.equals("2")){
                System.out.println("출금할 금액을 입력: ");
                int money = Integer.parseInt(sc.nextLine());
                obj1.withdraw(money);
                obj1.printInfo();
            }else if(num.equals("3")){
                obj2.printInfo();
            }else if(num.equals("4")){
                break;
            }

        }
        

    }
}