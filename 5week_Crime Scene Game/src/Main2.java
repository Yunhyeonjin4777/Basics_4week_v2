import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class Main2 extends JFrame
{

    private JPanel contentPane;

    public Main2()
    {
        setBounds(100, 100, 670, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel cowsellect = new JPanel();
        cowsellect.setBounds(0, 0, 641, 377);
        contentPane.add(cowsellect);

        JButton btnNewButton = new JButton("시작");
        btnNewButton.setBounds(51, 168, 97, 23);
        btnNewButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Find3 game = new Find3();
                game.setVisible(true);
                dispose();
            }});

        cowsellect.setBackground(Color.WHITE);
        setVisible(true);
    }


    public static void main(String[] args) throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] 과거");
        int choice = scanner.nextInt();

        if(choice == 1)
        {
            Find5 game = new Find5("증거찾기");
        }
    }
}
