package student;
public class Student extends People{
    public int studentNo;

    public Student(String name, String ssn, int studentNo){
        //부모클래스에 생성자호출할때는 super을 사용해서 호출한다
        //부모클래스에 기본(매개변수가 없는) 생성자가 없다면 필수 작성
        //반드시 자식 생성자의 첫줄에 위치하여야 한다.
        //부모클래스에 생성자가 없다면 컴파일 오류
        super(name,ssn);
        this.studentNo = studentNo;
    }
}
