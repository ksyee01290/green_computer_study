public class Test {
    private int balance=0;

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

    public void printInfo(){
        System.out.println("현재잔액: "+balance);
    }
}
