public class ThrowsExample {
    public static void main(String[] args) {
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다.");
        }
    }

    //throws 가장 중요하다 메서드의 에러를 떠넘긴다는 소리
    //메인이 아닌 다른 메소드에서 처리하지 않은 예외를 호출한쪽으로 떠넘긴다는 소리다.
    public static void findClass() throws ClassNotFoundException{
        Class clazz = Class.forName("java.lang.String2");
    }
}
