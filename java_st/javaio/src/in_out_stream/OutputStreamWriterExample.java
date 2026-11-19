package in_out_stream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {
    public static void main(String[] args) throws Exception{
        String filename = "C:\\Temp\\file1.txt";

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            Writer writer = new OutputStreamWriter(fos);
            
            String data = "\r\n나의 나나 나나 나비 \r\n\n";
            char c = '가';
            char d = '가';
            int e = 65;
            writer.write(data);
            writer.append(c);
            writer.write(data);
            writer.append(d);
            // 인트형으로 넣을경우 데이터가 숫자로 들어가는게 아니라 유니코드로 들어간다.
            writer.write(e);

            writer.flush();
            writer.close();
            fos.close();
            System.out.println("파일 저장 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
