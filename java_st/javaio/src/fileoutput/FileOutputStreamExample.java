package fileoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) throws Exception{
        String originalFileName = "C:\\study\\java_st\\javaio\\src\\fileoutput\\monikas_wunderwelt-leaf-10544685_1920.jpg";
        String targetFileName = "C:\\Temp\\test.png";

        try {
            //처음에 생성한 스트림을 맨 마지막에 닫아주어야한다.
            FileInputStream fis = new FileInputStream(originalFileName);
            FileOutputStream fos = new FileOutputStream(targetFileName);

            int readByteNo;
            byte[] readBytes = new byte[100];
            while((readByteNo = fis.read(readBytes))!=-1){
                // 아웃풋 스트림의 write 에대해 서술한 내용이다
                // 생성한 바이트 배열안에서의, 0번째 인덱스부터실행, readByteNo까지
                fos.write(readBytes, 0, readByteNo);
            }
            fos.flush();
            fos.close();
            fis.close();
            System.out.println("복사가 잘되었음");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println("");
        }

    }
}
