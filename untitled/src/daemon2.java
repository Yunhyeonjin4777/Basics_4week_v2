public class daemon2 implements Runnable{
    public static void main(String[] args)
    {
        daemon2 daemon = new daemon2();
        Thread th1 = new Thread(daemon);
        th1.start();
    }

    public void run()
    {
        try{
            for(int i = 0; i <= 5; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        }catch (InterruptedException e){}
    }
}
