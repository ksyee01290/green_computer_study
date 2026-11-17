package string;

import java.io.UnsupportedEncodingException;

public class String1 {
    public static void main(String[] args) {
        //StringEqualst();
        //StringCharAtExample();
        StringGetBytesExample();
        StringIndexOfExample();
        StringReplaceExample();
    }

    public static void StringReplaceExample(){
        //String객체의 replace는 값변경이 되지않는다 그래서 새로운 객체를 따로만들어서
        //변경지정을 해줘야 가능하다. string 만 값변경 불가 다른건 가능
        String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
        String newStr = oldStr.replace("자바","JAVA");

        System.out.println(oldStr);
        System.out.println(newStr);
    }

    public static void StringIndexOfExample(){
        //indexof 이것은 특정문자열이 포함되어 있는지에 따라 코드를달리할수있다.
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);

        if(subject.indexOf("자바") != -1){
            System.out.println("자바와 관련된 책");
        } else {
            System.out.println("자바와 관련없는 책");
        }
    }

    public static void StringGetBytesExample(){
        String str = "안녕하세요";

        byte[] bytes1 = str.getBytes();
        System.out.println("bytes1.length: "+bytes1.length);
        String str1 = new String(bytes1);
        System.out.println("bytes1->String: "+str1);

        try {
            //2바이트를 할당받지만 잘쓰이진 않는다.
            byte[] bytes2 = str.getBytes("EUC-KR");
            System.out.println("bytes2.length: "+bytes2.length);
            String str2 = new String(bytes2, "EUC-KR");
            System.out.println("bytes2->String: "+str2);

            //utf-8은 3바이트를 할당받는다 한국어포함해서 사용하려면 무조건이거
            //하지만 조금 느리다고한다.
            byte[] bytes3 = str.getBytes("UTF-8");
            System.out.println("bytes3.length: "+bytes3.length);
            String str3 = new String(bytes3, "UTF-8");
            System.out.println("bytes3->String: "+str3);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void StringEqualst(){
        String strVar1 = new String("신민철");
        String strVar2 = "신민철";

        //씬비교
        if(strVar1 == strVar2){
            System.out.println("같은 String 객체를 참조");
        } else{
            System.out.println("다른 String 객체를 참조");
        }

        //딥비교
        if(strVar1.equals(strVar2)){
            System.out.println("같은 문자열을 가짐");
        } else{
            System.out.println("다른 문자열을 가짐");
        }
    }

    public static void StringCharAtExample(){
        String ssn = "010624-1230123";
        char sex = ssn.charAt(7);
        switch (sex){
            case '1':
            case '3':
                System.out.println("남자 입니다.");
                break;
            
            case '2':
            case '4':
                System.out.println("여자 입니다.");
                break;
        }
    }
}
