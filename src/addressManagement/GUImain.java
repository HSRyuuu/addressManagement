package addressManagement;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class GUImain extends JFrame {
    public GUImain() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료버튼
        setTitle("연락처 관리");// 제목 설정
        setResizable(false);
        this.setLayout(null);

        Panel1 panel1 = new Panel1();
        panel1.setBounds(10,10,850,40);
        this.add(panel1);

        Panel2 panel2 = new Panel2();
        panel2.setBounds(10,50,850,50);
        this.add(panel2);

        Panel3 panel3 = new Panel3();
        panel3.add(panel3.getSp());
        panel3.setBounds(0,100,850,200);
        this.add(panel3);


        setSize(850,280);// 윈도우 크기설정
        setVisible(true);// 윈도우가 화면에 보임
    }
}
