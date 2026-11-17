package string;

import java.io.IOException;

public class KeyboardToStringExample {
    public static void main(String[] args) throws IOException{
        byte[] bytes = new byte[100];

        System.out.print("입력");
        //여기부분의 리드 는 ioException 으로 예외처리를 넘길수있다.
        int readByteNo = System.in.read(bytes);

        // 맨뒤에 -2를 하는이유는 바이트 배열에 문자를 집어 넣을때 마무리로
        // 엔터를 치면 맨마지막 배열에 널값이 자동으로 들어가므로 유의 해서 봐야한다.
        String str = new String(bytes, 0, readByteNo-2);
        System.out.println(str);
        System.out.println();
    }
}
