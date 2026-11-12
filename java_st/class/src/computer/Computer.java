package computer;
public class Computer {
    int sum1(int[] values){
        int sum = 0;
        for(int i=0;i<values.length;i++){
            sum += values[i];
        }
        return sum;
    }

    //아래는 가변변수이다 ... 이것이 배열 arr로 값이 들어간다.
    int sum2(int ... values){
        int sum = 0;
        for(int i=0;i<values.length;i++){
            sum += values[i];
        }
        return sum;
    }
}
