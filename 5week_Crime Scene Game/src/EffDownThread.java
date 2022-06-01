//public class EffDownThread implements Runnable{
//
//
//    static boolean effDown = false;
//
//    public void run()
//    {
//        while (true)
//        {
//            try
//            {
//                Thread.sleep(5 * 1000);
//            } catch (InterruptedException e) {}
//            if (effDown) effDown();
//        }
//    }
//    public int effDown()
//    {
//        NPC_1.eff -= 1;
//    }
//}
