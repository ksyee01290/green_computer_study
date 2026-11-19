package filewriter;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {
    public static void main(String[] args) throws Exception{
        String filename = "C:\\Temp\\file1.txt";

        try {
            File file = new File(filename);
            FileWriter fw = new FileWriter(file,true);
            fw.write("FileWeriter는 한글로된 "+"\r\n");
            fw.write("문자열을 바로 출력할 수 있다."+"\r\n");
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
