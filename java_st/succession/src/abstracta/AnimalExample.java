package abstracta;

public class AnimalExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();
        System.out.println("-----");

        //번수의 자동 타입변환
        Animal animal = null;
        animal = new Dog();
        animal.sound();
        animal = new Cat();
        animal.sound();
        System.out.println("-----");

        // 아래와같이 메개변수의 다형성을 이용한 매서드로 출력가능
        // 매개변수의 자동타입변환
        animalSound(new Dog());
        animalSound(new Cat());
    }
    public static void animalSound(Animal animal){
        animal.sound();
    }
}
