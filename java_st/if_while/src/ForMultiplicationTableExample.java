public class ForMultiplicationTableExample {
    public static void main(String[] args) {
        gugu_back();

    }
    public static void gugu(){
        for(int i=2; i<=9; i++){
            System.out.println("*** "+i+"단 ***");
            for(int j=1; j<=9; j++){
                System.out.println(i+" x "+j+ " = "+(i*j));
            }
        }
    }
    public static void gugu_back(){
        for(int i=9; i>=2; i--){
            System.out.println("*** "+i+"단 ***");
            for(int j=1; j<=9; j++){
                System.out.println(i+" x "+j+ " = "+(i*j));
            }
        }
    }
}
