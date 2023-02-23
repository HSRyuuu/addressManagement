package addressManagement;

import javax.swing.*;
import java.io.IOException;

public class DataTable {
    private static final String[] colNames = {"이름","나이","생일","학번","전화번호"};
    private static JTable table = null;


    public static JTable getInstance() throws IOException {
        if(table==null){
            table = new JTable(DataArray.getInstance(),colNames);
        }
        return table;
    }
}
