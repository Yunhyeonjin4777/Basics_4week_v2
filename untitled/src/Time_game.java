public class Time_game extends Thread{

    private int n = 0;
    private boolean stop;

    Time_game()
    {
        this.stop = false;
    }

    @Override
    public void run()
    {
        while(!stop)
        {
            try
            {
                n++;
                time();
                sleep(1000);

                if(n==10)
                {
                    System.out.println("제한시간이 끝났습니다");
                    stop = true;
                    break;
                }
            }catch(Exception e)
            {
                return;
            }
        }
    }

    public int time()
    {
        return n;
    }

    public static void main(String[] args)
    {
        Time_game 날씨 = new Time_game();
    }

}
