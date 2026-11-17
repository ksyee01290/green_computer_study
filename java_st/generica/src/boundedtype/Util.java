package boundedtype;

public class Util {
    public static <X extends Number> int compare(X t1, X t2){
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return Double.compare(v1,v2);
    }
}
