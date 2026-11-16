package equal;

public class MemberExample {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if(obj1.equals(obj2)){
            System.out.println("obj1과 obj2는 동등합니다.");
        } else {
            System.out.println("obj1과 obj2는 동등하지 않습니다.");
        }

        // == 과같이 쓰면 필드는 동일하지만 주소 가 다르므로 동일하지 않는다
        if(obj1 == obj2){
            System.out.println("동일하다");
        } else {
            System.out.println("동일하지 않다");
        }

        if(obj1.equals(obj3)){
            System.out.println("obj1과 obj3는 동등합니다.");
        } else {
            System.out.println("obj1과 obj3는 동등하지 않습니다.");
        }
    }
}
