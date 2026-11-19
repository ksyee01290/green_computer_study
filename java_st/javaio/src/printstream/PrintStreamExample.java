package printstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) throws Exception{
        String filename = "C:\\Temp\\file1.txt";

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            PrintStream ps = new PrintStream(fos);

            int a = 340;
            String b = "되면좋고 안되면 아쉽고";
            String c = "잘되네";

            ps.println("[프린터 보조 스트림]");
            ps.print("마치 ");
            ps.println("프린터가 출력하는 것처럼 ");
            ps.println("데이터를 출력합니다.");
            ps.printf("그럼 이것도 [%d] 되려나 [%s] [%s]",a,b,c);

            ps.flush();
            ps.close();
            fos.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
