/*public class Main {
    public static Time_game Time_game;

    public static void main(String[] args) throws InterruptedException {

        Music introMusic = new Music("introMusic.mp3", true); // 배경음악
        Time_game = new Time_game(); // 제한시간 10초 생성

        introMusic.start();
        Time_game = new Time_game();
        Time_game.start();
        introMusic.close();

        while(true)
        {
            if (Time_game.time() == 10)
            {
                System.out.println("타임오버");
            }
        }

    }
}
*/
