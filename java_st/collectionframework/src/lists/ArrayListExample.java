package lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // add 값을 추가할때
        // size 길이 잴때
        // get 위치 가르키거나할때
        // remove 제거할때
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("JDBC");
        list.add("Servlet/JSP");
        list.add(2, "Database");
        list.add("iBATIS");

        int size = list.size();
        System.out.println("총 객체수: "+size);
        System.out.println();

        String skill = list.get(2);
        System.out.println("2: "+skill);
        System.out.println();

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            System.out.println(i+":"+str);
        }
        System.out.println();

        list.remove(2);
        list.remove(2);
        list.remove("iBATIS");

        for(int i=0; i<list.size();i++){
            String str = list.get(i);
            System.out.println(i+":"+str);
        }
    }
}
