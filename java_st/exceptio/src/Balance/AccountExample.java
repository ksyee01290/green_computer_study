package Balance;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(10000);
        System.out.println("예금액: "+account.getBalance());

        try{
            account.withdraw(30000);
        } catch(BalanceInsufficientException e){
            String message = e.getMessage();
            System.out.println(message);
            System.out.println();
            //e.printStackTrace(); 보안상 이부분은 숨기는게 좋다
            //printStackTrace() 예외 발생코드 추적한 내용을 콘솔에 모두 출력해준다
            // 테스트할때 오류찾는것에대해 유용하게 사용가능
        }
    }
}
