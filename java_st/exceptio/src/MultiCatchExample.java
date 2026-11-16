public class MultiCatchExample {
    public static void main(String[] args) {
        // catch는 무조건 처음 구문 부터 예외처리 기능을 검토한다.
        // 만약 처음부터 모든 상황에 대처하는 코드인 Exception 을 넣는다면
        // 다음 catch는 실행되지 않는다
        // 예를들어 array 에러가 떠야하는상황인데 exception 을 처음으로 놓는다면
        // 처음 검사한catch 만 실행되고 프로그램이 종료된다.
        try {
            //String[] args1 = new String[2];
            String data1 = args[0];
            String data2 = args[1];

            int value1 = Integer.parseInt(data1);
            int value2 = Integer.parseInt(data2);
            int result = value1 + value2;
            System.out.println(data1+"+"+data2+"="+result);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
        } catch(Exception e){
            System.out.println("알수 없는 예외 발생");
        } finally{
            System.out.println("다시 실행하세요");
        }
    }
}
