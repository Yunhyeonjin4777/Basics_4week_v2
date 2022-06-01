import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {

    static boolean Game성공여부 = false;
    JScrollPane scrollPane;
    ImageIcon icon;

    public Game()
    {

        JPanel panel = new JPanel()
        {
            public void paintComponent(Graphics g)
            { //백그라운드 이미지 삽입시 메소드에 이름없는 클래스로 구현
                g.drawImage(icon.getImage(), 0, 0, 670,355,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        scrollPane = new JScrollPane(panel);
        panel.setLayout(null);

        game frame = new game(0);
        frame.setVisible(true);
        
    }//public Game(Player PC)

    public class game extends JFrame
    {

        Player PC;
        int G; // 메인에서 인자값 전달
        int key = 0;
        int arrow[] = new int[6];

        JLabel label[] = new JLabel[6]; //화살표용
        JLabel succORfail = new JLabel();
        JLabel timelabel = new JLabel("");
        JPanel panel = new JPanel();
        JPanel panel_1 = new JPanel();
        private JPanel contentPane;

        timerRun runnable= new timerRun(timelabel,succORfail,5);
        Thread th= new Thread(runnable);

        public game(int G)
        {
            this.G=G;

            for (int i =  0; i < 6; i++)
            {
                label[i] = new JLabel("");
            }
            for(int i=0;i<6;i++)
            {
                arrow[i]=(int)(Math.random()*3);
                if(arrow[i]==0){
                    label[i].setIcon(new ImageIcon("Right_.png"));
                }
                else if(arrow[i]==1){
                    label[i].setIcon(new ImageIcon("Left_.png"));
                }
                else if(arrow[i]==2){
                    label[i].setIcon(new ImageIcon("UP_.png"));
                }
                else{
                    label[i].setIcon(new ImageIcon("Down_.png"));
                }
            }

            setTitle("과거에서 증거 모으기");
            setBounds(1000, 400, 519, 326);

            //화살표칸넓이
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            //판넬위치
            panel.setBounds(38, 20, 414, 155);
            contentPane.add(panel);
            panel.setLayout(new GridLayout(1, 0, 0, 0));

            //화살표2번 칸
            JPanel panel_2 = new JPanel();
            panel.add(panel_2);
            panel_2.add(label[0]);
            panel_2.setLayout(new GridLayout(1, 0, 0, 0));

            //화살표2번 칸
            JPanel panel_3 = new JPanel();
            panel.add(panel_3);
            panel_3.setLayout(new GridLayout(1, 0, 0, 0));
            panel_3.add(label[1]);

            //화살표3번 칸
            JPanel panel_4 = new JPanel();
            panel.add(panel_4);
            panel_4.setLayout(new GridLayout(1, 0, 0, 0));
            panel_4.add(label[2]);

            //화살표4번 칸
            JPanel panel_5 = new JPanel();
            panel.add(panel_5);
            panel_5.setLayout(new GridLayout(1, 0, 0, 0));
            panel_5.add(label[3]);

            //화살표5번 칸
            JPanel panel_6 = new JPanel();
            panel.add(panel_6);
            panel_6.setLayout(new GridLayout(1, 0, 0, 0));
            panel_6.add(label[4]);

            //화살표6번 칸
            JPanel panel_7 = new JPanel();
            panel.add(panel_7);
            panel_7.setLayout(new GridLayout(1, 0, 0, 0));
            panel_7.add(label[5]);

            panel_1.setBounds(38, 185, 414, 73);
            contentPane.add(panel_1);
            panel_1.setLayout(new GridLayout(1, 0, 0, 0));

            //시간타임 칸
            timelabel.setFont(new Font("맑은 고딕", Font.ITALIC, 40));
            timelabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel_1.add(timelabel);

            //성공또는실패 칸
            succORfail.setFont(new Font("돋움", Font.PLAIN, 40));
            succORfail.setHorizontalAlignment(SwingConstants.CENTER);
            panel_1.add(succORfail);

            addKeyListener(new MyKeyListener());
            th.start();

        } //public game(int G, Player PC)

        class MyKeyListener extends KeyAdapter
        {
            public void keyPressed(KeyEvent e) {

                if(succORfail.getText().equals("실패!")){

                }
                else{
                    if(key>=0){
                        if(e.getKeyCode() == KeyEvent.VK_UP){
                            if(arrow[key]==2){
                                label[key].setIcon(new ImageIcon(""));
                                key++;
                            }
                            else{   // 실패
                                succORfail.setText("실패!");
                                th.interrupt();
                                key=-1;
                                실패문구();
                                JOptionPane.showMessageDialog(null, "증거는 얻지 못했습니다 다음 기회에 도전해 보세요");
                                dispose();
                            }
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                            if(arrow[key]==3){
                                label[key].setIcon(new ImageIcon(""));
                                key++;
                            }
                            else{
                                succORfail.setText("실패!");
                                th.interrupt();
                                key=-1;
                                실패문구();
                                JOptionPane.showMessageDialog(null, "증거는 얻지 못했습니다 다음 기회에 도전해 보세요");
                                dispose();
                            }
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                            if(arrow[key]==0){
                                label[key].setIcon(new ImageIcon(""));
                                key++;
                            }
                            else{
                                succORfail.setText("실패!");
                                th.interrupt();
                                key=-1;
                                실패문구();
                                JOptionPane.showMessageDialog(null, "증거는 얻지 못했습니다 다음 기회에 도전해 보세요");
                                dispose();
                            }
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                            if(arrow[key]==1){
                                label[key].setIcon(new ImageIcon(""));
                                key++;
                            }
                            else{
                                succORfail.setText("실패!");
                                th.interrupt();
                                key=-1;
                                실패문구();
                                JOptionPane.showMessageDialog(null, "증거는 얻지 못했습니다 다음 기회에 도전해 보세요");
                                dispose();
                            }
                        }
                        if(key==6){
                            Game성공여부 = true;
                            succORfail.setText("성공!");
                            th.interrupt();
                            성공문구();
//                            PC.Game돋보기얻기(PC);//돋보기획득
//                            PC.get현장증거(PC); //증거획득

//                            main.me.MakeMoney(10000*(a+1));
//                            game_label[a].setIcon(new ImageIcon(badge[a]));   // 다음 단계 열림 표시
                            key=-1;
//                            main.me.Badge[a]=true;   // 뱃지 획득
                            JOptionPane.showMessageDialog(null, "증거얻기를 성공하여 돋보기 " + 1000 + "개와 결정적 증거를 얻었습니다");
                            dispose();
                        }
                    }
                    else
                    {
                    }
                }
            }
        }//class MyKeyListener extends KeyAdapter

        public boolean Game성공여부()
        {
            return Game성공여부;
        }

        public void 실패문구()
        {
//            PC.Game실패돋보기(PC);

            System.out.println(
                    "　　 /＼　　　  ／∧\n" +
                    "　　/ ∧ ＞.―＜/　|\n" +
                    "　 //／　´ 　　｀uヽ\n" +
                    "　｜ u　 ○　　○　 |\n" +
                    "　/　　　　 ▼ヽ. uヽ\n" +
                    "  ｜　u　ヽ_人_ﾉ　　|\n" +
                    "　 丶　　　|＿|　u　ﾉ\n" +
                    "　./＼u　　　　 　／)\n" +
                    "　/ ＼二二つ⊂二二〟");
            System.out.println("실패! 다음번에 도전해주세요");
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("☞ [1] 돌아가기");
        }

        public void 성공문구()
        {
//            PC.Game성공돋보기(PC);

            System.out.println(
                    "" +
                    ".　　   ハハ\n" +
                    " （(⊂ヽ(ﾟωﾟ) ／⊃))\n" +
                    "　　 ＼/　 ヽ_／\n" +
                    "　＿＿/　  ｜\n" +
                    "　(　＿＿  ｜\n" +
                    "　 ＼＼　＼＼\n" +
                    "　　(／　　/ /\n" +
                    "　　　　　 ＼)");
            System.out.println("오예 성공!! 과거사건현장에서 결정적인 증거를 얻었습니다!");
            System.out.println("수사본부에서 확인해보세요!");
            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("☞ [1] 돌아가기");
        }

    }//public class game extends JFrame

    class timerRun implements Runnable
    {
        JLabel timerLabel;
        JLabel resultLabel;
        int second;
        int ms=0;
        int key;

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

                if(ms==0){
                    second--;
                    ms=99;
                }
                else{
                    ms--;
                }

                if(second==0&ms==0)
                {
                    StringBuffer clockText1 =new StringBuffer("00:00");
                    timerLabel.setText(clockText1.toString());
                    resultLabel.setText("실패!");

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
    }//class timerRun implements Runnable

//    public static void main(String[] args)
//    {
//        Game a = new Game();
//    }

}