import javax.swing.*;
import java.awt.*;

public class 과거로문 extends JFrame{

    JLabel label1;
    JLabel label2;
    int sec;

    과거로문()
    {
        //컨테이너 생성
        setTitle("과거로문");
        setSize(400,150);
        setLocation(1100,250); //프레임 생성 위치
        setVisible(true); //프레임활성화여부
        setResizable(false); //사이즈 고정

        label1 = new JLabel(); //오브젝트
        label2 = new JLabel(); //오브젝트

        label1.setFont(new Font("Gothic", Font.PLAIN, 25)); //폰트, 사이즈 지정
        label2.setFont(new Font("Gothic", Font.PLAIN, 25)); //폰트, 사이즈 지정
        Color color = new Color(200,50,0); //색 객체 생성
        label2.setForeground(color); //색지정


        this.add("North", label1);
        this.add("Center", label2);

        과거로문thread th = new 과거로문thread(); // 쓰레드 객체 생성
        th.start(); //쓰레드 스타트
    }


    class 과거로문thread extends Thread
    {
        public void run()
        {
            int n = 120;
            while(true)
            {
                n--;
                if (n > 0)
                {
                    label1.setText(String.format("과거로 가는 문이 열리기까지" + n + "초 남음"));
                }
                if (n == 0)
                {
                    System.out.println("과거로 가는 문이 열렸습니다");
                    System.out.println("과거로 입장합니다");
                    n = 120;
                }
                try{
                    sleep(1000);
                }catch (Exception e) {return;}
            }
        }
    }
    public static void main(String[] args)
    {
        과거로문 과거Timer = new 과거로문();
    }
}
