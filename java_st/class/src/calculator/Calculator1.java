package calculator;
public class Calculator1 {

    public int plus(int x, int y){
        int result =x+y;
        return result;
    }
    public double avg(int x, int y){
        double sum = plus(x,y);
        double result = sum / 2;
        return result;
    }
    //메소드 오버로딩에 관련된 부분
    public void execute(){
        double result = avg(7,10);
        println("실행결과: "+result);
    }
    public void execute(int x,int y){
        double result = avg(x,y);
        println("실행결과: "+result);
    }
    public void execute(int x, int y, int z){
        int result = x+y+z;
        println("실행결과: "+result);
    }
    //-------------------------------------
    public void println(String message){
        System.out.println(message);
    }
}
