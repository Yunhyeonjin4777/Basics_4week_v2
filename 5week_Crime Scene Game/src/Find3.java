import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Find3 extends JFrame {

    int rand_arrow[] = new int[6];
    int key = 0;
    JLabel label[] = new JLabel[6];
    JLabel succORfail = new JLabel();
    JLabel time = new JLabel("");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();

    timerRun runnable = new timerRun(time, succORfail, 5);
    Thread th = new Thread(runnable);

    private JPanel contentPanel;

    public void game()
    {

        for(int i = 0; i < 6; i++)
        {
            label[i] = new JLabel("");
        }
        for(int i = 0; i < 6; i++)
        {
            rand_arrow[i] = (int)(Math.random() * 3);

            if (rand_arrow[i] == 0) {
                label[i].setIcon(new ImageIcon("right.png"));
            } else if (rand_arrow[i] == 1) {
                label[i].setIcon(new ImageIcon("left.png"));
            } else if (rand_arrow[i] == 2) {
                label[i].setIcon(new ImageIcon("up.png"));
            } else {
                label[i].setIcon(new ImageIcon("down.png"));
            }
        }
        setTitle("증거찾기");
        setSize(400,150);
        setLocation(1100,100); //프레임 생성 위치
        setVisible(true); //프레임활성화여부
        setResizable(false); //사이즈 고정

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        panel.setBounds(38, 20, 414, 155);
        contentPanel.add(panel);
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


        panel.setBounds(38, 185, 414, 73);
        contentPanel.add(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
        time.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(time);

        succORfail.setFont(new Font("돋움", Font.PLAIN, 40));
        succORfail.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(succORfail);

        addKeyListener(new Find3.MyKeyListener());
        time.setFont(new Font("맑은 고딕", Font.ITALIC, 40));

        th.start();


    }

    class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

            if (succORfail.getText().equals("Fail !")) {

            } else {
                if (key >= 0) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        if (rand_arrow[key] == 2) {
                            label[key].setIcon(new ImageIcon(""));
                            key++;
                        } else {   // 실패
                            succORfail.setText("Fail !");
                            th.interrupt();
                            key = -1;
                            JOptionPane.showMessageDialog(null, "상대 소에게 패배하였습니다.");
                            dispose();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (rand_arrow[key] == 3) {
                            label[key].setIcon(new ImageIcon(""));
                            key++;
                        } else {
                            succORfail.setText("Fail !");
                            th.interrupt();
                            key = -1;
                            JOptionPane.showMessageDialog(null, "상대 소에게 패배하였습니다.");
                            dispose();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (rand_arrow[key] == 0) {
                            label[key].setIcon(new ImageIcon(""));
                            key++;
                        } else {
                            succORfail.setText("Fail !");
                            th.interrupt();
                            key = -1;
                            JOptionPane.showMessageDialog(null, "상대 소에게 패배하였습니다.");
                            dispose();
                        }
                    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (rand_arrow[key] == 1) {
                            label[key].setIcon(new ImageIcon(""));
                            key++;
                        } else {
                            succORfail.setText("Fail !");
                            th.interrupt();
                            key = -1;
                            JOptionPane.showMessageDialog(null, "상대 소에게 패배하였습니다.");
                            dispose();
                        }
                    }

                    if (key == 6) {
                        succORfail.setText("Success !");
                        th.interrupt();
                        key = -1;
                        JOptionPane.showMessageDialog(null, "상대 소에게 승리하여 원과 뱃지를 획득 하였습니다.");
                        dispose();
                    }
                } else {
                }
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
    int key;

    public timerRun(JLabel timerLabel,JLabel resultLabel, int second){
        this.timerLabel=timerLabel; // 현재 시간이 출력된 레이블
        this.resultLabel=resultLabel;
        this.second=second;

    }

    public void run(){   // 스레드 코드로서 start() 메소드에 의해 스레드가 실행을 시작하는 코드
        while(true){

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