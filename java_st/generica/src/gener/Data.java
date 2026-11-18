package gener;
// 제네릭 설정값은 임의로 지정가능 <T> 대문자로 원하는 단어 하나
// 암묵적으로 정해진게 있는듯하다. Type 는 <T> 이런식으로
public class Data<T> {
    //필드
    T obj;
    //생성자
    public Data(T ob){
        this.obj = ob;
    }
    //메서드
    T getObj(){
        return obj;
    }

    public void showType(){
        System.out.println("Type of T: "+obj.getClass().getName());
    }
}
