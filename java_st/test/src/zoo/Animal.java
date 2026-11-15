package zoo;

public class Animal {
    String name;

    public Animal(String name){
        this.name=name;
    }

    public void sound(){
        System.out.println(name);
    }
}
