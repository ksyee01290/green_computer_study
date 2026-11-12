package car;
public class Car4Example {
    public static void main(String[] args) {
        Car4 myCar = new Car4();

        myCar.setSpeed(-50);
        System.out.println("현재 속도: "+myCar.getSpeed());

        myCar.setSpeed(60);

        if(!myCar.isStop()){
            myCar.setStop(true);
        }

        System.out.println("현재 속도: "+myCar.getSpeed());
    }
}
