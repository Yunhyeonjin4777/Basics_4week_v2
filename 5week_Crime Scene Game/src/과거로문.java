import javax.swing.*;
import java.awt.*;

public class 과거로문 extends JFrame {

    public static boolean check;
    Thread thread;
    int sec = 120;
//    boolean check = false;
    JLabel label;

    과거로문()
    {
        setTitle("과거로 문");
        setSize(400,200);
        setLocation(1100,250); //프레임 생성 위치
        setVisible(true); //프레임활성화여부
        setResizable(false); //사이즈 고정

        label=new JLabel();
        Color color = new Color(255,0,0);
        label.setForeground(color);
        label.setFont(new Font("Gothic", Font.PLAIN, 20));
        this.add("Center", label);

        thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    try{
                        Thread.currentThread().sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    if(sec > 0)
                    {
                        sec--;
                        label.setText("과거로 가는 문이 열리기까지" + sec + "초 남음");
                    }
                    if(sec == 0)
                    {
                        check = true;
                        label.setText("입장가능");
                    }
                    repaint();
                }
            }
        });
        thread.start();
    }

    void in() // 입장했을 경우 초기화
    {
        sec = 120;
        check = false;
    }

//    public static void main(String[] args)
//    {
//        과거로문 door = new 과거로문();
//    }
}
