public class Car2 {
    int speed;

    //필드에 저장된값을 외부로 반환하는 getter문 이다
    //get 앞에 필드명 첫글자는 대문자로 입력해야한다.
    public int getSpeed(){
        return speed;
    }

    public void keyTurnOn(){
        System.out.println("키를 돌립니다.");
    }

    public void run(){
        for(int i=10;i<=50;i+=10){
            speed = i;
            System.out.println("달립니다.(시속: "+speed+"km/h");
        }
    }
}
