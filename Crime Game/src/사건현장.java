import java.util.Random;

public class 사건현장 extends 장소{

    Random random = new Random();

    public 사건현장(String name) {
        super(name);
    }
    //사건현장
    public void 사건현장을가다(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        System.out.println(" ");
        System.out.println("               ╭────────────────────<알림>────────────────────╮");
        System.out.println("                        ❝ 돋보기와 증거를 얻을 수 있습니다");
        System.out.println("                          확률) 🔍돋보기100%  증거50%");
        System.out.println("                          체력) '5'소모");
        System.out.println(" ");
        System.out.println("                            [현재 체력 : " + PC.hp + "]");
        System.out.println(" ");
        System.out.println("                     현장에서 증거를 찾아 사건 경위를 파악하세요 ❞");
        System.out.println("               ╰─────────────────────────────────────────────╯");
        System.out.println(" ");
        System.out.println("☞ [1] 거실     [2] 안방    [3] 피해자    [4] 화장실    [5] 부엌");
        choice = scanner.nextInt();

        while(true)
        {
            if(choice == 1)//거실🔍
            {
                거실증거(PC, 팀원, evidence, eff_Evidence, profileLog);
                break;
            }
            else if(choice == 2)//안방🔍
            {
                안방증거(PC, 팀원, evidence, eff_Evidence, profileLog);
                break;
            }
            else if(choice == 3)//피해자🔍
            {
                피해자증거(PC, 팀원, evidence, eff_Evidence, profileLog);
                break;
            }
            else if(choice == 4)//화장실🔍
            {
                화장실증거(PC, 팀원, evidence, eff_Evidence, profileLog);
                break;
            }
            else if(choice == 5)//부엌🔍
            {
                부엌증거(PC, 팀원, evidence, eff_Evidence, profileLog);
                break;
            }
            else
            {
                System.out.println("올바른 키를 입력해주시기 바랍니다");
            }
        }//while(true)
    }

    public void 거실증거(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        PC.hp -= 5;
        int i = random.nextInt(10);
        if(i < 5)
        {
            PC.돋보기 += 10;
            PC.progress += 5;
            System.out.println("증거는 얻지 못하였지만, 돋보기는 10개를 얻었습니다");
            System.out.println(" ");
        }
        else
        {
            PC.돋보기 += 100;
            System.out.println("돋보기 100개를 얻었으며, ");
            PC.get현장증거(evidence[0][0]);
        }

    }
    public void 안방증거(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        PC.hp -= 5;
        int i = random.nextInt(10);
        if(i < 5)
        {
            PC.돋보기 += 10;
            PC.progress += 5;
            System.out.println("증거는 얻지 못하였지만, 돋보기는 10개를 얻었습니다");
            System.out.println(" ");
        }
        else
        {
            PC.돋보기 += 100;
            System.out.println("돋보기 100개를 얻었으며, ");
            PC.get현장증거(evidence[0][1]);
        }

    }
    public void 피해자증거(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        PC.hp -= 5;
        int i = random.nextInt(10);
        if(i < 5)
        {
            PC.돋보기 += 10;
            PC.progress += 5;
            System.out.println("증거는 얻지 못하였지만, 돋보기는 10개를 얻었습니다");
            System.out.println(" ");
        }
        else
        {
            PC.돋보기 += 100;
            System.out.println("돋보기 100개를 얻었으며, ");
            PC.get현장증거(evidence[0][2]);
        }

    }
    public void 화장실증거(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        PC.hp -= 5;
        int i = random.nextInt(10);
        if(i < 1)
        {
            PC.돋보기 += 10;
            PC.progress += 5;
            System.out.println("증거는 얻지 못하였지만, 돋보기는 10개를 얻었습니다");
            System.out.println(" ");
        }
        else
        {
            profileLog.add("[미다졸람] - 사건현장 욕실에서 미다졸람이 발견되었습니다");
            PC.돋보기 += 100;
            System.out.println("<돋보기100 + 취조 노트에 증거가 추가되었습니다>");
            PC.get현장증거(evidence[0][3]);
        }

    }
    public void 부엌증거(Player PC, 팀원 팀원, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        PC.hp -= 5;
        int i = random.nextInt(10);
        if(i < 5)
        {
            PC.돋보기 += 10;
            PC.progress += 5;
            System.out.println("증거는 얻지 못하였지만, 돋보기는 10개를 얻었습니다");
            System.out.println(" ");
        }
        else
        {
            PC.돋보기 += 100;
            System.out.println("돋보기 100개를 얻었으며, ");
            PC.get현장증거(evidence[0][4]);
        }

    }

}
