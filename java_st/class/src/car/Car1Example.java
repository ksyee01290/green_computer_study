package car;
public class Car1Example {
    public static void main(String[] args) {
        Car1 myCar =new Car1();

        // 여기부분에 외부값을 넣는다.
        myCar.setGas(5);

        boolean gasState = myCar.isLeftGas();
        if(gasState){
            System.out.println("출발합니다.");
            myCar.run();
        }

        if(myCar.isLeftGas()){
            //설계상 이부분은 출력될일이 없어보인다.
            System.out.println("gas를 주입할 필요가 없습니다.");
        }else{
            System.out.println("gas를 주입하세요.");
        }
    }
}
