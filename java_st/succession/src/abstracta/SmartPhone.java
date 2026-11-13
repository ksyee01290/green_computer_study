package abstracta;

public class SmartPhone extends Phone{
    
    public SmartPhone(String owner){
        super(owner);
    }

    // 이와같이 오버라이딩 해서 추상클래스를 활용한다.

    public void internetSearch(){
        System.out.println("인터넷 검색을 합니다.");
    }
    
}
