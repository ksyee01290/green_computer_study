public class ArrayCreateByValueListExample2 {
    public static void main(String[] args) {
        int[] scores = new int[]{83,90,87};
        int sum1 =0;
        for(int i=0;i<scores.length;i++){
            sum1 += scores[i];
        }
        System.out.println("총합:" + sum1);

        //두번째 방법으로는 거의 안쓴다.
        int sum2 = add(new int[]{83,90,87});
        //이런식으로는 종종쓰일지도
        int sum3 = add(scores);
        System.out.println("총합:"+sum2);
        System.out.println("총합:"+sum3);
        System.out.println();
    }
    public static int add(int[] scores){
        int sum = 0;
        for(int i=0;i<3;i++){
            sum += scores[i];
        }
        return sum;
    }
}
