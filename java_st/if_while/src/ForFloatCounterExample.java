public class ForFloatCounterExample {
    public static void main(String[] args) {
        //일반컴퓨터에서의 자바 실수표현은 최소값과 최대값에 갈수록 부정확해진다.
        for(float x=0.1f; x<=1.0f; x+=0.1f){
            System.out.println(x);
        }
    }
}
