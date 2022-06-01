import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); //각 패널에 기능 추가
        JLabel label = new JLabel("some text"); //표시
        JButton button = new JButton("Click me!");
        JButton button2 = new JButton("Exit");
        JTextArea textArea = new JTextArea();
        JPanel butpanel = new JPanel();

        panel.setLayout(new BorderLayout());//내가 원하는 위치에 버튼등 두는 거


        butpanel.add(button);
        butpanel.add(button2);
        panel.add(label, BorderLayout.NORTH); //위쪽에 위치함
        panel.add(butpanel, BorderLayout.WEST);//패널을 넣음
        panel.add(textArea, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {//버튼기능추가
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(textArea.getText()); //글자 불러오기
//                textArea.append("good\n"); //글씨추가
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//프로그램이 종료해라
            }
        });


        frame.add(panel);//꼭 프레임안에 넣어주기

        frame.setResizable(false);//사이즈 고정
        frame.setVisible(true); //프레임이 보이도록
        frame.setPreferredSize(new Dimension(340,840/12*9));
        frame.setSize(340, 840/12*9);
        frame.setLocationRelativeTo(null); //가운데로 출력
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫기?


    }
}
