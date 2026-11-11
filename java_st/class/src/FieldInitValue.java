public class FieldInitValue {
    byte byteField; // 0이 들어간다
    short shortField;// 0이 들어간다
    int intField; // 0이 들어간다
    long longField;// 0L 이 들어간다

    boolean booleanField; // fales 이 들어간다
    char charField; // 빈공백이나 (\u0000)이 들어간다

    float floatField; // 0.0F 이 들어간다
    double doubleField; // 0.0 이 들어간다

    int[] arrField; // null 이 들어간다
    String referenceField; // null 이 들어간다
}
