/*import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread{
    private Player player;
    private boolean isLoop; //현재 곡인지 무한반복인지 아닌지 설정
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop) //곡의 제목, 무한반복여부
    {
        try
        {
            this.isLoop = isLoop;
            file = new File("music/" + name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis); //해당파일을 버퍼에 담아서 읽어올 수 있도록
            player = new Player(bis); //해당 파일을 담을 수 있도록

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int getTime() //현재실행되고 있는 음악이 현재 어떤 위치에서 실행되는지 알려줌
    {
        if(player == null)
            return 0;
        return player.getPosition();

    }

    public void close()//음악이 언제 실행되고 있든 간에 항상 종료할 수 있도록 함
    {
        isLoop = false;
        player.close();
        this.interrupt();
    }
    @Override //Thread를 상속받으면 무조건 사용해야하는 메소드
    public void run()
    {
        try{
            do{
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop); //isLoop가 true값이라면 무한반복
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
*/
