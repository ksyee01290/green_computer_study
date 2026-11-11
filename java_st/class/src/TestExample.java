public class TestExample {
    public static void main(String[] args) {

        Test obj1 = Test.getInstance();
        Test obj2 = Test.getInstance();
        System.out.println("이런식으로의 계산밖에 안되는가"+obj1.pi*3.24);
        System.out.println(obj2.pi);

        for(int i=0;i<5;i++){
            
        }
        
        if(obj1.equals(obj2.pi)){
            System.out.println("두개가 같을까?");
        }else{
            System.out.println("아니면 두개가 다를까?");
        }
        

    }
}