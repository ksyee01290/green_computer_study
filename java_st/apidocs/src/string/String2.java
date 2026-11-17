package string;
import java.util.*;

public class String2 {
    public static void main(String[] args) {
        // StringSplitExample();
        // StringTokenizerExample();
        StringBuilderExample();
    }

    public static void StringToLowerUpperCaseExample(){
        //문자열 대소문자 변환
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";

        System.out.println(str1.equals(str2));

        //toLowerCase는 대문자를 소문자로 바꿔주는메서드
        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        System.out.println(lowerStr1.equals(lowerStr2));
        //Ignore는 무시메서드이다 
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    public static void StringTrimExample(){
        //문자열 공백제거
        String tel1 = "  02";
        String tel2 = "123   ";
        String tel3 = "    1234    ";

        //trim 은 문자열 앞뒤의 공백을 없애주는 역할을한다.
        //글자사이의 공백은 없애주지않는다.
        String tel = tel1.trim() + tel2.trim() + tel3.trim();
        System.out.println(tel);
    }

    public static void StringValueOfExample(){
        //문자열 값변환
        //기본타입의 값을 문자열로 변환하고싶을때 valueOf를 사용해서 변환할수있다.
        String str1 = String.valueOf(10);
        String str2 = String.valueOf(10.5);
        String str3 = String.valueOf(true);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void StringSplitExample(){
        //문자열 분리
        //split를 사용할때 임의의 문자 혹은 특수문자를 기준으로 삼을수있다. 여러
        //특정문자를 분리할때는 OR(|) 이것을 꼭사용해주어야한다. 분리한뒤 split에
        //들어있던 문자는 사라진다.
        String text = "홍길동&이수홍,박연수,김자바-최태호";
        String[] names = text.split("&|,|-");

        //뉴포문
        for(String name : names){
            System.out.println(name);
        }
        //올드포문
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }
    }

    public static void StringTokenizerExample(){
        //문자열 분리 2
        //두번째 코드를 기억하자 종종 쓰인다.
        //토큰으로 그룹진거라 다른곳에서 별도의 사용은 불가능하다.
        String text = "홍길동/이수홍/박연수";

        StringTokenizer st = new StringTokenizer(text, "/");
        int countTokens = st.countTokens();
        for(int i=0;i<countTokens;i++){
            String token = st.nextToken();
            System.out.println(token);
        }
        System.out.println();

        st = new StringTokenizer(text,"/");
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            System.out.println(token);
        }

    }

    public static void StringBuilderExample(){
        //문자열 결합
        //스트링 빌더는 사용하면 좋다.
        StringBuilder sb = new StringBuilder();
        sb.append("Java  ");
        sb.append("Program Study");
        System.out.println(sb.toString());

        sb.insert(4,"2");
        System.out.println(sb.toString());

        sb.setCharAt(4,'6');
        System.out.println(sb.toString());

        sb.replace(6,13,"Book");
        System.out.println(sb.toString());

        sb.delete(4,5);
        System.out.println(sb.toString());

        int length = sb.length();
        System.out.println("총문자수: "+length);

        String result = sb.toString();
        System.out.println(result);
    }

    public static void PatternExample(){
        //문자열 정규 표현식

    }
}
