public class 사건현장외부 extends 장소{

    public 사건현장외부(String name) {
        super(name);
    }

    //사건현장외부
    public void 사건현장외부를가다(Player PC, 팀원 팀원, NpcCharacter[] Npc, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        System.out.println(" ");
        System.out.println("☞ [1] 나가기    [2] 목격자찾기");
        choice = scanner.nextInt();

        if(choice == 1) //나가기
        {
            System.out.println("흠..탐문수사는 다음번에 하지");
        }
        else if (choice == 2)//목격자찾기
        {
            while(true)
            {
                if(PC.돋보기 <= 0)
                {
                    System.out.println("수사가능한 돋보기가 부족합니다 [현재 돋보기 : " + PC.돋보기 + "]");
                }
                System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
                System.out.println("             증언을 구하기 위해서는 상대방의 경계도를 깨부숴야 합니다");
                System.out.println("               한번 접근할 때마다 돋보기가 줄어드니 주의하세요!");
                System.out.println("                         [현재 돋보기 : " + PC.돋보기 + "]");
                System.out.println("╰────────────────────────────────────────────────────────────────────╯");
                System.out.println(" ");
                System.out.println("☞ [1] 보험설계사🔍    [2] 이웃집 A씨🔍    [3] 식당 이모🔍    [4] 건너편 빵공장 사장🔍");
                choice = scanner.nextInt();

                if(choice == 1) //보험설계사
                {
                    보험설계사증거(PC, 팀원, Npc, evidence, eff_Evidence, profileLog);
                    break;
                }
                else if(choice == 2)//이웃집 A씨
                {
                    이웃집A씨증거(PC, 팀원, Npc, evidence, eff_Evidence, profileLog);
                    break;
                }
                else if(choice == 3)//식당 이모
                {
                    식당이모증거(PC, 팀원, Npc, evidence, eff_Evidence, profileLog);
                    break;
                }
                else if(choice == 4)//건너편빵공장사장
                {
                    건너편빵공장사장증거(PC, 팀원, Npc, evidence, eff_Evidence, profileLog);
                    break;
                }
                else
                {
                    System.out.println("올바른 키를 입력해주시기 바랍니다");
                }
            }
        }

    }

    public void 보험설계사증거(Player PC, 팀원 팀원, NpcCharacter[] Npc, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        battle :
        while(true)
        {
            PC.돋보기 -= 5;
            PC.Attack(Npc[0]);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    if(Npc[0].def <= 0)
                    {
                        PC.geteffEvidence(eff_Evidence[0]);
                        PC.effDown(eff_Evidence[0]);
                        PC.progress += eff_Evidence[0].progress;
                        profileLog.add("[보험내역] - 피해자 앞으로 다수의 보험가입이 되어있습니다");
                        System.out.println("<취조 노트에 증거가 추가되었습니다>");
                        System.out.println(" ");
                        break battle;
                    }
                    continue battle;
                case 2:
                    break battle;
            }
        }
    }
    public void 이웃집A씨증거(Player PC, 팀원 팀원, NpcCharacter[] Npc, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        battle :
        while(true)
        {
            PC.돋보기 -= 5;
            PC.Attack(Npc[1]);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    if(Npc[1].def <= 0)
                    {
                        PC.geteffEvidence(eff_Evidence[1]);
                        PC.effDown(eff_Evidence[1]);
                        PC.progress += eff_Evidence[1].progress;
                        profileLog.add("[사건당시소리] - 사건당시 꽤 큰 소리로 거울깨지는 소리가 났습니다");
                        System.out.println("<취조 노트에 증거가 추가되었습니다>");
                        System.out.println(" ");
                        break battle;
                    }
                    continue battle;
                case 2:
                    break battle;
            }
        }
    }
    public void 식당이모증거(Player PC, 팀원 팀원, NpcCharacter[] Npc, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        battle :
        while(true)
        {
            PC.돋보기 -= 5;
            PC.Attack(Npc[2]);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    if(Npc[2].def <= 0)
                    {
                        PC.geteffEvidence(eff_Evidence[2]);
                        PC.effDown(eff_Evidence[2]);
                        PC.progress += eff_Evidence[2].progress;
                        profileLog.add("[피해자와엄마관계] - 평소 강박적인 성향으로 피해자와 관계가 좋지 않았다");
                        System.out.println("<취조 노트에 증거가 추가되었습니다>");
                        System.out.println(" ");
                        break battle;
                    }
                    continue battle;
                case 2:
                    break battle;
            }
        }
    }
    public void 건너편빵공장사장증거(Player PC, 팀원 팀원, NpcCharacter[] Npc, Evidence[][] evidence, effEvidence[] eff_Evidence, ProfileLog profileLog)
    {
        battle :
        while(true)
        {
            PC.돋보기 -= 5;
            PC.Attack(Npc[3]);
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    if(Npc[3].def <= 0)
                    {
                        PC.geteffEvidence(eff_Evidence[3]);
                        PC.effDown(eff_Evidence[3]);
                        PC.progress += eff_Evidence[3].progress;
                        profileLog.add("[피해자와아빠관계] - 친아빠가 아니라, 사실 양부라는 소문이 있다");
                        System.out.println("<취조 노트에 증거가 추가되었습니다>");
                        System.out.println(" ");
                        break battle;
                    }
                    continue battle;
                case 2:
                    break battle;
            }
        }
    }
}

