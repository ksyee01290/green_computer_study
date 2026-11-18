package hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        
        //set는 중복된값을 추가하지 않는다.
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체수: "+size);

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            System.out.println("\t" + element);
        }
        
        set.remove("JDBC");
        set.remove("iBATIS");
        System.out.println("총 객체수: "+set.size());

        for(String element : set){
            System.out.println("\t"+element);
        }

        //객체는 남기고 내용물만 지운다.
        set.clear();
        //isEmpty 객체가 비어있는지 안비어있는지를 판별한다.
        if(set.isEmpty()){System.out.println("비어있음");}
    }
}
