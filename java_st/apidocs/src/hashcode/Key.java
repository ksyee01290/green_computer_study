package hashcode;

public class Key {
    public int number;

    public Key(int number){
        this.number = number;
    }

    // instanceof 연산자란 참조변수가 참조하고 있는 인스턴스의 실제 타입을 비교하기 위해 사용한다.

    @Override 
    public boolean equals(Object obj){
        // 여기서 obj는 key와 동등한 객체인가를 비교한다.
        //동등하다면 아래로들어가 key형태로 바꾸어준다.
        //필드 값인 this.number을 가져와 주소비교를 해준다. ==은 주소비교 일거다
        if(obj instanceof Key){
            Key compareKey = (Key) obj;
            if(this.number == compareKey.number){
                return true;
            }
        }
        return false;
    }

    @Override 
    public int hashCode(){
        return number;
    }
}
