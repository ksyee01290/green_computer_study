public class Test {
    private int balance=0;
    private int bank=100000000;

    private static Test singleton = new Test();
    private Test(){
    }

    static Test getInstance(){
        return singleton;
    }
    //입금부분
    public void deposit(int money){
        balance +=money;
    }
    //출금부분
    public void withdraw(int money){
        if(balance >= money){
            balance -=money;
        }else{
            System.out.println("잔액이 부족합니다 돈버세요");
        }
    }
    //일하는부분
    public void work(){
        double random = Math.random();
        int ran = (int)(random * 100000) +10000;
        System.out.println("일을 열심히했나?");
        System.out.println("하지만 급여는 복불복이다.");
        balance +=ran;
        System.out.println("오늘 일당은"+ran+"정도이려나");
    }

    public void printInfo(){
        System.out.println("현재잔액: "+balance);
    }
}
