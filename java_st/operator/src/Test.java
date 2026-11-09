import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"MS949");
        ArrayList<String> pocket = new ArrayList<>();
        pocket.add("pica");
        pocket.add("metamong");
        pocket.add("paili");

        boolean focase = true;
        
        if(pocket.contains("paili")){
            System.out.println("파이리 귀여워");
        } else{
            System.out.println("파이리 아니야");
        }
        
        for(int i=0;i<pocket.size();i++){
            System.out.println("포켓몬을 입력해: ");
            String scc = sc.nextLine();
            if(pocket.contains(scc)){
                System.out.println("메타몽 이다");
                focase = false;
            } else if(focase){
                System.out.println("메타몽일까?");
            } else{
                System.out.println("메타몽이 아니였어");
                focase = true;
            }
        }
        ArrayList<PocketMon> pock = new ArrayList<>();
        pock.add(new PocketMon("메타몽",98,994));
        pock.add(new PocketMon("망나뇽",38,130));
        pock.add(new PocketMon("피카츄", 88, 650));
    }
}
class PocketMon{
    String name;
    int lovl;
    int atck;

    public PocketMon(String name, int lovl, int atck){
        this.name = name;
        this.lovl = lovl;
        this.atck = atck;
    }

    public void pocketInfo(){
        System.out.printf("이름: ,레벨: ,공격력: ",name, lovl, atck);
    }
}
