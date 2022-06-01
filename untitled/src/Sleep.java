/*public class Sleep extends ThreadSleep1 {
    public static void main(String[] args)
    {
        ThreadSleep1 th1 = new ThreadSleep1(); //1.쓰레드 객체 생성
        th1.start();

        delay(); //th1을 2초동안 잠자게
        System.out.println("<메인 종료>");
    }
    static void delay()
    {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException ignored) {}
    }
}


class ThreadSleep1{ //2.작업내용
    public void run()
    {
        for(int i = 0; i < 300; i++)
        {
            System.out.println("-");
            System.out.println("<<th1종료>>");
        }
    }
}
*/
