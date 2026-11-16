package equal;

public class Member {
    public String id;

    public Member(String id){
        this.id=id;
    }

    //기존에 이미 있는 라이브러리 equals를 아래와 같이 재정의해서 사용할수있다.
    //재정의해서 사용하려면 메서드명과 형식이 동일해야한다.
    //instanceof 중요하다 기억해두자 아래의 형식을풀어보자면
    //obj 형태가 Member형 인가의 비교구문이다

    // 여기서 만약 오버라이딩으로 equals를 재정의하지 않는다면
    // 같은 객체이건 다른 객체이건 상관없이 객체 저장데이터 동일이필요
    //object의 equals 메소드를 재정의 하여 논리적 동등 비교를 행한다.
    
    //아래와 같이 재정의 하지 않는다면 객체별로 내용물이같아도
    //객체가 달라서 비교가 성립이 되지 않는다.
    @Override 
    public boolean equals(Object obj){
        if(obj instanceof Member){
            Member member = (Member) obj;
            if(id.equals(member.id)){
                return true;
            }
        }
        return false;
    }
}
