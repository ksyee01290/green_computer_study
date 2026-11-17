package study;

public class Test1 {
    public static void main(String[] args) {
        // 아래의 예시대로라면 T는 String 이되고 K는 Integer이 된다
        // 이때 주의해야할점은 파라미터로 명시할수 있는것은 참조타입 밖에 올수 없다.
        //즉 int,double,char 같은 primitive type 는 올수없다는소리다.
        //그래서 이와같은 형들은 integer,Double 같은 Wrapper Type 으로 쓴느이유가 바로 아래와같은 이유이다.
        Nam<String, Integer> a = new Nam<String, Integer>();
        //바꿔말하면 잠조타입이 올수있다는것은 사용자가 정의한 클래스도 타입으로 올수있다는소리다.
        ClassName<Stud> b = new ClassName<Stud>();
        
    }
}
