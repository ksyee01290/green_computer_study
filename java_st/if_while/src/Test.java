import java.util.*;

public class Test {
    //배열없이 총점과 평균 구하기 임의의 수 이지만 총자리수는 정해져있음
    public static void no_list(Scanner sc, int i, int total){
        while(i<3){
            System.out.println("총 3개의 수를 입력:");
            int to = Integer.parseInt(sc.nextLine());
            total += to;
            i++;
        }
        double avg = (double)total/3;

        System.out.println("총점:"+total);
        System.out.println("평균:"+avg);
    }

    //리스트를 사용한 총점 평균 이것도 위와 마찬가지로 총자리수가 정해져있음
    public static void yes_list(Scanner sc, boolean run, int total){
        int[] num = new int[3];

        while(run){
            int i = 0;
            System.out.println("1. 총점 | 2. 평균 | 3. 정지 | 4. 입력");
            System.out.println("수를 입력해주십시오");
            String to = sc.nextLine();
            if(to.equals("1")){
                while(i<num.length){
                    total += num[i];
                    i++;
                }
                System.out.println("총점"+total);
            }else if(to.equals("2")){
                double avg = (double)total / num.length;
                System.out.println("평균"+avg);
            }else if(to.equals("3")){
                run=false;
            }else if(to.equals("4")){
                while(i<num.length){
                    System.out.println("숫자입력:");
                    num[i] = Integer.parseInt(sc.nextLine());
                    i++;                    
                }
            }
        }
    }

    //어레이 리스트를 활용한 어떠한수를 입력하던지 배열이 늘어나는 구조
    //배열이 추가로 입력하면 덮어씌워지는게 아닌 계속 추가되는구조
    public static void array_list(Scanner sc, int total){
        ArrayList<Integer> numbers = new ArrayList<>();

        while(true){
            System.out.println("1.입력 | 2.총점 | 3.평균 | 4.종료");
            System.out.println("수를 입력: ");
            String numb = sc.nextLine();
            
            if(numb.equals("1")){
                while(true){
                    System.out.println("숫자 입력: ");
                    int num = Integer.parseInt(sc.nextLine());
                    if(num == 0){
                        System.out.println("총 "+numbers.size()+" 개가 입력되었습니다.");
                        break;
                    }
                    numbers.add(num);
                }
            }else if(numb.equals("2")){
                for(int i=0;i<numbers.size();i++){
                    total+=numbers.get(i);
                }
                System.out.println("총점: "+total);
            }else if(numb.equals("3")){
                double avg = (double)total/numbers.size();
                System.out.println("평균: "+avg);
            }else if(numb.equals("4")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");
        boolean run = true;
        int i = 0;
        int total =0 ;

        //yes_list(sc,run,total);
        array_list(sc,total);

    }
}
