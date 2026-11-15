package zoo;

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("고양이");
        Dog dog = new Dog("강아지");

        dog.sound();
        cat.sound();
    }
}
