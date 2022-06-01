import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Find5 extends JFrame implements ActionListener, Runnable
{
    int[] rand_arrow = new int[6];
    int key = 0;

    private final JButton start = new JButton("시작");
    private final JLabel[] 화살표집 = new JLabel[6];//배열
    private final JLabel succORfail = new JLabel();
    private final JLabel time = new JLabel("0:10");
    private final JPanel panel = new JPanel();

    private JPanel contentPanel;


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

    public Find5 (String title)
    {
        super(title);// 타이틀바
        this.init();// 타이틀바
        this.start();
        // 띄워지는 창 설정
        super.setSize(500,500);//팝업되는 창의 크기 조절
        super.setLocation(1000, 300);//모니터상에 표시되는 위치
        super.setVisible(true); //프레임활성화여부
        this.setAlwaysOnTop(true);
//        setResizable(false); //사이즈 고정
    }

    public void init(){//버튼 위치 지정
        Container con = this.getContentPane();
//        con.setLayout(bl);
        con.add("North", time);
//        con.add("Center", jp1);
//        jp1.setLayout(gl1); //GridLayout

//        off_button();//비활성 버튼 호출
//        con.add("South", jp2);
        jp2.setLayout(gl2);
        jp2.add(time);
        jp2.add(jp21);
        jp21.setLayout(fl21);
        jp21.add(start);

        for(int i = 0; i < 6; i++)
        {
            화살표집[i] = new JLabel("");
        }
        for(int i = 0; i < 6; i++)
        {
            rand_arrow[i] = (int)(Math.random() * 3);

            if (rand_arrow[i] == 0) {
                화살표집[i].setIcon(new ImageIcon("Right.png"));
            } else if (rand_arrow[i] == 1) {
                화살표집[i].setIcon(new ImageIcon("Left.png"));
            } else if (rand_arrow[i] == 2) {
                화살표집[i].setIcon(new ImageIcon("UP.png"));
            } else {
                화살표집[i].setIcon(new ImageIcon("Down.png"));
            }
        }

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        panel.setBounds(38, 20, 414, 155);
        contentPanel.add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_2 = new JPanel();
        panel.add(panel_2);

        panel_2.add(화살표집[0]);
        panel_2.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(1, 0, 0, 0));
        panel_3.add(화살표집[1]);

        JPanel panel_4 = new JPanel();
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 0, 0, 0));
        panel_4.add(화살표집[2]);

        JPanel panel_5 = new JPanel();
        panel.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 0, 0, 0));
        panel_5.add(화살표집[3]);

        JPanel panel_6 = new JPanel();
        panel.add(panel_6);
        panel_6.setLayout(new GridLayout(1, 0, 0, 0));
        panel_6.add(화살표집[4]);

        JPanel panel_7 = new JPanel();
        panel.add(panel_7);
        panel_7.setLayout(new GridLayout(1, 0, 0, 0));
        panel_7.add(화살표집[5]);

//        panel.setBounds(38, 185, 414, 73);
//        contentPanel.add(panel);
//        panel.setLayout(new GridLayout(1, 0, 0, 0));
//        time.setHorizontalAlignment(SwingConstants.CENTER);

        succORfail.setFont(new Font("돋움", Font.PLAIN, 40));
        succORfail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(succORfail);

        addKeyListener(new Find5.MyKeyListener());

    }
    public void start(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 종료
        start.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start){
            time.setText("0:10");
            count=-1;
            Thread th = new Thread(this);
            th.start();
//            on_button();
//            random(0);

        }
    }

//    public void on_button(){//버튼 활성화
//        for(int i=0; i<6; ++i){
//            화살표집[i].setEnabled(true);
//        }
//    }
//    public void off_button(){//버튼 비활성화
//        for(int i=0; i<6; ++i){
//            화살표집[i].setEnabled(false);
//        }
//
//    }

    public void run(){// 초 세기
        int t = 10;
//        글자 message= new 글자();

        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}

            t--;
            if (a==0) {
                break;
            }
            if (t == 0) {
                time.setText("제한시간을 초과했습니다.");
//                off_button();
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
            time.setText("시간 => 0:0"+t);
        }
    }

    class MyKeyListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                if (rand_arrow[key] == 2)
                {
                    화살표집[key].setIcon(new ImageIcon(""));
                    key++;
                }else{ // 실패
                    succORfail.setText("Fail !");
                    key = -1;
                    dispose(); // 자동 창닫음
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                if (rand_arrow[key] == 3) {
                    화살표집[key].setIcon(new ImageIcon(""));
                    key++;
                } else {
                    succORfail.setText("Fail !");
                    key = -1;
                    dispose();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if (rand_arrow[key] == 0) {
                    화살표집[key].setIcon(new ImageIcon(""));
                    key++;
                } else {
                    succORfail.setText("Fail !");
                    key = -1;
                    dispose();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                if (rand_arrow[key] == 1) {
                    화살표집[key].setIcon(new ImageIcon(""));
                    key++;
                } else {
                    succORfail.setText("Fail !");
                    key = -1;
                    dispose();
                }
            }
            if (key == 6) {
                try
                {
                    succORfail.setText("Success !");
                    key = -1;
                    dispose();
                    System.out.println("최종 미션 성공입니다!!\n");
                    Thread.sleep(1000);
                    System.out.println("생선을 획득하였습니다.\n");
                    Thread.sleep(1000);

                }
                catch (InterruptedException j)
                {j.printStackTrace();}
                return;
            }
        }
    }
//    public void random(int i){
//
//        if (i != random_num) {// 랜덤수와 클릭값이 같지 않으면 실패
//            off_button();// 잘못 클릭하면 버튼 오프
//            try{
//                Thread.sleep(1000);//0.5초 쉬었다가
//                dispose(); // 자동 창닫음
//                a=0;
//                System.out.println("");
////				Music failed1 = new Music("failed.mp3",false);  // 버튼 클릭
////				failed1.start();
//                System.out.println("실패입니다.");
////                message.show_fail();
//                System.out.println("재도전을 통해 최종 미션을 수행하세요");
//            }catch(InterruptedException e){}
//            return;
//        }
//        count++;// 점수 높이기
//        box[random_num].setIcon(null); // 맞춘거 이미지 지우기
//        random_num = (int)(Math.random() * 12);//랜덤 수 생성
//        box[random_num].setIcon(ii); // 박스 랜덤값 위치에 이미지 새로 띄우기
//
//        if(count==10) {// 10점 넘으면 성공
//            try {
//                dispose();
//                System.out.println("");
//                System.out.println("최종 미션 성공입니다!!\n");
//                Thread.sleep(1000);
//                System.out.println("생선을 획득하였습니다.\n");
//                Thread.sleep(1000);
//                System.out.println("자식냥이들에게 무사히 생선을 배달하였습니다.\n");
//                Thread.sleep(1000);
//                System.exit(0);
//
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return;
//        }
//
//    }

    
}
