package drive;

public class VehicleExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        //vehicle.checkFare(); 이렇게 호출은 불가능하다.

        Bus bus = (Bus) vehicle;

        bus.run();
        bus.checkFare();
    }
}
