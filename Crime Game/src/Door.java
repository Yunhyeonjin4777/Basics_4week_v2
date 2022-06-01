import javax.swing.*;
import java.awt.*;

public class Door extends JFrame {

    JLabel label;
    public static boolean check;
    Thread thread;
    int sec;

    Door()
    {
        setTitle("26년전 과거로 가는 문");
        setSize(400,200);
        setLocation(1100,250); //프레임 생성 위치
        setVisible(true); //프레임활성화여부
        setResizable(false); //사이즈 고정

        label = new JLabel(); //오브젝트

        label.setFont(new Font("Gothic", Font.PLAIN, 20));
        Color color = new Color(255,0,0);
        label.setForeground(color);

        this.add("Center", label);

        Doorthread th = new Doorthread(); // 쓰레드 객체 생성
        th.start(); //쓰레드 스타트
    }
    class Doorthread extends Thread
    {
        public void run()
        {
            int n = 50;

            while(true)
            {
                n--;

                if(n > 0)
                {
                    label.setText("과거로 가는 문이 열리기까지" + n + "초 남음");
                }
                if(n == 0)
                {
                    check = true;
                    label.setText("입장가능");
                }
                try{
                    Thread.currentThread().sleep(1000);
                }catch (InterruptedException e){
                    return;
                }
                repaint();
            }
        }
    }

//        public static void main(String[] args)
//    {
//        Door door = new Door();
//    }
}
