package addressManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Panel1 extends JPanel {
    String fname = "src/data/juso.txt";
    private JButton printBtn = new JButton("연락처 출력");
    private JButton exitBtn = new JButton("나가기");
    private JLabel deleteLabel = new JLabel("     삭제할 연락처(이름) 입력 : ");
    private JTextField delName = new JTextField(5);
    private JButton deleteBtn = new JButton("삭제");
    private JButton saveBtn = new JButton("데이터 저장");

    public Panel1() {
        this.setLayout(new FlowLayout());
        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    tableRefresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    deleteStudent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    saveTextFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.add(printBtn);
        this.add(exitBtn);
        this.add(deleteLabel);
        this.add(delName);
        this.add(deleteBtn);
        this.add(saveBtn);
    }

    public void tableRefresh() throws IOException {
        String[] colNames = {"이름","나이","생일","학번","전화번호"};
        DefaultTableModel model = new DefaultTableModel(DataArray.getInstance(),colNames);
        DataTable.getInstance().setModel(model);
    }
    public void saveTextFile() throws IOException {
        String data[][] = DataArray.getInstance();
        Map<String,Student> map = new Hashtable<>();
        map = AddressList.getInstance();
        try(FileOutputStream fos = new FileOutputStream(fname,false)){
        }catch(IOException e){
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
        for(int i=0;i<map.size();i++){
            String s = data[i][0]+"\t"+data[i][1]+"\t"+data[i][2]+"\t"+data[i][3]+"\t"+data[i][4];
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }
    public void deleteStudent() throws IOException {
        String del = this.delName.getText();
        int result = containsKeyCheck(del);
        if(result==0) {
            AddressList.getInstance().remove(del);
            tableRefresh();
        }else if(result==1) {
            JOptionPane error = new JOptionPane();
            error.showMessageDialog(null, "삭제 란이 빈칸입니다.");
        }else if(result==2){
            JOptionPane error = new JOptionPane();
            error.showMessageDialog(null, "존재하지 않는 이름입니다.");
        }

    }
    public int containsKeyCheck(String delete) throws IOException {
        Map<String,Student> map = new Hashtable<>();
        map = AddressList.getInstance();
        if(map.containsKey(delete)){
            return 0;
        }else if(delete.trim().isEmpty()){
            return 1;
        }else
            return 2;
    }
}
