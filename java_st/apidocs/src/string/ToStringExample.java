package string;

import java.util.*;

public class ToStringExample {
    public static void main(String[] args) {
        // Object는 필드가 없어서 주소값을 출력해준다.
        Object obj1 = new Object();
        // Date는 필드가 있음
        Date obj2 = new Date();

        System.out.println(obj1.toString());
        System.out.println(obj2);
    }   

}
