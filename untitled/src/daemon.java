public class daemon implements Runnable{
    static boolean effDown = false;

    public static void main(String[] args)
    {
        Thread T = new Thread(new daemon());
        //1. 쓰레드객체생성, 런이라는 메소드를 가지고 있는 클래스의 객체를 매개변수로 준것
        T.setDaemon(true); //2.이 쓰레드가 데몬쓰레드가 되도록 지정
        T.start(); //3. 실행

        for(int i = 0; i < 10; i++)
        {
            try{
                Thread.sleep(1000);//1초마다 카운트를 하다가
            }catch (InterruptedException e){}
            System.out.println(i);

            if(i == 5) effDown = true;
            //5초후 effdown가 true가 된다
        }
        System.out.println("프로그램 종료");
    }
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000); //3초마다
            } catch (InterruptedException e) {}

            if (effDown) effDown();
            //effdown의 값이 ture이면 effdown을 호출해라

        }
    }

    public void effDown()
    {
        System.out.println("효력이 감소하였습니다");
    }
}