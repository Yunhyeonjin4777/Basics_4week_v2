import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import Main.Music;
//import 그림.그림;
//import 그림.글자;

public class fishgame2 extends JFrame implements ActionListener, Runnable{

    ImageIcon ii = new ImageIcon("fish1.png");//이미지아이콘 생성
    private JButton box[] = new JButton[12]; //같은 모양의 버튼을 배열로 만들어버림(버튼12개)
    private JButton start = new JButton("시작");
    private JLabel jlb = new JLabel("점수 : 0");
    private JLabel time_jlb = new JLabel("시간 => 0:10");
    private BorderLayout bl = new BorderLayout(10,10);
    private JPanel jp1 = new JPanel();
    private GridLayout gl1 = new GridLayout(3,4);// 3*4
    private JPanel jp2 = new JPanel();
    private GridLayout gl2 = new GridLayout(5,2);
    private JPanel jp21 = new JPanel();
    private FlowLayout fl21 = new FlowLayout(FlowLayout.RIGHT);

    private int random_num = 0;// 랜덤수
    private int count = -1;// 점수
    private int a = 1;

    public fishgame2(String title){// 생성자 : 가장 먼저 실행되는 부분
        super(title);// 타이틀바
        this.init();// 타이틀바
        this.start();
        // 띄워지는 창 설정
        super.setSize(800,800);//팝업되는 창의 크기 조절
        super.setLocation(500, 150);//모니터상에 표시되는 위치
        super.setVisible(true); // 창을 보여줄것인지
        this.setAlwaysOnTop(true);

    }

    public void init(){//버튼 위치 지정
        Container con = this.getContentPane();
        con.setLayout(bl);
        con.add("North", time_jlb);
        con.add("Center", jp1);
        jp1.setLayout(gl1); //GridLayout

        for(int i=0; i<12; ++i){
            box[i] = new JButton(); //버튼생성
            jp1.add(box[i]);	//jp1판넬에 box[i] 추가
        }

        off_button();//비활성 버튼 호출
        con.add("South", jp2);
        jp2.setLayout(gl2);
        jp2.add(jlb);
        jp2.add(jp21);
        jp21.setLayout(fl21);
        jp21.add(start);

    }

    public void start(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 종료
        start.addActionListener(this);
        for(int i=0; i<12; ++i){// 버튼 이벤트 생성
            box[i].addActionListener(this);
        }

    }



    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start){
            time_jlb.setText("시간 => 0:10");
            jlb.setText("점수 : 0");
            count=-1;
            Thread th = new Thread(this);
            th.start();
            on_button();
            random(0);

        }

        for(int i=0; i<12; ++i){
            if (e.getSource() == box[i]){
                random(i);
            }
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
//        글자 message= new 글자();


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
                    System.out.println("");
                    System.out.println("제한시간을 초과했습니다.");
                    System.out.println("");
                    System.out.println("");

//					Music failed1 = new Music("failed.mp3",false);  // 버튼 클릭
//					failed1.start();

                    System.out.println("미션 실패입니다.\n");
                    Thread.sleep(1000);
//                    message.show_fail();
                    Thread.sleep(1000);
                    System.out.println("");
                    System.out.println("재도전을 통해 최종 미션을 수행하세요\n");
                }catch(InterruptedException e){}
                break;
            }
            time_jlb.setText("시간 => 0:0"+time);
        }
    }



    public void random(int i){

//        글자 message= new 글자();
//        그림 fish = new 그림();

        if (i != random_num) {// 랜덤수와 클릭값이 같지 않으면 실패
            off_button();// 잘못 클릭하면 버튼 오프
            try{
                Thread.sleep(1000);//0.5초 쉬었다가
                dispose(); // 자동 창닫음
                a=0;
                System.out.println("");
//				Music failed1 = new Music("failed.mp3",false);  // 버튼 클릭
//				failed1.start();
                System.out.println("실패입니다.");
//                message.show_fail();
                System.out.println("재도전을 통해 최종 미션을 수행하세요");
            }catch(InterruptedException e){}
            return;
        }

        count++;// 점수 높이기
        box[random_num].setIcon(null); // 맞춘거 이미지 지우기
        random_num = (int)(Math.random() * 12);//랜덤 수 생성
        box[random_num].setIcon(ii); // 박스 랜덤값 위치에 이미지 새로 띄우기
        jlb.setText("점수 : " + count);

        if(count==10) {// 10점 넘으면 성공
            try {
                dispose();
                System.out.println("");
//				Music success = new Music("success.mp3",false);  // 버튼 클릭
//				success.start();
                System.out.println("최종 미션 성공입니다!!\n");
                Thread.sleep(1000);
                System.out.println("생선을 획득하였습니다.\n");
//                fish.show_fish();
                Thread.sleep(1000);
                System.out.println("");
                System.out.println("자식냥이들에게 무사히 생선을 배달하였습니다.\n");
                System.out.println("");
                Thread.sleep(1000);
//                message.show_HAPPY();
                System.exit(0);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

    }

    public static void main(String[] args)
    {
        fishgame2 G = new fishgame2("2");
    }

}