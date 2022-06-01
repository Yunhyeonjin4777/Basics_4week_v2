import java.util.Scanner;

public class GameMain {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        EvidenceLog E_L = new EvidenceLog();
        ProfileLog P_L = new ProfileLog();
        Game G = new Game();

        Evidence[] E = new Evidence[20];
//        E[0] = new Evidence("' '" , " ");
//        E[1] = new Evidence("''" , "");
        E[2] = new Evidence("' '" , " ");
        E[3] = new Evidence("''" , "");
        E[4] = new Evidence("여러군데 뿌려진 혈흔 => 범인과의 공격과 방어가 진행되면서 꽤 소란이 있었을 수 있다" , "여러군데 뿌려진 혈흔");
        E[5] = new Evidence("안방손잡이에 찍힌 피 묻은 장갑흔 => 피해자를 살해한 이후, " +
                "안방에 들어갔거나 안방 손잡이만 만졌거나 둘 중 하나" , "안방손잡이에 찍힌 피 묻은 장갑흔");
        E[6] = new Evidence("'피해자 왼쪽 가슴과 그 위쪽에 집중적으로 찔린 자상 15개' -> " , "피해자 왼쪽 가슴과 그 위쪽에 집중적으로 찔린 자상 15개");
        E[7] = new Evidence("변기 물탱크에서 미다졸람 발견 => 미다졸람 : 향정신성의약품으로 미약류, 기면 상태를 유도" , "변기 물탱크에서 미다졸람 발견");

        E[8] = new Evidence("범행도구 => (범행도구를 씻어서 제자리 원위치해둠) 면식범일 확률, " +
                "강박적인 성향이 보인다, 범인은 오른손잡이" , "범행도구 식칼 발견");
        E[9] = new Evidence("다수의 보험 가입내역 = 제태크 관련해서 넣은 것" , "다수의 보험 가입내역");
        E[10] = new Evidence("'사망시간 큰 소리가 났음에도 못 깼다?' -> 새벽 6시경 인슐린 주사를 놓고 그대로 잤다" , "사망시간 큰 소리가 났음에도 김아내는 못 깼다?");
        E[11] = new Evidence("'평소 아들과의 사이가 안 좋았음' -> 평소 강방적 성향이 있으며, 사실이다" , "평소 아들과의 사이가 안 좋았음");

        E[12] = new Evidence("'윤아빠 사실 양부?' -> 사실이다" , "윤아빠 사실 양부?");
        E_L.add(E[4].Description);
        System.out.println(E[4].Description);

        Player3 PC[] = new Player3[5];
        PC[1] = new Player3("프로파일러", "증거 분석 능력이 탁월", 5, 5, 5, 5, 5, 5,   new Evidence[]{E[8]});
        PC[2] = new Player3("형사", "정보 획득 기회가 높음", 25, 85, 15, 15, 2, 50,   new Evidence[]{E[8]});
//        PC[CharacterNum].MagnifierDown(PC[1].magnifier);

        System.out.println(PC[1].magnifier);
        System.out.println(PC[1]);
        System.out.println(PC);
        THEsuspect TS[] = new THEsuspect[5];
        TS[1] = new THEsuspect("김아내", "'피해자의 엄마'",5, 40, 5,  new Evidence[]{E[2]});
        TS[2] = new THEsuspect("윤아빠", "'최초발견자'",5, 70, 5,  new Evidence[]{E[3]});

        System.out.println(PC);
        NpcCharacter NPC[] = new NpcCharacter[10];
        NPC[2] = new NpcCharacter("보험설계사 B씨", "'피해자의 보험금 내역을 알 수 있습니다'", 50, 10, 10,  new Evidence[]{E[8]});
        NPC[3] = new NpcCharacter("이웃집 A씨 아줌마", "'사건당시 주변상황을 알 수 있습니다'",50, 10, 10,  new Evidence[]{E[10]});
        NPC[4] = new NpcCharacter("김아내 식당 이모", "'피해자와 김아내의 관계를 알 수 있습니다'",50, 10, 10,  new Evidence[]{E[11]});
        NPC[5] = new NpcCharacter("건너편 이웃집 빵공장 사장", "'윤아빠의 비밀을 알 수 있습니다'",60, 10, 10,  new Evidence[]{E[12]});

        String name;
        int CharacterNum;
        int choice;
        int input = 0;

        String[][] profileList = new String[50][50];
        profileList[0][0]="[2] 사망추정시간🔍";
        profileList[1][0]="[3] 시신상태🔍";
        profileList[0][1]="[2] 알리바이🔍";
        profileList[2][1]="[3] 오른손잡이? 왼손잡이?🔍";
        profileList[0][2]="[2] 알리바이🔍";
        profileList[2][2]="[3] 오른손잡이? 왼손잡이?🔍";


        //게임 시작
        System.out.println();
        System.out.println(
                "이름을 입력해주세요\n" +
                        "☞ ");
        name = scanner.next();

        System.out.println( "캐릭터 이름을 입력해주세요");
        System.out.print("☞ [1] ");
        PC[1].showInfo1();
        System.out.println(" ");
        System.out.print("☞ [2] ");
        PC[2].showInfo1();
        CharacterNum = scanner.nextInt();

        if(CharacterNum  == 1)
        {
            System.out.println(
                    "(똑 똑 똑)\n" +
                            "\n" +
                            "누구십니까?\n" +
                            "\n" +
                            "<형사> : 안녕하세요. 장기미제 전담팀 김동혁 형사입니다.\n" +
                            "<형사> : " + name + "프로파일러님께 사건 의뢰 드릴려고 왔습니다...!\n" +
                            "\n" +
                            "무슨 일이시죠?\n" +
                            "\n" +
                            "<형사> : 26년전 금천구에서 일어났던 거울살인사건말입니다\n" +
                            "<형사> : 난장판인 살해현장에서 깨진 거울만 반듯하게 맞춰져있었던...\n" +
                            "\n" +
                            "대한민국사람이라면 그 사건 다알죠.\n" +
                            "\n" +
                            "<형사> : 이번에 새로운 증거가 나왔는데.. 공소시효까지 남은 시간이 단 3일입니다\n" +
                            "<형사> : 그 안에 범인을 검거하지 못하면 영원히미제사건으로 남게 됩니다. 도와주십시오...\n" +
                            "\n" +
                            "──────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
                            "☞ 사건의뢰를 받으시려면 [ 1 ] 를 누르시오.");
        }
        else if(CharacterNum  == 2)
        {
            System.out.println(
                    "<광역수사대 계장> : 이 사건 이제 수사 종결한다\n" +
                            "\n" +
                            "안됩니다! 이대로 포기할 수 없습니다...!\n" +
                            "\n" +
                            "<광역수사대 계장> : 공소시효 불과 3일 남았어\n" +
                            "<광역수사대 계장> : 26년 동안 풀리지 않았던 사건이 그 시간 안에 풀릴 수 있을 것 같아?\n" +
                            "<광역수사대 계장> : 일 크게 만들지 마\n" +
                            "\n" +
                            "범인...찾을 수 있습니다\n" +
                            "\n" +
                            "<광역수사대 계장> : 26년 전 사건이야. 수사자료, 현장 사진 하나 남아있는 게 없는데\n" +
                            "<광역수사대 계장> : 이제 무슨 수로 수사할 거야!\n" +
                            "\n" +
                            "(쿵!쿵!쿵!쿵)" +
                            "\n" +
                            "<후배 형사> : " + name + "선배님! 증거..새로운 증거가 나왔습니다!! 빨리 확인해보시죠!!" +
                            "\n" +
                            "──────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
                            "☞ 수사를 시작하시려면 [ 1 ] 를 누르시오.");
        }
        choice = scanner.nextInt();

        if(choice == 1)
        {
            System.out.println(
                    "─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─\n" +
                            "\n" +
                            "      사건파일 EP1\n" +
                            "    금천구거울살인사건\n" +
                            "   공소시효 종료 3일 전\n" +
                            "\n" +
                            "─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─" +
                            "\n" +
                            "\n" +
                            "출근을 위해 잠시 집을 비운 아버지\n" +
                            "몇 시간 후 돌아온 집에선,\n" +
                            "코를 찌르는 피냄새와 함께 거실에서 살해된 아들이 발견되는데...\n" +
                            "15세의 아들 시신 주변은 마치 강도가 들이닥친 듯 난장판이다\n" +
                            "급히 함께 집에 있던 아내를 확인하기 위해 안방을 들어가니\n" +
                            "아내는 태연하게 잠을 자고 있었다\n" +
                            "쉽게 이해되지 않는 사건현장,\n" +
                            "과연 사건의 진실은 무엇일까?\n" +
                            "\n" +
                            "──────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
                            "☞ 게임을 시작하려면 [ 1 ] 를 누르시오.");
            choice = scanner.nextInt();
        }

        System.out.println(" ");
        System.out.println("               ╭────────────────────<알림>────────────────────╮");
        System.out.println("                             ❝ 증거가 부족합니다.");
        System.out.println("                   현장에서 1차 감식을 통해 사건 경위를 파악하세요 ❞");
        System.out.println("               ╰─────────────────────────────────────────────╯");
        System.out.println(" ");

        Loop1:
        while (true) {
            PC[CharacterNum].showInfo2();
            System.out.println(E_L);
            choice = scanner.nextInt();

            if (choice == 1)//[1] 현장가기
            {
                Loop1_2:
                while (true) {
                    System.out.println("현장을 상세히 살펴보자");
                    System.out.println("☞ [1] 거실🔍     [2] 안방🔍    [3] 피해자🔍    [4] 화장실🔍    [5] 부엌🔍");
                    choice = scanner.nextInt();

                    //[1] 거실🔍
                    if (choice == 1) {
                        if (PC[CharacterNum].magnifier > 0) {
                            PC[CharacterNum].change(1,1,1);

                            System.out.println("<새로운 단서를 획득했습니다>");
                            E_L.add(E[4].Description);
                            System.out.println("여러군데 뿌려진 혈흔");
                            System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 현장 더 살피기      [2] 수사일지로 돌아가기");
                            choice = scanner.nextInt();

                            if (choice == 1) {
                                continue Loop1_2;
                            } else if (choice == 2) {
                                continue Loop1;
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[2] 안방🔍
                    else if (choice == 2)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1); //값을 지역변수로 받고 값을 메소드에 넣어서 능력치를 조정해준다 한 메소드로 가능해짐

                            System.out.println("<새로운 단서를 획득했습니다>");
                            E_L.add(E[5].Description);
                            System.out.println("안방손잡이에 찍힌 피 묻은 장갑흔");
                            System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 현장 더 살피기      [2] 수사일지로 돌아가기");
                            choice = scanner.nextInt();

                            if(choice == 1)
                            {
                                continue Loop1_2;
                            }
                            else if (choice == 2)
                            {
                                continue Loop1;
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[3] 피해자🔍
                    else if (choice == 3)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);

                            System.out.println("<새로운 단서를 획득했습니다>");
                            E_L.add(E[6].Description);
                            System.out.println("피해자 왼쪽 가슴과 그 위쪽에 집중적으로 찔린 자상 15개");
                            System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 현장 더 살피기      [2] 수사일지로 돌아가기");
                            choice = scanner.nextInt();

                            if(choice == 1)
                            {
                                continue Loop1_2;
                            }
                            else if (choice == 2)
                            {
                                continue Loop1;
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " +PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[4] 화장실🔍
                    else if (choice == 4)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);

                            System.out.println("<새로운 단서를 획득했습니다>");
                            E_L.add(E[7].Description);
                            System.out.println("변기 물탱크에서 미다졸람 발견");
                            System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 현장 더 살피기      [2] 수사일지로 돌아가기");
                            choice = scanner.nextInt();

                            if(choice == 1)
                            {
                                continue Loop1_2;
                            }
                            else if (choice == 2)
                            {
                                continue Loop1;
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[5] 부엌🔍
                    else if (choice == 5)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);

                            System.out.println("<새로운 단서를 획득했습니다>");
                            E_L.add(E[8].Description);
                            System.out.println("범행도구 식칼 발견");
                            System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 현장 더 살피기      [2] 수사일지로 돌아가기");
                            choice = scanner.nextInt();

                            if(choice == 1)
                            {
                                continue Loop1_2;
                            }
                            else if (choice == 2)
                            {
                                continue Loop1;
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                }
            }
            //[2] 돋보기 모으러 가기
            else if(choice == 2)
            {
                System.out.println("[현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("☞ ");
                choice = scanner.nextInt();
                G.GameStart(choice);
                PC[CharacterNum].MagnifierUP(choice);

                continue Loop1;
            }
            //[3] 용의자수첩
            else if(choice == 3)
            {
                Loop1_3:
                while (true)
                {
                    System.out.println("인물을 선택해주세요");
                    System.out.println("☞ [1] 윤아들(피해자)🔍     [2] 김아내(피해자의 엄마)🔍    [3] 윤아빠(최초발견자)🔍");
                    choice = scanner.nextInt();

                    //[1] 윤아들(피해자)🔍
                    if(choice == 1)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);

                            while(true)
                            {
                                profile P1 = new profile("윤아들", 163, 57, "중학생");
                                P1.showInfo();
                                System.out.println(profileList[0][0]);
                                System.out.println(profileList[1][0]);
                                choice = scanner.nextInt();

                                if(choice == 1) //[1] 수사일지로 돌아가기
                                {
                                    continue Loop1;
                                }
                                if(choice == 2)
                                {
                                    PC[CharacterNum].change(1,1,1);
                                    profileList[0][0]="사망추정시간 : 오전 4시~7시 사이, 당시 고온의 보일러 상태로 정확한 사망 추정시간을 판단하기 어려움";
                                }
                                else if(choice == 3)
                                {
                                    PC[CharacterNum].change(1,1,1);
                                    profileList[1][0]="시신상태 : 시신에 방어흔이 많은 것으로 보아 범인과 몸다툼이 있었을 것으로 추정, 수건과 같은 헝겁으로 입주변 결박흔적";
                                }
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[2] 김아내(피해자의 엄마)
                    else if(choice == 2)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);
                            while(true)
                            {
                                profile P2 = new profile("김아내", 168, 63, "요리사");
                                P2.showInfo();
                                System.out.println(profileList[0][1]);
                                System.out.println(profileList[2][1]);
                                choice = scanner.nextInt();

                                if(choice == 1) //[1] 수사일지로 돌아가기
                                {
                                    continue Loop1;
                                }
                                if(choice == 2)
                                {
                                    PC[CharacterNum].change(1,1,1);
                                    profileList[0][1]="알리바이 : 그 시각 아무 소리도 못 들었고 깊이 자고 있었습니다(목격자없음)";
                                }
                                else if(choice == 3)
                                {
                                    PC[CharacterNum].change(1,1,1);
                                    profileList[2][1]="왼손잡이";
                                }
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;
                    }
                    //[3] 윤아빠(최초발견자)🔍
                    else if(choice == 3)
                    {
                        if(PC[CharacterNum].magnifier > 0)
                        {
                            PC[CharacterNum].change(1,1,1);
                            while(true)
                            {
                                profile P3 = new profile("윤아빠", 174, 70, "약사");
                                P3.showInfo();
                                System.out.println(profileList[0][2]);
                                System.out.println(profileList[2][2]);
                                choice = scanner.nextInt();

                                if(choice == 1) //[1] 수사일지로 돌아가기
                                {
                                    continue Loop1;
                                }
                                if(choice == 2)
                                {
                                    PC[CharacterNum].change(1,1,1);
                                    profileList[0][2]="알리바이 : 6시 반쯤 약국으로 출근해서 8시까지 업무를 보다가 집에 휴대폰을 두고와서 일하다가 짬을 내서 집으로 가던 중이었습니다(목격자없음)";
                                }
                                else if(choice == 3)
                                {
                                PC[CharacterNum].change(1,1,1);
                                    profileList[2][2]="오른손잡이";
                                }
                            }
                        }
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                        System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ ");
                        choice = scanner.nextInt();
                        G.GameStart(choice);
                        PC[CharacterNum].MagnifierUP(choice);
                        continue Loop1;

                    }
                }
            }
            //[4] 주변탐문하기
            else if(choice == 4)
            {
                Loop1_4:
                while (true)
                {
                    System.out.println("☞ [1] 윤아들 주변탐문    [2] 김아내의 주변탐문    [3] 윤아빠의 주변탐문");
                    choice = scanner.nextInt();

                    //[1] 윤아들 주변탐문
                    if(choice == 1)
                    {
                        System.out.println("☞ [1] 수사일지로 돌아가기     [2] 보험설계사 B씨🔍");
                        choice = scanner.nextInt();

                        //[1] 수사일지로 돌아가기
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                        //[2] 보험설계사 B씨🔍
                        else if(choice == 2)
                        {
                            if(PC[CharacterNum].magnifier > 0)
                            {
                                if (PC[CharacterNum].magnifier > 0)
                                {
                                    System.out.println("         ❝ " + NPC[2].name + "의 방어력이 마이너스가 되어야 심문을 할 수 있습니다 ❞");
                                    battle:
                                    while (true)
                                    {
                                        PC[CharacterNum].change(1,1,1);
                                        PC[CharacterNum].Attack(NPC[2]);
                                        choice = scanner.nextInt();
                                        switch (choice)
                                        {
                                            case 1:
                                                if (NPC[2].def <= 0)
                                                {
                                                    System.out.println("<새로운 증언을 획득했습니다>");
                                                    E_L.add(E[9].E);
                                                    P_L.add(E[9].Description);
                                                    System.out.println("윤아들님 앞으로 다수의 보험 가입내역이 있습니다.");
                                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                                    System.out.println("☞ [1] 수사일지로 돌아가기");
                                                    choice = scanner.nextInt();

                                                    if (choice == 1)
                                                    {
                                                        continue Loop1;
                                                    }
                                                }
                                                continue battle;
                                            case 2:
                                                continue Loop1;
                                        }
                                        continue Loop1;
                                    }
                                }
                            }
                            System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ ");
                            choice = scanner.nextInt();
                            G.GameStart(choice);
                            PC[CharacterNum].MagnifierUP(choice);
                            continue Loop1;
                        }
                    }
                    //[2] 김아내의 주변탐문
                    else if(choice == 2)
                    {
                        System.out.println("☞ [1] 수사일지로 돌아가기     [2] 이웃집 A씨 아줌마🔍    [3] 김아내 식당 이모🔍");
                        choice = scanner.nextInt();

                        //[1] 수사일지로 돌아가기
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                        //[2] 이웃집 A씨 아줌마🔍
                        else if(choice == 2)
                        {
                            if(PC[CharacterNum].magnifier > 0)
                            {
                                if (PC[CharacterNum].magnifier > 0)
                                {
                                    System.out.println("         ❝ " + NPC[3].name + "의 방어력이 마이너스가 되어야 심문을 할 수 있습니다 ❞");
                                    battle:
                                    while (true)
                                    {
                                        PC[CharacterNum].change(1,1,1);
                                        PC[CharacterNum].Attack(NPC[3]);
                                        choice = scanner.nextInt();
                                        switch (choice)
                                        {
                                            case 1:
                                                if (NPC[3].def <= 0)
                                                {
                                                    System.out.println("<새로운 증언을 획득했습니다>");
                                                    E_L.add(E[10].E);
                                                    P_L.add(E[10].Description);
                                                    System.out.println("오전 5시 50분경에 쿵쿵거리는 소리에 잠깐 깼어요\n" +
                                                            "그 집이 워낙 자주 싸워서 또 그러나 했죠");
                                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                                    System.out.println("☞ [1] 수사일지로 돌아가기");
                                                    choice = scanner.nextInt();

                                                    if (choice == 1)
                                                    {
                                                        continue Loop1;
                                                    }
                                                }
                                                continue battle;
                                            case 2:
                                                continue Loop1;
                                        }
                                        continue Loop1;
                                    }
                                }
                            }
                            System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ ");
                            choice = scanner.nextInt();
                            G.GameStart(choice);
                            PC[CharacterNum].MagnifierUP(choice);
                            continue Loop1;
                        }
                        //[3] 김아내 식당 이모🔍
                        else if(choice == 3)
                        {
                            if(PC[CharacterNum].magnifier > 0)
                            {
                                if (PC[CharacterNum].magnifier > 0)
                                {
                                    System.out.println("         ❝ " + NPC[4].name + "의 방어력이 마이너스 되어야 심문을 할 수 있습니다 ❞");
                                    battle:
                                    while (true)
                                    {
                                        PC[CharacterNum].change(1,1,1);
                                        PC[CharacterNum].Attack(NPC[4]);
                                        choice = scanner.nextInt();
                                        switch (choice)
                                        {
                                            case 1:
                                                if (NPC[4].def <= 0)
                                                {
                                                    System.out.println("<새로운 증언을 획득했습니다>");
                                                    E_L.add(E[11].E);
                                                    P_L.add(E[11].Description);
                                                    System.out.println("애 엄마가 평소에 굉장히 강박적으로 아들한테 집착해서 아들과 사이가 좋지 않아요");
                                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                                    System.out.println("☞ [1] 수사일지로 돌아가기");
                                                    choice = scanner.nextInt();

                                                    if (choice == 1)
                                                    {
                                                        continue Loop1;
                                                    }
                                                }
                                                continue battle;
                                            case 2:
                                                continue Loop1;
                                        }
                                        continue Loop1;
                                    }
                                }
                            }
                            System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ ");
                            choice = scanner.nextInt();
                            G.GameStart(choice);
                            PC[CharacterNum].MagnifierUP(choice);
                            continue Loop1;
                        }

                    }
                    //[3] 윤아빠의 주변탐문
                    else if(choice == 3)
                    {
                        System.out.println("☞ [1] 수사일지로 돌아가기     [2] 건너편 이웃집 빵공장 사장🔍");
                        choice = scanner.nextInt();

                        //[1] 수사일지로 돌아가기
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                        //[2] 건너편 이웃집 빵공장 사장🔍
                        else if(choice == 2)
                        {
                            if(PC[CharacterNum].magnifier > 0)
                            {
                                if (PC[CharacterNum].magnifier > 0)
                                {
                                    System.out.println("         ❝ " + NPC[5].name + "의 방어력이 마이너스가 되어야 심문을 할 수 있습니다 ❞");
                                    battle:
                                    while (true)
                                    {
                                        PC[CharacterNum].change(1,1,1);
                                        NPC[CharacterNum].Attack(NPC[5]);
                                        choice = scanner.nextInt();
                                        switch (choice)
                                        {
                                            case 1:
                                                if (NPC[5].def <= 0)
                                                {
                                                    System.out.println("<새로운 증언을 획득했습니다>");
                                                    E_L.add(E[12].E);
                                                    P_L.add(E[12].Description);
                                                    System.out.println("그 집 아빠가 사실 양부라는 소문이 있어요");
                                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                                    System.out.println("☞ [1] 수사일지로 돌아가기");
                                                    choice = scanner.nextInt();

                                                    if (choice == 1)
                                                    {
                                                        continue Loop1;
                                                    }
                                                }
                                                continue battle;
                                            case 2:
                                                continue Loop1;
                                        }
                                        continue Loop1;
                                    }
                                }
                            }
                            System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC[CharacterNum].magnifier + "]");
                            System.out.println("얻고 싶은 돋보기 수를 입력하시오");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ ");
                            choice = scanner.nextInt();
                            G.GameStart(choice);
                            PC[CharacterNum].MagnifierUP(choice);
                            continue Loop1;
                        }
                    }
                }
            }
            //[5] 취조하기
            else if(choice == 5)
            {
                System.out.println("☞ [1] 김아내 취조하기    [2] 윤아빠 취조하기");
                choice = scanner.nextInt();

                //[1] 김아내 취조하기🔍
                if(choice == 1)
                {
                    System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
                    System.out.println("             취조를 하기 위해서는 상대방의 방어력을 깨부숴야 합니다");
                    System.out.println("                상대방은 당신을 훼방두기 위해 공격할 것이며  ");
                    System.out.println("               한번 접근할 때마다 돋보기가 줄어드니 주의하세요!");
                    System.out.println("                   [현재 돋보기 : " + PC[CharacterNum].magnifier + "]  상대방어력 : " + TS[2].hp + "]");
                    System.out.println("╰────────────────────────────────────────────────────────────────────╯");

                    battle : while(true)
                    {
                        System.out.println(" ");
                        PC[CharacterNum].change(1,1,1);
                        System.out.println("[1] 압박 주러 가기     [2] 다른 증거 먼저 찾아 보기");
                        input = scanner.nextInt();

                        switch(input)
                        {
                            case 1:
                                PC[CharacterNum].attack(TS[1]);
                                if(TS[1].hp <=0)
                                {
                                    PC[CharacterNum].ProgressUP(30);
                                    PC[CharacterNum].GetExp(30);
                                    System.out.println(" ");
                                    System.out.println(">>>>>>>>>>>>>심문중입니다>>>>>>>>>>>>");
                                    System.out.println(" ");
                                    System.out.println(P_L);
                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                    System.out.println("☞ 아무 키나 눌러주세요");
                                    choice = scanner.nextInt();

                                    if(choice == 1)
                                    {
                                        continue Loop1;
                                    }
                                    break battle;
                                }
                                TS[1].attack(PC[CharacterNum]);
                                break;
                            case 2:
                                continue Loop1;
                        }
                    }
                }
                //[2] 윤아빠 취조하기🔍
                else if(choice == 2)
                {
                    System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
                    System.out.println("             취조를 하기 위해서는 상대방의 방어력을 깨부숴야 합니다");
                    System.out.println("                상대방은 당신을 훼방두기 위해 공격할 것이며  ");
                    System.out.println("               한번 접근할 때마다 돋보기가 줄어드니 주의하세요!");
                    System.out.println("                   [현재 돋보기 : " + PC[CharacterNum].magnifier + "]  상대방어력 : " + TS[2].hp + "]");
                    System.out.println("╰────────────────────────────────────────────────────────────────────╯");

                    battle : while(true)
                    {
                        System.out.println(" ");
                        PC[CharacterNum].change(1,1,1);
                        System.out.println("[1] 압박 주러 가기     [2] 다른 증거 먼저 찾아 보기");
                        input = scanner.nextInt();

                        switch(input)
                        {
                            case 1:
                                PC[CharacterNum].attack(TS[2]);
                                if(TS[2].hp <=0)
                                {
                                    PC[CharacterNum].ProgressUP(30);
                                    PC[CharacterNum].GetExp(30);
                                    System.out.println(" ");
                                    System.out.println(">>>>>>>>>>>>>심문중입니다>>>>>>>>>>>>");
                                    System.out.println(" ");
                                    System.out.println(P_L);
                                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                                    System.out.println("☞ 아무 키나 눌러주세요");
                                    choice = scanner.nextInt();

                                    if(choice == 1)
                                    {
                                        continue Loop1;
                                    }
                                    break battle;
                                }
                                TS[2].attack(PC[CharacterNum]);
                                break;
                            case 2:
                                continue Loop1;
                        }
                    }
                }
            }
            //[6] 검거하기
            else if(choice == 6)
            {
                System.out.println("☞ [1] 수사일지로 돌아가기     [2] 김아내검거하기    [3] 윤아빠검거하기");
                choice = scanner.nextInt();
                //[1] 수사일지로 돌아가기
                if(choice == 1)
                {
                    continue Loop1;
                }
                else if (choice == 2)//[2] 김아내검거하기
                {
                    if(PC[CharacterNum].gcount > 0)
                    {
                        System.out.println("정말로 이 용의자를 범인으로 지명하시겠습니까?");
                        System.out.println("범인을 놓치기까지 1번의 시도가 남았습니다");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ [1] 아니요. 더 생각해보겠습니다" + "[2] 네");
                        choice = scanner.nextInt();
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                        else if(choice == 2)
                        {
                            PC[CharacterNum].Minus(1);
                            System.out.println("죄송합니다... 상대방은 무죄입니다ㅜㅜㅜㅜ");
                            System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("☞ [1] 수사일지로 돌아가기");
                            choice = scanner.nextInt();
                            if(choice == 1)
                            {
                                continue Loop1;
                            }
                        }

                    }
                    System.out.println("<게임오버!!!!> 당신의 추리는 여기 가지예요 범인을 검가 할 모든 기회를 사용하셨습니다ㅜㅜ");
                    break Loop1;
                }
                else if (choice == 3)//[3] 윤아빠검거하기
                {
                    if(PC[CharacterNum].gcount > 0)
                    {
                        System.out.println("정말로 이 용의자를 범인으로 지명하시겠습니까?");
                        System.out.println("범인을 놓치기까지 1번의 시도가 남았습니다");
                        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("☞ [1] 아니요. 더 생각해보겠습니다" + "[2] 네");
                        choice = scanner.nextInt();
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                        else if(choice == 2)
                        {
                            PC[CharacterNum].Minus(1);
                            System.out.println("축하합니다!!!! 범인을 검거하셨습니다");
                        }
                        break Loop1;
                    }
                    System.out.println("<게임오버!!!!> 당신의 추리는 여기 가지예요 범인을 검가 할 모든 기회를 사용하셨습니다ㅜㅜ");
                    break Loop1;
                }
            }
        }
    }
}
