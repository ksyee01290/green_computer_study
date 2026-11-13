package car;

public class CarExample {
    public static void main(String[] args) {
        Car car = new Car();
        //간략화 가능 
        
        car.run();
        car.frontLeftTire = new KumhoTire();
        car.frontRightTire = new KumhoTire();
        
        car.run();
        
    }
}
