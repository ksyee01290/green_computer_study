package fileinput;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\study\\java_st\\javaio\\src\\fileinput\\FileInputStreamExample.java");
            //FileInputStream fis = new FileInputStream("C:\\study\\java_st\\javaio\\src\\fileinput\\check.jpg");
            int data;
            //아래 비교구문은 파일이 읽을게 있다면 1 읽을게 없다면 -1 을출력해준다.
            while((data = fis.read())!=-1){
                //write는 콘솔창에 파일의 데이터를 1바이트씩 받아서 아스키코드로
                //출력해주는부분이다.
                //참고로 한글은 써주지 않는모양이다.
                System.out.write(data);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
