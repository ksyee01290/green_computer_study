package inputoutput;

public class Money {
    private int balance = 0;
    private int bank=10000000;

    private static Money singleton = new Money();
    private Money(){}

    static Money getInstance(){
        return singleton;
    }
    //조회하기
    public void sech(){
        System.out.println("현재잔액: "+balance);
    }

    //입금하기
    public void deposit(int money){
        balance +=money;
    }

    //출금하기
    public void withdraw(int money){
        if(balance >= money){
            balance -= money;
        } else{
            System.out.println("잔액이 부족합니다. 돈버세요");
        }
    }

    //알바하기
    public void work(){
        double random = Math.random();
        int ran = (int)(random * 100000) +1000;
        System.out.println("일을 열심히 했나?");
        System.out.println("급여는 복불복");
        balance += ran;
        System.out.println("오늘 일당은"+ran+"이다");
    }
}
