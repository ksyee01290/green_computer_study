package math_random;

import java.util.Arrays;
import java.util.Random;

public class Mrand {
    public static void main(String[] args) {
        // MathExample();
        RandomExample();
    }

    public static void MathExample(){
        int v1 = Math.abs(-5);
        double v2 = Math.abs(-3.14);
        System.out.println("v1="+v1);
        System.out.println("v2="+v2);

        double v3 = Math.ceil(5.3);
        double v4 = Math.ceil(-5.3);
        System.out.println("v3="+v3);
        System.out.println("v4="+v4);

        double v5 = Math.floor(5.3);
        double v6 = Math.floor(-5.3);
        System.out.println("v5="+v5);
        System.out.println("v6="+v6);

        int v7 = Math.max(5,9);
        double v8 = Math.max(5.3, 2.5);
        System.out.println("v7="+v7);
        System.out.println("v8="+v8);

        int v9 = Math.min(5,9);
        double v10 = Math.min(5.3,2.5);
        System.out.println("v9="+v9);
        System.out.println("v10="+v10);

        double v11 = Math.random();
        System.out.println("v11="+v11);

        double v12 = Math.rint(5.3);
        double v13 = Math.rint(5.7);
        System.out.println("v12="+v12);
        System.out.println("v13="+v13);

        long v14 = Math.round(5.3);
        long v15 = Math.round(5.7);
        System.out.println("v14="+v14);
        System.out.println("v15="+v15);

        double value = 12.3456;
        double temp1 = value * 100;
        long temp2 = Math.round(temp1);
        double v16 = temp2/100.0;
        System.out.println("v16="+v16);

    }

    public static void MathrandomExample(){
        int num = (int) (Math.random()*6)+1;
        System.out.println("주사위 눈: "+num);
    }

    public static void RandomExample(){
        //선택번호
        int[] selectNumber = new int[6];
        Random random = new Random(2);
        System.out.println("선택 번호: ");
        for(int i=0;i<6;i++){
            selectNumber[i] = random.nextInt(45)+1;
            System.out.print(selectNumber[i]+" ");
        }
        System.out.println();
        
        //당첨번호
        int[] winningNumber = new int[6];
        random = new Random(19);
        System.out.println("당첨 번호: ");
        for(int i=0;i<6;i++){
            winningNumber[i] = random.nextInt(45)+1;
            System.out.print(winningNumber[i]+ " ");
        }
        System.out.println();

        //당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.print("당첨여부: ");
        if(result){
            System.out.println("1등에 당첨되셧습니다.");
        } else {
            System.out.println("당첨 실패");
        }
    }
}
