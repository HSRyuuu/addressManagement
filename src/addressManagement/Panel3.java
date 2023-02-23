package addressManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.IOException;

public class Panel3 extends JPanel {
    private static String[][] data = new String[50][5];
    private JScrollPane sp;
    public Panel3() throws IOException {
        JTable table = new JTable();
        table = DataTable.getInstance();
        table.setFillsViewportHeight(true);
        this.sp = new JScrollPane(table);
        Dimension d = table.getPreferredSize();
        d.width = 700;
        d.height = 120;
        sp.setPreferredSize(d);
    }

    public JScrollPane getSp() {
        return sp;
    }
}
