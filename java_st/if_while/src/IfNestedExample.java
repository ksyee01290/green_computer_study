public class IfNestedExample {
    public static void main(String[] args) {
        //소수점 두자리까지 곱해라 0.99
        double score =(double)(Math.random()*20) + 81;
        System.out.println("점수: "+ score);

        String grade;

        if(score>=90){
            if(score>=95){
                grade = "A+";
            }else{
                grade = "A";
            }
        }else{
            if(score>=85){
                grade = "B+";
            }else{
                grade = "B";
            }
        }
        System.out.println("학점: "+ grade);

        String grade1 = (score>=90) ? 
            ((score>=95) ? "A+" : "A") :
            ((score>=85) ? "B+" : "B");
        
        System.out.println("학점: "+ grade1);
    }
}
