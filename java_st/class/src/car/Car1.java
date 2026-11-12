package car;
public class Car1 {
    int gas;

    //setter 을사용 하려면 set뒤에 첫문자는 무조건 대문자로 써야한다
    // set는 외부로부터 값을 받아 필드에 값을넣는방식
    // 생성자와 비교하면 초기화라는 부분이다르다 생성자는 초기화를하지만
    // 아래와 같은상황에서는 값 대입이라 판단한다.
    public void setGas(int gas){
        this.gas = gas;
    }

    // boolean 매서드를 사용하려면 매서드이름처음에 is를 꼭붙여써야한다.
    // 관습적인거라 is다음에 첫문자는 꼭 대문자로
    public boolean isLeftGas(){
        if(gas==0){
            System.out.println("gas가 없습니다.");
            return false;
        }
        System.out.println("gas가 있습니다.");
        return true;
    }

    public void run(){
        while(true){
            if(gas>0){
                System.out.println("달립니다.(gas잔량: "+gas+")");
                gas -= 1;
            }else{
                System.out.println("멈춥니다.(gas잔량: "+gas+")");
                return;
            }
        }
    }
}
