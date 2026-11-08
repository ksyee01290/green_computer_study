package java_st.test;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "MS949");
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("근원",31,98));
        students.add(new Student("철수",33,76));
        students.add(new Student("곽팔",45,54));

        for(int i=0;i<students.size();i++){
            Student student = students.get(i);
            System.out.printf("이름: %s, 나이: %d, 점수: %d\n",student.name,student.age,student.score);
        }

        findStudent(students,sc);
        
    }
    public static void findStudent(ArrayList<Student> students, Scanner sc){
        System.out.println("이름을 입력해주세요");
        String scan = sc.nextLine();
        boolean found = false;

        for(int i=0;i<students.size();i++){
            if(students.get(i).name.equals(scan)){
                students.get(i).printInfo();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("학생 못찾음");
        }
    }

}

class Student{
    String name;
    int age;
    int score;

    public Student(String name, int age, int score){
        this.name=name;
        this.age=age;
        this.score=score;
    }

    public void printInfo(){
        System.out.printf("이름 : %s, 나이 : %d, 점수 : %d\n",name,age,score);
    }
}
