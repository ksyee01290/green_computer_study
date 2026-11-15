package student;

public class School {
    public static void main(String[] args) {
        Student student = new Student("근원", 85);
        Student student1 = new Student("지민", 92);

        student.printInfo();
        student1.printInfo();
    }
}
