package arrayss;

import java.util.*;

public class arrExample {
    public static void main(String[] args) {
        // ArrayCopyExample();
        EqualsExample();
    }

    public static void ArrayCopyExample(){
        //배열의 복사
        char[] arr1 = {'J','A','V','A'};

        //방법1
        char[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr2));

        char[] arr3 = Arrays.copyOfRange(arr1,1,3);
        System.out.println(Arrays.toString(arr3));

        char[] arr4 = new char[arr1.length];
        System.arraycopy(arr1,0,arr4,0,arr1.length);
        for(int i=0;i<arr4.length;i++){
            System.out.println("arr4["+i+"]="+arr4[i]);
        }

        System.out.println();
        for(char num : arr4){
            System.out.println("arr4["+num+"]="+num);
        }
    }

    public static void EqualsExample(){
        //배열의 얕은 복사후 비교 , 깊은 복사후 비교
        int[][] original = {{1,2},{3,4}};

        //얕은 복사후 비교
        System.out.println("[얕은 복제후 비교]");
        int[][] cloned1 = Arrays.copyOf(original, original.length);
        System.out.println("배열 번지 비교: "+original.equals(cloned1));
        System.out.println("1차 배열 항목값 비교: "+Arrays.equals(original, cloned1));
        System.out.println("중첩 배열 항목값 비교: "+Arrays.deepEquals(original, cloned1));

        //깊은 복사후 비교
        System.out.println("\n[깊은 복제후 비교]");
        int[][] cloned2 = Arrays.copyOf(original, original.length);
        cloned2[0] = Arrays.copyOf(original[0], original[0].length);
        cloned2[1] = Arrays.copyOf(original[1], original[1].length);
        System.out.println("배열 번지 비교: "+original.equals(cloned2));
        System.out.println("1차 배열 항목값 비교: "+Arrays.equals(original, cloned2));
        System.out.println("중첩 배열 항목값 비교: "+Arrays.deepEquals(original, cloned2));

    }
}
