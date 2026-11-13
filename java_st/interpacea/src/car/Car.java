package car;

public class Car {
    Tire frontLeftTire = new HankookTire();
    Tire frontRightTire = new HankookTire();
    Tire backLeftTire = new HankookTire();
    Tire backRightTire = new HankookTire();

    Tire[] tires ={
        frontLeftTire,frontRightTire,backLeftTire,backRightTire
    };

    void run(){
        // for(int i=0;i<tires.length;i++){
        //     tires[i].roll();
        // }
        frontLeftTire.roll();
        frontRightTire.roll();
        backLeftTire.roll();
        backRightTire.roll();
    }

}
