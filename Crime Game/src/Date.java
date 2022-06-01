import javax.swing.*;
import java.awt.*;

public class Date extends JFrame {

    JLabel label1;
    JLabel label2;
    int sec;
    int min;
    int day = 7;

    Date() //날짜타이머의 속성설정하기
    {
        //컨테이너 생성
        setTitle("날짜 타이머");
        setSize(400,150);
        setLocation(1100,100); //프레임 생성 위치
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

        Datethread th = new Datethread(); // 쓰레드 객체 생성
        th.start(); //쓰레드 스타트
    }

    public int day() {
        return day;
    }

    class Datethread extends Thread
    {
        public void run()
        {
            int n = 0;

            while(true)
            {
                n++;
                sec = n % 60;
                min = n / 60 % 60;

                if(min == 2)
                {
                    n = 0;
                    day--;
                }
                label1.setText(String.format("하루 2분  %02d:%02d", min, sec));
                label2.setText(String.format("내사종결까지 남은 시간 단 " + day + "일"));

                try{
                    sleep(1000);
                }catch (Exception e){
                    return;
                }
            }
        }
    }


//    public static void main(String[] args)
//    {
//        Date dTimer = new Date();
//    }

}