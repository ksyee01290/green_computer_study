public class CharOperationExample {
    public static void main(String[] args) {
        char c1 ='A' + 1;
        char c2 = 'A';
        //char c3 = c2 + 1; 컴파일 에러난다 여기서 c2는 int형으로 인식
        System.out.println("c1: "+c1);
        System.out.println("c2: "+c2);

    }
}
