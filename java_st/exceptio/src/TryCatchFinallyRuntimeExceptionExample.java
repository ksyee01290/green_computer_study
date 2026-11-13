public class TryCatchFinallyRuntimeExceptionExample {
    public static void main(String[] args) {
        String[] data = new String[2];
        // for(int i=0;i<data.length;i++){
        //     data[i] = "a";
        // }

        data[0]="5";
        data[1]="2";
        add(data);
        add2(data);

    }   
    
    public static void add(String[] data){
        try{
            data[2] = "a";
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.println("[실행 방법]");
            System.out.println("java TryCatchFinallyRuntimeExceptionExample num1 num2");
            return;
        }
    }

    public static void add2(String[] data){
        try{
            int value1 = Integer.parseInt(data[0]);
            int value2 = Integer.parseInt(data[1]);
            int result = value1 + value2;
            System.out.println(data[0] + "+"+data[1]+"="+result);
        } catch(NumberFormatException e){
            System.out.println("숫자로 변환할 수 없습니다.");
        } finally{
            System.out.println("다시 실행하세요.");
        }
    }
}
