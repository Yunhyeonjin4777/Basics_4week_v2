public class 몬스터 extends Thread{

    private boolean stop;

    public 몬스터()
    {
        this.stop = false;
    }

    public void Stop(boolean stop){
        this.stop = stop;
    }
}
