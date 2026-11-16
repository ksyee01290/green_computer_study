package nullo;
import java.util.*;

public class NullExample {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = "hello";

        //이와같이 objects를 사용해서 isNull을 판별할수있다. 
        //값이 널이면 트루를 반환하고 널이 아니면 펄스를 반환한다.
        //이렇게 변수를 비교할수도 있지만 객체자체를 null인지 아닌지 판가름할수있다.
        
        System.out.println(Objects.isNull(str1));
        System.out.println(Objects.isNull(str2));
    }
}
