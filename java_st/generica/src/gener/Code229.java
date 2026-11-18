package gener;

import java.util.ArrayList;

public class Code229 {
    public static void main(String[] args) {
        
        //제네릭사용법 : 클래스명<타입> 객체명 = new 클래스명<타입>(매개변수);

        // 제네릭은 호환성이 좋다 만약 어떤 값이 들어올지 모르는 상황이면
        // <T> 이렇게 제네릭을 설정한뒤에 메인에서 Integer나 String 를 불러오면서
        // 타입을 자유롭게 변환해서 저장이 가능하다.
        
        ArrayList<String> a = new ArrayList<>();

        Data<Integer> d1 = new Data<Integer>(100);
        System.out.println(d1.getObj());
        d1.showType();

        Data<String> d2 = new Data<String>("JAVA");
        System.out.println(d2.getObj());
        d2.showType();
    }
}
