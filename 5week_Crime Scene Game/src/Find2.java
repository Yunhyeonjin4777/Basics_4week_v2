import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Find2 extends JFrame implements ActionListener, Runnable{

    String[] evidence = new String[3];
    JLabel[] game_label = new JLabel[3];

    private JButton start = new JButton("시작");
    private JLabel time_jlb = new JLabel("시간 => 0:10");
    private int count = -1;// 점수
    private int a = 1;

    public Find2(String Title)
    {
        super(Title);// 타이틀바
        this.init();// 타이틀바
        this.start();
        // 띄워지는 창 설정
        super.setSize(800,800);//팝업되는 창의 크기 조절
        super.setLocation(500, 150);//모니터상에 표시되는 위치
        super.setVisible(true); // 창을 보여줄것인지
        this.setAlwaysOnTop(true);


        for(int i = 0; i < 9; i++)
        {
            game_label[i] = new JLabel("");
        }
        evidence[0] = new String("칼");
        evidence[1] = new String("철장");
        evidence[2] = new String("나이프");
    }

    public void init()
    {
        Container con = this.getContentPane();
        con.add("North", time_jlb);
    }

    public void start()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// X버튼 클릭시 종료
        start.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == start)
        {
            time_jlb.setText("시간 => 0:10");
            count=-1;
            Thread th = new Thread(this);
            th.start();
        }
    }

    public void run()
    {
        int time = 10;
        while(true)
        {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){}

            time--;

            if (a==0) {
                break;
            }
            if (time == 0)
            {
                time_jlb.setText("제한시간을 초과했습니다.");
                try
                {
                    Thread.sleep(500);
                    dispose();
                    System.out.println("제한시간을 초과했습니다.");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("미션 실패입니다.\n");
                    Thread.sleep(1000);
                }catch(InterruptedException e){}
                break;
            }
            time_jlb.setText("시간 => 0:0"+time);
        }
    }

    public void random(int i)
    {

    }

    public class game extends JFrame
    {
        int a; //인자값
        int rand_arrow[] = new int[6];
        int key = 0;
        JLabel label[] = new JLabel[6];
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel succORfail = new JLabel();
        JLabel timelabel = new JLabel("");

        timerRun runnable= new timerRun(timelabel,succORfail,5);
        Thread th= new Thread(runnable);

        private JPanel contentPane;

        public game(int a) //속성
        {
            this.a = a;
            for(int i = 0; i < 6; i++)
            {
                label[i] = new JLabel("");
            }
            for(int i = 0; i < 6; i++)
            {
                rand_arrow[i] = (int)(Math.random()*3);
                if(rand_arrow[i] == 0)
                {
                    label[i].setIcon(new ImageIcon("right.png"));
                }
                else if(rand_arrow[i] == 1)
                {
                    label[i].setIcon(new ImageIcon("left.png"));
                }
                else if(rand_arrow[i] == 2)
                {
                    label[i].setIcon(new ImageIcon("up.png"));
                }
                else
                    label[i].setIcon(new ImageIcon("down.png"));
            }
            setTitle("증거 찾기 Game");
            setBounds(100, 100, 519, 326);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            panel.setBounds(38, 20, 414, 155);
            contentPane.add(panel);
            panel.setLayout(new GridLayout(1, 0, 0, 0));

            JPanel panel_2 = new JPanel();
            panel.add(panel_2);

            panel_2.add(label[0]);
            panel_2.setLayout(new GridLayout(1, 0, 0, 0));

            JPanel panel_3 = new JPanel();
            panel.add(panel_3);
            panel_3.setLayout(new GridLayout(1, 0, 0, 0));
            panel_3.add(label[1]);

            JPanel panel_4 = new JPanel();
            panel.add(panel_4);
            panel_4.setLayout(new GridLayout(1, 0, 0, 0));
            panel_4.add(label[2]);

            JPanel panel_5 = new JPanel();
            panel.add(panel_5);
            panel_5.setLayout(new GridLayout(1, 0, 0, 0));
            panel_5.add(label[3]);

            JPanel panel_6 = new JPanel();
            panel.add(panel_6);
            panel_6.setLayout(new GridLayout(1, 0, 0, 0));
            panel_6.add(label[4]);

            JPanel panel_7 = new JPanel();
            panel.add(panel_7);
            panel_7.setLayout(new GridLayout(1, 0, 0, 0));
            panel_7.add(label[5]);


            panel1.setBounds(38, 185, 414, 73);
            contentPane.add(panel1);
            panel1.setLayout(new GridLayout(1, 0, 0, 0));
            timelabel.setHorizontalAlignment(SwingConstants.CENTER);

            panel1.add(timelabel);

            succORfail.setFont(new Font("돋움", Font.PLAIN, 40));
            succORfail.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(succORfail);

            addKeyListener(new MyKeyListener());
            timelabel.setFont(new Font("맑은 고딕", Font.ITALIC, 40));

            th.start();
        }
        class MyKeyListener extends KeyAdapter
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
//            if(Main2.Find == null)
//            {
//                return; //키보드 입력 무력화
//            }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    if(rand_arrow[key]==0)
                    {
                        label[key].setIcon(new ImageIcon(""));
                        key++;
                    }
                    else
                        succORfail.setText("fail!");
                    th.interrupt();
                    key =- 1;
                    JOptionPane.showMessageDialog(null, "패배하였습니다.");
                    dispose();
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    if(rand_arrow[key]==1)
                    {
                        label[key].setIcon(new ImageIcon(""));
                        key++;
                    }
                    else
                        succORfail.setText("fail!");
                    th.interrupt();
                    key =- 1;
                    JOptionPane.showMessageDialog(null, "패배하였습니다.");
                    dispose();
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP)
                {
                    if(rand_arrow[key]==2)
                    {
                        label[key].setIcon(new ImageIcon(""));
                        key++;
                    }
                    else
                        succORfail.setText("fail!");
                    th.interrupt();
                    key =- 1;
                    JOptionPane.showMessageDialog(null, "패배하였습니다.");
                    dispose();
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    if(rand_arrow[key]==3)
                    {
                        label[key].setIcon(new ImageIcon(""));
                        key++;
                    }
                    else
                        succORfail.setText("fail!");
                    th.interrupt();
                    key =- 1;
                    JOptionPane.showMessageDialog(null, "패배하였습니다.");
                    dispose();
                }
                if(key == 6)
                {
                    succORfail.setText("SUCCESS!");
                    th.interrupt();
//                    main.me.make돋보기(1000);
                    key=-1;
//                    main.me.evidence[a] = true;//증거획득
                    JOptionPane.showMessageDialog(null, "성공하여 돋보기 1000개와 증거를 얻었습니다");
                    dispose();
                }

            }
        }
    }

    class timerRun implements Runnable
    {
        JLabel timerLabel;
        JLabel resultLabel;
        int second;
        int ms=0;

        public timerRun(JLabel timerLabel,JLabel resultLabel, int second) {
            this.timerLabel = timerLabel; // 현재 시간이 출력된 레이블
            this.resultLabel = resultLabel;
            this.second = second;
        }

        public void run()
        {
            while(true)
            {
                StringBuffer clockText =new StringBuffer();

                clockText = clockText.append("0");
                // 값이 10보다 작을 경우 0을 먼저 붙여줌
                clockText = clockText.append(Integer.toString(second));
                clockText = clockText.append(":");
                if(ms<10) clockText = clockText.append("0");
                clockText = clockText.append(Integer.toString(ms));

                if(ms==0)
                {
                    second--;
                    ms=99;
                }
                else
                    ms--;

                if(second==0&ms==0)
                {
                    StringBuffer clockText1 =new StringBuffer("00:00");
                    timerLabel.setText(clockText1.toString());
                    resultLabel.setText("Fail !");
                    break;
                }
                timerLabel.setText(clockText.toString());

                try{   // 과도한 메모리 사용을 막기 위해 1초씩 잠들게 함
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    return;
                }
            }
        }
    }
}
