import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myframe extends JFrame { //jframe을 상속받는다
    public myframe() //myframe의 속성설정
    {
        //컨테이너 생성
        setSize(300, 200);
        setLocation(1200,100); //프레임 위치
        setTitle("myframe");
        setVisible(true); //프레임이 보이도록

        getContentPane().setBackground(Color.yellow);

        //컴포넌트 추가
        setResizable(false);//사이즈 고정
        setLayout(new FlowLayout());//컴포넌트가 왼쪽에서 오른쪽으로 순차적으로 붙음
        JButton button = new JButton("버튼"); //버튼객체 생성
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);//프로그램이 종료해라
            }
        });


    }
    public static void main(String[] args)
    {
        myframe f = new myframe();
    }
}
