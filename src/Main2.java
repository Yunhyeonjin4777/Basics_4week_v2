import java.security.PublicKey;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args)
    {
        start();
    }

    static void start()
    {
        Player2 PC2 = new Player2("현진", 50, 50, 50, 10);
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while(true)
        {
            System.out.println("1.내정보\n2.사냥\n종료");
            input = scanner.nextInt();

            switch (input)
            {
                case 1:
                    PC2.showInfo2();
                    break;
                case 2:
                    hunt(PC2);
                    break;
                case 3:
                    System.out.println("종료되었습니다.");
                    System.exit(0);
                    break;}
        }
    }
    static void hunt(Player2 PC2)
    {
        Evidence2[] evidence2s = new Evidence2[10];
        evidence2s[0] = new Evidence2("보험", "다수의 보험 가입내역", 5);
        thesuspect2 suspect = new thesuspect2("보험설계사", 100,100,10,new Evidence2[]{evidence2s[0]});
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        battle : while(true){
            System.out.println("1.공격\t2.도망");
            input = scanner.nextInt();
            switch (input)
            {
                case 1:
                    PC2.attack(suspect);
                    if(suspect.hp <= 0)
                    {
                        System.out.println(suspect.name + "의 정보를 얻었습니다");
                        PC2.getexp2(20);
                        PC2.getevidence(suspect.evidence2drop());
                        break battle;
                    }
                    suspect.attack(PC2);
                    break;

                case 2:
                    break battle;
            }
        }
    }
}
