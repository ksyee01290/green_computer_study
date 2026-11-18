package inputoutput;

import java.util.Scanner;

public class SystemInExample {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in,"MS949");
        Money obj = Money.getInstance();

        while(true){
            try {
                System.out.println("==========================");
                System.out.println("== 메뉴 ==");
                System.out.println("1. 예금 조회");
                System.out.println("2. 예금 출금");
                System.out.println("3. 예금 입금");
                System.out.println("4. 알바 하기");
                System.out.println("5. 종료하기");
                System.out.println("메뉴를 선택하세요");
                System.out.println("==========================");
                String num = sc.nextLine();
                if(num.equals("1")){
                    obj.sech();

                } else if(num.equals("2")){
                    System.out.println("출금할 금액: ");
                    int money = Integer.parseInt(sc.nextLine());
                    obj.withdraw(money);

                } else if(num.equals("3")){
                    System.out.println("입금할 금액: ");
                    int money = Integer.parseInt(sc.nextLine());
                    System.out.println(money+"원이 입금되었습니다.");
                    obj.deposit(money);

                } else if(num.equals("4")){
                    obj.work();

                } else if(num.equals("5")){
                    break;

                } else{
                    System.out.println("잘못 입력하셧습니다.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                System.out.println("다시 실행하세요");
            }
        }
    }
}
