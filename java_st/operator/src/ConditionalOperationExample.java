public class ConditionalOperationExample {
    public static void main(String[] args) {
        int score = 85;
        char grade = (score>90) ? 'A' : ((score>80) ? 'B' : 'C');
        System.out.println(score + "점은" + grade + "등급입니다.");

        int score1 = 91;
        if(score1>90){
            grade = 'A';
        }else{
            if(score1>80){
                grade = 'B';
            }else{
                grade = 'C';
            }
        }
        System.out.println(score1 + "점은" + grade + "등급입니다.");
    }
}
