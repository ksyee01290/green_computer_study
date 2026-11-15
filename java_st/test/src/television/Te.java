package television;

public class Te {
    public static void main(String[] args) {
        RemoteControl re = new Television();
        re.turnOn();
        re = new Radio();
        re.turnOn();
    }
}
