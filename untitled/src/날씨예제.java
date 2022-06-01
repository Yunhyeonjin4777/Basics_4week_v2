import javax.swing.*;
import java.awt.*;

public class 날씨예제 extends JFrame {

    JLabel label1;
    JLabel label2;
    JLabel label3;
    int sec;
    int min;
    int day = 1;

    날씨예제() //날씨예제의 속성설정
    {
        setTitle("하루 2분");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창닫기
        setLayout(new BorderLayout(10,10));//컴포넌트 붙는 위치?
        label1 = new JLabel();//표시
        label2 = new JLabel();//표시
        label3 = new JLabel();//표시

        mythread2 th1 = new mythread2();

        label1.setFont(new Font("Gothic", Font.PLAIN, 50));
        label2.setFont(new Font("Gothic", Font.ITALIC, 20));
        label2.setOpaque(true);//색설정
        Color color = new Color(255,0,0);
        label1.setForeground(color);

        label2.setFont(new Font("Gothic", Font.ITALIC, 20));

        this.add("Center",label1);
        this.add("North",label2);
        this.add("West",label3);

        setLocationRelativeTo(null); //가운데로 출력
        setSize(800, 200);
        setVisible(true); //프레임이 보이도록
        this.setAlwaysOnTop(false); // 프레임 항상 위에 있게

        th1.start();
    }

    class mythread2 extends Thread
    {
        public void run()
        {
            int n = 0;

            while(true)
            {
                n++;
                sec = n % 60;
                min = n / 60 % 60;

                if(min == 0)
                {
                    label1.setText(String.format(" ※  낮 - 생선가게 운영시간입니다."));
                }
                if(min == 1)
                {
                    label1.setText(String.format(" ※ 밤 - 생선가게가 문을 닫았습니다. "));
                }
                if(min == 2)
                {
                    n = 0;
                    day++;
                }
                label2.setText(String.format("        " + day +" 일차"));
                label2.setText(String.format("  %02d:%02d", min, sec));

                try{
                    sleep(1000);
                }catch (Exception e){
                    return;
                }

            }
        }
    }
    public int time() {
        return min;
    }

    public int day() {
        return day;
    }

    public static void main(String[] args)
    {
        날씨예제 날씨 = new 날씨예제();
    }
}
