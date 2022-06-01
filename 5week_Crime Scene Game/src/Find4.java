import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import Main.Music;
//import 그림.그림;
//import 그림.글자;

public class Find4 extends JFrame implements ActionListener, Runnable{

    private JButton box[] = new JButton[12]; //같은 모양의 버튼을 배열로 만들어버림(버튼12개)
    private JButton start = new JButton("시작");
    private JLabel time_jlb = new JLabel("시간 => 0:10");
    private BorderLayout bl = new BorderLayout(10,10);
    private JPanel jp1 = new JPanel();
    private GridLayout gl1 = new GridLayout(3,4);// 3*4
    private JPanel jp2 = new JPanel();
    private GridLayout gl2 = new GridLayout(5,2);
    private JPanel jp21 = new JPanel();
    private FlowLayout fl21 = new FlowLayout(FlowLayout.RIGHT);

    private int count = -1;// 점수
    private int a = 1;

    public Find4(String title){// 생성자 : 가장 먼저 실행되는 부분
        super(title);// 타이틀바
        this.init();// 타이틀바
        this.start();
        // 띄워지는 창 설정
        super.setSize(500,500);//팝업되는 창의 크기 조절
        super.setLocation(1000, 300);//모니터상에 표시되는 위치
        super.setVisible(true); // 창을 보여줄것인지
        this.setAlwaysOnTop(true);

    }

    public void init(){//버튼 위치 지정
        Container con = this.getContentPane();
//        con.setLayout(bl);
        con.add("North", time_jlb);
//        con.add("Center", jp1);
//        jp1.setLayout(gl1); //GridLayout

        for(int i=0; i<12; ++i){
            box[i] = new JButton(); //버튼생성
//            jp1.add(box[i]);	//jp1판넬에 box[i] 추가
        }

        off_button();//비활성 버튼 호출
        con.add("South", jp2);
        jp2.setLayout(gl2);
        jp2.add(jp21);
        jp21.setLayout(fl21);
        jp21.add(start);

    }

    public void start(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 종료
        start.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            time_jlb.setText("시간 => 0:10");
            count=-1;
            Thread th = new Thread(this);
            th.start();
            on_button();
        }
    }
    public void off_button(){//버튼 비활성화
        for(int i=0; i<12; ++i){
            box[i].setEnabled(false);
        }

    }
    public void on_button(){//버튼 활성화
        for(int i=0; i<12; ++i){
            box[i].setEnabled(true);
        }
    }



    public void run(){// 초 세기
        int time = 10;

        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}

            time--;
            if (a==0) {
                break;
            }
            if (time == 0) {
                time_jlb.setText("제한시간을 초과했습니다.");
                off_button();
                try{
                    Thread.sleep(500);
                    dispose();
                    System.out.println("제한시간을 초과했습니다.");
//					Music failed1 = new Music("failed.mp3",false);  // 버튼 클릭
//					failed1.start();

                    System.out.println("미션 실패입니다.\n");
//                    message.show_fail();
                    Thread.sleep(1000);
                    System.out.println("재도전을 통해 최종 미션을 수행하세요\n");
                }catch(InterruptedException e){}
                break;
            }
            time_jlb.setText("시간 => 0:0"+time);
        }
    }


    public static void main(String[] args)
    {
        Find4 G = new Find4("2");
    }

}