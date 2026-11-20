package filesystem;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File dir = new File("c:/Temp/Dir");
        File file1 = new File("c:/Temp/file1.txt");
        File file2 = new File("c:/Temp/file2.txt");
        File file3 = new File(new URI("file:///c:/Temp/file3.txt"));

        // 아래부분이 실질적으로 파일 혹은 폴더를 생성하는부분이다. mkdirs()이것은
        // 폴더를 만드는 매서드이다 
        // mkdir은 새로운 디렉토리 생성
        // mkdirs 경로상에 없는 모든 디렉토리를 생성
        // createNewFile 는 파일을 생성하는 부분이다
        if(dir.exists() == false){ dir.mkdirs();}
        if(file1.exists() == false){ file1.createNewFile();}
        if(file2.exists() == false){ file2.createNewFile();}
        if(file3.exists() == false){ file3.createNewFile();}

        File temp = new File("C:/Temp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd    a    HH:mm");
        File[] contents = temp.listFiles();
        System.out.println("날짜                  시간        형태       크기      이름");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for(File file : contents){
            //file.lastModified() 마지막으로 수정된 시각을 밀리초(long)단위로 반환
            System.out.println(sdf.format(new Date(file.lastModified())));
            // isDirectory 는 해당부분에 파일을 검색하는역할을한다.
            if(file.isDirectory()){
                System.out.println("\t<DIR>\t\t\t" + file.getName());
            } else {
                System.out.println("\t\t\t" + file.length() + "\t\t" + file.getName());
            }
            System.out.println();
        }

    }
}
