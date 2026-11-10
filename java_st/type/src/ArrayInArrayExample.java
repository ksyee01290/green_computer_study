public class ArrayInArrayExample {
    public static void main(String[] args) {
        int[][] mathScores = new int[2][3];
        for(int i=0;i<mathScores.length;i++){
            for(int k=0;k<mathScores[i].length;k++){
                System.out.println("mathScores["+i+"]["+k+"]="+mathScores[i][k]);
            }
        }
        System.out.println();

        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];
        for(int i=0;i<englishScores.length;i++){
            for(int k=0;k<englishScores[i].length;k++){
                System.out.println("englishScores["+i+"]["+k+"]="+englishScores[i][k]);
            }
        }
        System.out.println();

        int[][] javaScores = {{95,80},{92,96,80}};
        for(int i=0;i<javaScores.length;i++){
            for(int k=0;k<javaScores[i].length;k++){
                System.out.println("javaScores["+i+"]["+k+"]="+javaScores[i][k]);
            }
        }
        System.out.println();

        int[][][] score = new int[3][3][3];
        int[][][] score1 = {
            {{1,2,3},{4,5,6},{7,8,9}},
            {{10,11,12},{13,14,15},{16,17,18}},
            {{19,20,21},{22,23,24},{25,26,27}}
        };
        for(int i=0;i<score.length;i++){
            for(int j=0;j<score[i].length;j++){
                for(int k=0;k<score[i][j].length;k++){
                    System.out.println("score["+i+"]["+j+"]["+k+"]="+score1[i][j][k]);
                }
            }
        }
    }
}
