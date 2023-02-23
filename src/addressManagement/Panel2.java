package addressManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Panel2 extends JPanel {
    private JLabel nameLabel = new JLabel("이름");
    private JLabel ageLabel = new JLabel("나이");
    private JLabel birthDayLabel = new JLabel("생일");
    private JLabel studentNumLabel = new JLabel("학번");
    private JLabel phoneLabel = new JLabel("전화번호");
    private JTextField nameSpace = new JTextField(5);
    private JTextField ageSpace = new JTextField(3);
    private JTextField birthDaySpace = new JTextField(10);
    private JTextField studentNumSpace = new JTextField(8);
    private JTextField phoneSpace = new JTextField(12);
    private JButton registBtn = new JButton("연락처 등록");

    
    public Panel2() {
        this.setLayout(new FlowLayout());
        this.add(nameLabel);
        this.add(nameSpace);
        this.add(ageLabel);
        this.add(ageSpace);
        this.add(birthDayLabel);
        this.add(birthDaySpace);
        this.add(studentNumLabel);
        this.add(studentNumSpace);
        this.add(phoneLabel);
        this.add(phoneSpace);
        registBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    addStudent();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.add(registBtn);
    }

    public void addStudent() throws IOException {
            Student student = new Student(nameSpace.getText(), ageSpace.getText(),
                    birthDaySpace.getText(), studentNumSpace.getText(), phoneSpace.getText());
            JudgeData judge = new JudgeData(student);
            if(!judge.errorString.trim().isEmpty()){
                String errorMsg = judge.errorString;
                JOptionPane error = new JOptionPane();//에러메시지 출력해주는 클래스
                error.showMessageDialog(null,errorMsg );
            }else{
                AddressList.getInstance().put(student.getName(),student);
                tableRefresh();
                clearTextField();
            }
        }
    public void tableRefresh() throws IOException {
        String[] colNames = {"이름","나이","생일","학번","전화번호"};
        DefaultTableModel model = new DefaultTableModel(DataArray.getInstance(),colNames);
        DataTable.getInstance().setModel(model);
    }
    public void clearTextField(){
        nameSpace.setText("");
        ageSpace.setText("");
        birthDaySpace.setText("");
        studentNumSpace.setText("");
        phoneSpace.setText("");
    }
}
