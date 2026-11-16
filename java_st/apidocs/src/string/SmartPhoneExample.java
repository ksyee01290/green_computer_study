package string;

public class SmartPhoneExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

        String strObj = myPhone.toString();
        System.out.println(strObj);

        //myphone 뒤에 .toString() 메서드가 암묵적으로 붙어 있다.
        System.out.println(myPhone);
    }
}
