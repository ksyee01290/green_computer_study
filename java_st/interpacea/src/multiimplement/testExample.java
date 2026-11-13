package multiimplement;

public class testExample {
    public static void main(String[] args) {
        RemoteControl rc;
        rc = new Television();
        rc.turnOn();
        rc.turnOff();

        rc = new SmartTelevision();
        rc.turnOn();
        rc.turnOff();
    }
}
