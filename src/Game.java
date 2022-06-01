import java.util.Scanner;

public class Game {

    public void GameStart(int delimiter)
    {
        Scanner scanner = new Scanner(System.in);
        String[] gametext = new String[50];
        String text;

        gametext[0]="자상이여러군데있을경우원한에의한살가능성이높다";
        gametext[1]="조직적인보험사기기승고의사고로보험금꿀꺽";
        gametext[2]="강박적인성향우울증키운다우울증극복은?";
        gametext[3]="영화가족상영잘못된모성애가빚어낸비극";
        gametext[4]="모든범죄는흔적을남긴다";
        gametext[5]="고온의보일러는시신의체온하강을늦출수있다";
        gametext[6]="가장믿음이가는사람이가장의심이가는사람이다";
        gametext[7]="피해자는왜소한체격이다";
        gametext[8]="눈에보이는게전부는아니다";
        gametext[9]="범죄가또다범죄로가려진다";
        gametext[10]="자상이여러군데있을경우원한에의한살가능성이높다";
        gametext[11]="조직적인보험사기기승고의사고로보험금꿀꺽";
        gametext[12]="강박적인성향우울증키운다우울증극복은?";
        gametext[13]="영화가족상영잘못된모성애가빚어낸비극";
        gametext[14]="모든범죄는흔적을남긴다";
        gametext[15]="고온의보일러는시신의체온하강을늦출수있다";
        gametext[16]="가장믿음이가는사람이가장의심이가는사람이다";
        gametext[17]="피해자는왜소한체격이다";
        gametext[18]="눈에보이는게전부는아니다";
        gametext[19]="범죄가또다범죄로가려진다";


        for(int i = 0; i < delimiter; i++)
        {
            System.out.println("해당 문장을 입력하시요");
            System.out.println(gametext[i]);
            text = scanner.next();

            if(gametext[i].equals(text))
            {
                System.out.println("맞았습니다");
            }
            else if(!gametext[i].equals(text))
            {
                i--;
                System.out.println("틀렸습니다!");
            }
        }
    }

}

