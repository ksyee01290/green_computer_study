package jdbc;

import java.sql.Blob;
import lombok.Data;

@Data 
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bfilename;
    private Blob bfiledata;
}
