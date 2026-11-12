package dmbcell;
public class DmbCellPhoneExample {
    public static void main(String[] args) {
        DmbCellPhone dmbcellphone = new DmbCellPhone("자바폰","검정",10);
        
        //CellPhone 로부터 상속 받은 필드
        System.out.println("모델: "+dmbcellphone.model);
        System.out.println("색상: "+dmbcellphone.color);
        //DmbCellPhone 의 필드
        System.out.println("채널: "+dmbcellphone.channel);
        System.out.println("=========================");

        //CellPhone로부터 상속받은 메소드 호출
        dmbcellphone.powerOn();
        dmbcellphone.bell();
        dmbcellphone.sendVoice("여보세요");
        dmbcellphone.receiveVoice("안녕하세요! 저는 홍 인데요");
        dmbcellphone.sendVoice("아예 반갑네요");
        dmbcellphone.hangUp();

        //DmbCellPhone의 메소드 호출
        dmbcellphone.turnOnDmb();
        dmbcellphone.changeChannelDmb(12);
        dmbcellphone.turnOffDmb();
    }
}
