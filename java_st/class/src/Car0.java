public class Car0 {
    String company = "현대 자동차";
    String model;
    String color;
    int maxSpeed;

    public Car0(){
    }
    public Car0(String model){
        //this.model = model;
        this(model,null,4);// 이런식의 초기화가능
    }
    public Car0(String model, String color){
        this.model = model;
        this.color = color;
    }
    // 이렇게 조건식을 거쳐서 생성자를 만들기도가능
    public Car0(int type){
        if(type==1){
            this.model="두돈반";//기본값을 성정하는방법에 한에서 쓰인다
        }else if(type==2){
            this.color="블르";
        }
    }
    public Car0(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
