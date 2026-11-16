package string;

import java.util.*;

public class ToStringExample2 {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2,"이름이 없습니다."));
        
        // null 이 있으면 옆에 예시 이름이 없습니다 가 출력된다
        // null 이없고 값이 있으면 옆에 예시는 무시되고 넣어져있는 값이 출력된다.
    }
}
