public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time(12,35,30);
        System.out.println(t);
        //t.hour = 13 이건 안된다 private 이기때문 직접값을 추가 안됨
        t.setHour(t.getHour()+1);

        // 아래방식은 기본적으로 클래스에 extend 상속이 되어있는부분에
        // 문자배열되는 형식을 바꿔주는 방식으로 출력이된부분이다.
        System.out.println(t); // 여기서 t = t.toString() 와 같다
        System.out.println("========================");
        //아래쪽은 프린트 함수를 따로만들어서 출력한 방법
        t.printInfo();
    }
}

class Time {
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour(){return hour;}
    public void setHour(int hour){
        if(hour<0 || hour>23) return;
        this.hour = hour;
    }
    
    public int getMinute(){return minute;}
    public void setMinute(int minute){
        if(minute<0 || minute>59) return;
        this.minute = minute;
    }

    public int getSecond(){return second;}
    public void setSecond(int second){
        if(second<0 || second>59) return;
        this.second = second;
    }

    // 클래스 뒤에는 기본적으로 extend 가 붙어 있다 
    // 아래것을 없애면 기본적으로 주소가 나오는것 같다 time@58644d46 이런식
    // 이번엔 다른 매서드로 바꿔서 처리해보자
    public void printInfo(){
        System.out.println(hour+":"+minute+":"+second);
    }
    // 두개다 출력은 잘나온다 어느것이 더편한지는 잘모르겠다.
    public String toString(){
        return hour + ":" + minute + ":" + second;
    }
}
