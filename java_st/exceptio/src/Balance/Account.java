package Balance;

public class Account {
    private long balance;

    public Account(){}

    public long getBalance(){
        return balance;
    }

    public void deposit(int money){
        balance += money;
    }

    // 여기서 throws 는 호출한곳에서 예외처리를 시키도록 떠넘기는것이고
    // throw 는 임의로 만든 Balance 라는 클래스를 예외처리로 지정하겠다는 의미
    // 여기서 Balance는 내가직접 만든 예외처리 클래스이다 즉 사용자지정 예외란소리
    public void withdraw(int money) throws BalanceInsufficientException{
        if(balance < money){
            throw new BalanceInsufficientException("잔고부족: "+(money-balance)+" 모자람");
        }
        balance -= money;
    }
}
