public class effEvidence implements Runnable{
    static boolean effDown = false;

    String name;
    String Description;
    int eff;
    int progress;

    effEvidence(String name, String Des, int eff, int progress)
    {
        this.name = name;
        this.Description = Des;
        this.eff = eff;
        this.progress = progress;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(5 * 1000); //3초마다
            } catch (InterruptedException e) {}

            this.eff -= 1;
            System.out.println("데몬쓰레드가 실행중입니다." + this.eff);
//            if (effDown) effDown();
        }
    }
//    public void effDown()
//    {
//        this.eff -= 1;
//        System.out.println("효력이 감소하였습니다" + this.eff + "현재 효력");
//    }

    String effEvidenceInfo()
    {
        String info = Description;
        if(0<eff)
            info += "효력 : " + this.eff;
        return info;
    }
}
