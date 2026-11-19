package filereader;

import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) throws Exception{
        // 아래와 같이 주소변수를 따로 생성하는게 좋다.
        String orname = "C:\\study\\java_st\\javaio\\src\\filereader\\FileReaderExample.java";

        try {
            FileReader fr = new FileReader(orname);

            int readCharNo;
            char[] cbuf = new char[100];
            while((readCharNo=fr.read(cbuf))!=-1){
                String data = new String(cbuf, 0, readCharNo);
                System.out.print(data);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
