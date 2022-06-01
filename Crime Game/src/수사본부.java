import java.util.Random;

public class 수사본부 extends 장소{

    public 수사본부(String name) {
        super(name);
    }

    public String[] Player_팀원 = new String[10];

    public void 자료분석을한다(Player PC,팀원 팀원, ProfileLog profileLog, Evidence[][] evidence)
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(profileLog); //취조노트
        System.out.println(" ");
        System.out.println("          ╭──────────────────────<수사본부>──────────────────────╮");
        System.out.println("                 ☞ [1] 나가기  [2] 나의상세정보  [3] 인력충원");
        System.out.println("          ╰────────────────────────────────────────────────────╯");
        System.out.println(" ");
        choice = scanner.nextInt();

        battle:
        while(true)
        {
            if(choice == 1)//나가기
            {
                break;
            }
            else if(choice == 2)//나의정보
            {
                PC.showInfo();
                //일반증거
                System.out.println(" ");
                System.out.println("╭───────<MY 팀원>───────╮");
                for(int i = 0; i < Player_팀원.length; i++)
                {
                    if(Player_팀원[i] != null)
                    {
                        System.out.println(Player_팀원[i]);
                    }
                }
                System.out.println("╰──────────────────────╯");
                choice = scanner.nextInt();

                if(choice == 1)
                {
                    break;
                }
            }
            else if(choice == 3)//인력충원
            {
                팀원정보보기(팀원);
                인력충원(PC, 팀원, evidence);
                break;
            }
            else
            {
                System.out.println("올바른 키를 입력해주시기 바랍니다");
            }
        }//while(true)
    }

    public void 인력충원(Player PC, 팀원 팀원, Evidence[][] evidence)
    {
        System.out.println(" ");
        System.out.println("               ╭──────────────────────<인력충원>──────────────────────╮");
        System.out.println("                           ❝ 고용하고자 하는 팀원을 선택하세요 ❞");
        System.out.println(" ");
        System.out.println("                             ☞ [1] 나가기     [2] 현장감식원");
        System.out.println("                             ☞ [3] 프로파일러  [4] 법의학자");
        System.out.println("               ╰────────────────────────────────────────────────────╯");
        System.out.println(" ");
        choice = scanner.nextInt();

        while (true)
        {
            if(choice == 1)
            {
                System.out.println("수사본부에서 나왔습니다");
                break;
            }
            else if(choice == 2)
            {
                현장감식원고용(PC, 팀원, evidence);
                break;
            }
            else if(choice == 3)
            {
                프로파일러고용(PC, 팀원, evidence);
                break;
            }
            else if(choice == 4)
            {
                법의학자고용(PC, 팀원, evidence);
                break;
            }
            else
            {
                System.out.println("올바른 키를 입력해주시기 바랍니다");
            }
        }
    }

    public void 현장감식원고용(Player PC,팀원 팀원, Evidence[][] evidence)
    {
        //돋보기감소
        if(PC.돋보기 >= 200)
        {
            if(Player_팀원[0] == null)
            {
                System.out.println("현장감식원을 고용하였습니다");
                Player_팀원[0] = "        현장감식원";
                PC.현장감식원고용(PC);
                인력충원(PC, 팀원, evidence);
                현장감식원th(PC,evidence);
            }
            else if(Player_팀원[0] != null)
            {
                System.out.println("이미 현장감식원을 고용하였습니다");
                인력충원(PC, 팀원, evidence);
            }
        }
        else if(PC.돋보기<200)
        {
            System.out.println("돋보기가 부족하여 인력 충원을 할 수 없습니다");
        }

        현장감식원th(PC, evidence);
    }
    public void 프로파일러고용(Player PC,팀원 팀원, Evidence[][] evidence)
    {
        if(PC.돋보기 >= 300)
        {
            if(Player_팀원[1] == null)
            {
                System.out.println("프로파일러를 고용하였습니다");
                Player_팀원[1] = "        프로파일러";
                PC.프로파일러고용(PC);
                인력충원(PC, 팀원, evidence);
                프로파일러th(PC,evidence);
            }
            else if(Player_팀원[1] != null)
            {
                System.out.println("이미 프로파일러을 고용하였습니다");
                인력충원(PC, 팀원, evidence);
            }
        }
        else if(PC.돋보기<300)
        {
            System.out.println("돋보기가 부족하여 인력 충원을 할 수 없습니다");
        }
    }
    public void 법의학자고용(Player PC,팀원 팀원, Evidence[][] evidence)
    {
        if(PC.돋보기 >= 400)
        {
            if(Player_팀원[2] == null)
            {
                System.out.println("법의학자을 고용하였습니다");
                Player_팀원[2] = "        법의학자";
                PC.법의학자고용(PC);
                인력충원(PC, 팀원, evidence);
                법의학자th(PC,evidence);
            }
            else if(Player_팀원[2] != null)
            {
                System.out.println("이미 법의학자을 고용하였습니다");
                인력충원(PC, 팀원, evidence);
            }
        }
        else if(PC.돋보기<200)
        {
            System.out.println("돋보기가 부족하여 인력 충원을 할 수 없습니다");
        }
    }

    public Thread 현장감식원스킬;
    public Thread 프로파일러스킬;
    public Thread 법의학자스킬;

    Random random = new Random();

    public void 현장감식원th(Player PC, Evidence[][] evidence)
    {
        현장감식원스킬 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try
                    {
                        Thread.sleep(3 * 1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    PC.돋보기 += 5;
                    int i = random.nextInt(500);
                    if(i < 2)
                    {
                        System.out.println(
                                "　　 ∩＿＿_∩\n" +
                                "　　|　　   | \n" +
                                "　 /　●　 ● ＼\n" +
                                "　｜　 (_●_)ミ\n" +
                                "　彡､　|∪| ､`|\n" +
                                "`/ ＿＿ヽノ />　)\n" +
                                "(＿＿＿)　 /(_／\n" +
                                "　|　　　 /\n" +
                                "　|　／＼ ＼\n" +
                                "　| /　　)　)\n" +
                                "　∪　 　(　＼\n" +
                                "　　　　  ＼＿)");
                        System.out.println(" ");
                        System.out.println("<현장감식원> : 혀.형사님! 새로운 증거를 찾았습니다!");
                        System.out.println(" ");
                        PC.get현장증거(evidence[0][5]);
                    }

                }
            }
        });
        현장감식원스킬.start();
    }
    public void 프로파일러th(Player PC, Evidence[][] evidence)
    {
        프로파일러스킬 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try
                    {
                        Thread.sleep(3 * 1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    PC.돋보기 += 5;
                    int i = random.nextInt(500);
                    if(i < 2)
                    {
                        System.out.println(
                                        "　　 ∩＿＿_∩\n" +
                                        "　　|　　   | \n" +
                                        "　 /　●　 ● ＼\n" +
                                        "　｜　 (_●_)ミ\n" +
                                        "　彡､　|∪| ､`|\n" +
                                        "`/ ＿＿ヽノ />　)\n" +
                                        "(＿＿＿)　 /(_／\n" +
                                        "　|　　　 /\n" +
                                        "　|　／＼ ＼\n" +
                                        "　| /　　)　)\n" +
                                        "　∪　 　(　＼\n" +
                                        "　　　　  ＼＿)");
                        System.out.println(" ");
                        System.out.println("<프로파일러> : 혀.형사님! 새로운 증거를 찾았습니다!");
                        System.out.println(" ");
                        PC.get현장증거(evidence[0][6]);
                    }

                }
            }
        });
        프로파일러스킬.start();
    }
    public void 법의학자th(Player PC, Evidence[][] evidence)
    {
        법의학자스킬 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try
                    {
                        Thread.sleep(3 * 1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    PC.돋보기 += 5;
                    int i = random.nextInt(500);
                    if(i < 2)
                    {
                        System.out.println(
                                        "　　 ∩＿＿_∩\n" +
                                        "　　|　　   | \n" +
                                        "　 /　●　 ● ＼\n" +
                                        "　｜　 (_●_)ミ\n" +
                                        "　彡､　|∪| ､`|\n" +
                                        "`/ ＿＿ヽノ />　)\n" +
                                        "(＿＿＿)　 /(_／\n" +
                                        "　|　　　 /\n" +
                                        "　|　／＼ ＼\n" +
                                        "　| /　　)　)\n" +
                                        "　∪　 　(　＼\n" +
                                        "　　　　  ＼＿)");
                        System.out.println(" ");
                        System.out.println("<법의학자> : 혀.형사님! 새로운 증거를 찾았습니다!");
                        System.out.println(" ");
                        PC.get현장증거(evidence[0][7]);
                    }

                }
            }
        });
        법의학자스킬.start();
    }

//    public void 허둥지둥조수고용(Player PC,팀원 팀원)
//    {
//        if(PC.돋보기 >= 200)
//        {
//            if(Player_팀원[3] == null)
//            {
//                System.out.println("허둥지둥조수을 고용하였습니다");
//                Player_팀원[0] = "허둥지둥조수";
//                PC.허둥지둥조수고용(PC);
//                인력충원(PC, 팀원);
//            }
//            else if(Player_팀원[3] != null)
//            {
//                System.out.println("이미 허둥지둥조수을 고용하였습니다");
//                인력충원(PC, 팀원);
//            }
//        }
//        else if(PC.돋보기<200)
//        {
//            System.out.println("돋보기가 부족하여 인력 충원을 할 수 없습니다");
//        }
//    }
//    public void 영상분석가고용(Player PC,팀원 팀원)
//    {
//        if(PC.돋보기 >= 500)
//        {
//            if(Player_팀원[5] == null)
//            {
//                System.out.println("영상분석가을 고용하였습니다");
//                Player_팀원[0] = "영상분석가";
//                PC.영상분석가고용(PC);
//                인력충원(PC, 팀원);
//            }
//            else if(Player_팀원[5] != null)
//            {
//                System.out.println("이미 영상분석가을 고용하였습니다");
//                인력충원(PC, 팀원);
//            }
//        }
//        else if(PC.돋보기<500)
//        {
//            System.out.println("돋보기가 부족하여 인력 충원을 할 수 없습니다");
//        }
//    }

    public void 팀원정보보기(팀원 팀원)
    {
        팀원.현장감식원();
        팀원.프로파일러();
//        팀원.허둥지둥조수();
        팀원.법의학자();
//        팀원.영상분석가();
    }
}
