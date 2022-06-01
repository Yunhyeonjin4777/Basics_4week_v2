import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Music introMusic = new Music("추리intro.mp3", true);
        Music typing = new Music("typing.mp3", true);
        int choice;
        String name;

        introMusic.start();
        System.out.println(
                """
                                    ─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ ⚪ ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─
                                    
                                                            CRIME SCENE
                                                       증거를 모아 범인을 검거해라!
                                          
                                    ─━━━━━━━━━━━━━━━━━━━━━━━━⊱༻ ⚪ ༺⊰━━━━━━━━━━━━━━━━━━━━━━━━─""");

        System.out.println(" ");
        System.out.println("이름을 입력해주세요");
        System.out.println("☞ ");
        name = scanner.next();

        while(true)
        {
            System.out.println(" ");
            System.out.println("[에피소드를 선택해주세요]");
            System.out.println(
                    """
                            ─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─
                                  사건파일 EP1
                                금천구거울살인사건
                            ─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─""");
            System.out.println(
                    """
                                  사건파일 EP2
                                대구 계모 살인사건
                            ─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─""");
            System.out.println("☞ ");
            choice = scanner.nextInt();

            if (choice == 1)
            {
                typing.start();
                String s = """
                <광역수사대 계장> : 이 사건 이제 내사 종결한다

                "아..안됩니다!! 이대로 포기할 수 없습니다!!"

                <광역수사대 계장> : 26년 전에도 풀리지 않았던 사건이야! 장기 미제 사건은 경찰의 치부인 거 몰라?

                "이번 사건도 그때랑 똑같이 또 피해자가 생기지 않았습니까! 이대로 포기할 수 없습니다...!"

                < 광역수사대 계장> : 그래, 네 말대로 26년 전이랑 똑같아.. 우린 그놈 지문 하나 흔적 하나 못 찾았지

                "이번에 그놈 꼭 잡겠습니다 시간을 주십시오.."

                < 광역수사대 계장> : 좋아, 내사종결까지 딱 7일준다 그 안에 범인 잡아와!
                < 광역수사대 계장> : 그때까지 못 잡으면 언론 시끄럽지 않게 조용히 마무리해

                ☞ 게임을 시작하려면 [ 1 ] 를 누르시오.
                """;
                loading(s);
                typing.close();
                choice = scanner.nextInt();

                s ="███████████████████████████████████████████████████████████████████████\n";
                loading(s);
                introMusic.close();
                //epi1 게임시작
                Episode.epi1();
            }
            else if(choice == 2) //대구 계모 살인사건
            {
                System.out.println("episode 1 클리어 후 오픈");
            }
            else
                System.out.println("잘못 입력하셨습니다");
        }
    }
    static void loading(String s) // 타이핑
    {
        try{
            for (int i = 0; i < s.length(); i++) { // 로딩 효과 스레드
                Thread.sleep(10);
                System.out.print( s.charAt(i) );
            }
        }catch(InterruptedException e) {}
    }
}

class Episode
{
    static void epi1()
    {
        Scanner scanner = new Scanner(System.in);
        Music typing = new Music("typing.mp3", true);
        int choice;

        typing.start();
        System.out.println(
                """
                        ─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─

                              사건파일 EP1
                            금천구거울살인사건
                           내사종결까지 단 7일

                        ─━━━━━━⊱༻ ⚪ ༺⊰━━━━━━─

                        """);

        String s = """
                출근을 위해 잠시 집을 비운 아버지
                몇 시간 후 돌아온 집에선,
                코를 찌르는 피냄새와 함께 거실에서 살해된 아들이 발견되는데...
                15세의 아들 시신 주변은 마치 강도가 들이닥친 듯 난장판이다
                급히 함께 집에 있던 아내를 확인하기 위해 안방을 들어가니
                아내는 태연하게 잠을 자고 있었다
                쉽게 이해되지 않는 사건현장,
                과연 사건의 진실은 무엇일까?
                
                ☞ 계속 진행하시려면 [ 1 ] 를 누르시오.
                """;
        loading(s);
        typing.close();
        choice = scanner.nextInt();


        //게임시작

        수사본부 수사본부 = new 수사본부("수사본부");
        사건현장 사건현장 = new 사건현장("사건현장");
        사건현장외부 사건현장외부 = new 사건현장외부("사건현장외부");

        ProfileLog profileLog = new ProfileLog();

        팀원 팀원 = new 팀원("현장감식원", 200,10,0,0,0);

        Date dTimer = new Date();
        Door door = new Door();
        Player PC = new Player("형사", 500, 90, 10, 10, 5, 10000,100);

        Evidence[][] evidence = new Evidence[50][50];
        //현장증거
        evidence[0][0] = new Evidence("혈흔", "여러 군데 뿌려진 혈흔, 살해 당시 싸움 추정", 5);
        evidence[1][0] = new Evidence("물색흔", "물색흔적은 있지만, 금품이 사라지지는 않음", 5);
        evidence[0][1] = new Evidence("안방손잡이", "안방손잡에 찍힌 피 묻은 장갑흔", 5);
        evidence[0][2] = new Evidence("피해자의 자상", "왼쪽 가슴과 그 위쪽에 집중적으로 찔린 자상 15개", 5);
        evidence[0][3] = new Evidence("수상한 약품", "변기 물탱크에서 '미다졸람' 발견", 5);
        evidence[0][4] = new Evidence("범행도구 '식칼' 발견", "범행 후 범행도구를 깨끗하게 씻어서 제자리 원위치해둠", 5);

        //팀원증거_현장감식원
        evidence[0][5] = new Evidence("물색흔", "물색 흔적은 있지만, 금품이 사라지지는 않음", 5);
        evidence[1][5] = new Evidence("계획적살인추정", "계획적 살인을 감추기 위해 강도로 위장했을 수 있다", 5);
        evidence[2][5] = new Evidence("미다졸람", "수술 전 진정 목적으로 기면 상태를 유도하는 약품", 5);

        //팀원증거_프로파일러
        evidence[0][6] = new Evidence("몸싸움추정", "범행 후 범행도구를 깨끗하게 씻어서 제자리 원위치해둠", 5);
        evidence[1][6] = new Evidence("면식범", "피해자 집을 잘 아는 면식범일 확률이 높다", 5);
        evidence[2][6] = new Evidence("범인성향", "범인은 강박적인 성향으로 보인다", 5);
        evidence[3][6] = new Evidence("범인은 오른손잡이", "범인은 오른손잡이", 5);

        //팀원증거_법의학자
        evidence[0][7] = new Evidence("피해자사인", "사인) 과다출혈에 따른 쇼크사", 5);
        evidence[1][7] = new Evidence("사망추정시각", "오전 4시 ~ 7시경 사망추정", 5);
        evidence[2][7] = new Evidence("방어흔", "피해자에게 방어흔이 있으며, 입주변 결박흔적", 5);

        //Game결정적증거
        evidence[0][8] = new Evidence("CCTV", "결정적증거 CCTV) 사건 당일 약국은 휴무라 윤아빠는 출근하지 않았다", 10);

        //현장외부증거, 효력감소증거
        effEvidence[] eff_Evidence = new effEvidence[50];
        eff_Evidence[0] = new effEvidence("보험내역", "사망보험 4개, 사망시 보험금 8억원 상단", 5, 100);
        eff_Evidence[1] = new effEvidence("사건당시소리", "5 ~ 5:30 사이 거울 깨지는 소리를 들었다", 5, 100);
        eff_Evidence[2] = new effEvidence("김아내와 피해자 사이", "강박적인 성향, 아들과 평소 다툼이 많음", 5, 100);
        eff_Evidence[3] = new effEvidence("윤아빠와 피해자 사이", "친아빠 아님, 양부라는 소문(추정)", 5, 100);

        NpcCharacter[] Npc = new NpcCharacter[10];
        Npc[0] = new NpcCharacter("보험설계사", 50,50, new Evidence[]{}, new effEvidence[]{eff_Evidence[0]});
        Npc[1] = new NpcCharacter("이웃집 A씨", 50,50, new Evidence[]{}, new effEvidence[]{eff_Evidence[1]});
        Npc[2] = new NpcCharacter("식당 이모", 50,50, new Evidence[]{}, new effEvidence[]{eff_Evidence[2]});
        Npc[3] = new NpcCharacter("건너편 빵공장 사장", 50,50, new Evidence[]{}, new effEvidence[]{eff_Evidence[3]});

        System.out.println(" ");
        System.out.println("               ╭────────────────────<알림>────────────────────╮");
        System.out.println("                             ❝ 증거가 부족합니다.");
        System.out.println("                     현장에서 증거를 찾아 사건 경위를 파악하세요 ❞");
        System.out.println("               ╰─────────────────────────────────────────────╯");
        System.out.println(" ");

        Loop1:
        while(true)
        {
            if(dTimer.day() == 0) //게임오버
            {
                System.out.println(
                                "　　 /＼　　　  ／∧\n" +
                                "　　/ ∧ ＞.―＜/　|\n" +
                                "　 //／　´ 　　｀uヽ\n" +
                                "　｜ u　 ○　　○　 |\n" +
                                "　/　　　　 ▼ヽ. uヽ\n" +
                                "  ｜　u　ヽ_人_ﾉ　　|\n" +
                                "　 丶　　　|＿|　u　ﾉ\n" +
                                "　./＼u　　　　 　／)\n" +
                                "　/ ＼二二つ⊂二二〟");
                System.out.println(" ");
                System.out.println("헉...공소시효 7일이 지났습니다.");
                System.out.println("범인검거에 실패했습니다...다음 기회에..");
                break;
            }


            if(Game.Game성공여부 == true)
            {
                PC.돋보기 += 1000;
                PC.get현장증거(evidence[0][8]);
                profileLog.add("[CCTV확인결과] 거짓 알리바이, 윤아빠에 대한 심문 필요!");
                Game.Game성공여부 = false;

            }

            System.out.println(" ");
            System.out.println(" ");
            PC.mainshowInfo();
            PC.show_Log();
            System.out.println(" ");
            System.out.println("☞ [1] 수사본부  [2] 사건현장  [3] 사건현장 외부  [4] 과거  [5] 취조실  [6] 검거하기");
            choice = scanner.nextInt();


            용의자 김아내 = new 용의자("김아내", 100,100,100);
            용의자 윤아빠 = new 용의자("윤아빠", 100,100,100);

            if(choice == 1) //수사본부
            {
                수사본부.자료분석을한다(PC, 팀원, profileLog, evidence);
            }
            else if (choice == 2)//사건현장
            {
                사건현장.사건현장을가다(PC, 팀원, evidence, eff_Evidence, profileLog);
            }
            else if (choice == 3)//사건현장 외부
            {
                사건현장외부.사건현장외부를가다(PC, 팀원, Npc, evidence, eff_Evidence, profileLog);
            }
            else if (choice == 4)//과거
            {
                if(PC.progress < 0)
                {
                    System.out.println("수사진행율이 10%이상이 되어야 과거로 갈 수 있습니다");
                    System.out.println("다른 곳에서 먼저 증거를 더 찾아보세요");
                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                    System.out.println("☞ [1] 돌아가기");
                    choice = scanner.nextInt();
                    {
                        if (choice == 1)
                        {
                            continue Loop1;
                        }
                        continue Loop1;
                    }
                }
                if(door.check != true)
                {
                    System.out.println("과거로 가는 문이 열리지 않았습니다");
                    System.out.println("시간이 되면 다시 도전해 보세요");
                    System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────");
                    System.out.println("☞ [1] 돌아가기");
                    choice = scanner.nextInt();
                    {
                        if (choice == 1)
                        {
                            continue Loop1;
                        }
                        continue Loop1;
                    }
                }
                else if(door.check == true)
                {
                    System.out.println(
                                       "                                ╯▅╰╱▔▔▔▔▔▔▔╲╯╯☼\n" +
                                       "                                ▕▕╱╱╱╱╱╱╱╱╱╲╲╭╭\n" +
                                       "                                ▕▕╱╱╱╱╱╱╱╱┛▂╲╲╭\n" +
                                       "                                ╱▂▂▂▂▂▂╱╱┏▕╋▏╲╲\n" +
                                       "                                ▔▏▂┗┓▂▕▔┛▂┏▔▂▕▔\n" +
                                       "                                ▕▕╋▏▕╋▏▏▕┏▏▕╋▏▏\n" +
                                       "                                ▕┓▔┗┓▔┏▏▕┗▏┓▔┏▏");
                    System.out.println(" ");
                    System.out.println("          ╭────────────────────────────<알림>────────────────────────────╮");
                    System.out.println("                ❝ 26년전 똑같은 사건이 벌어진 현장으로 가는 문이 열렸습니다");
                    System.out.println("                        '과거 사건현장' 에서 결정적 증거를 찾으세요 ❞");
                    System.out.println(" ");
                    System.out.println("                      화면에 출력되는 '화살표' 를 빠르게 입력해주세요");
                    System.out.println("                       제한시간 5초 동안 실수 없이 입력하면 성공!");
                    System.out.println("          ╰─────────────────────────────────────────────────────────────╯");
                    System.out.println(" ");
                    System.out.println("☞ [1] 게임을 시작하길 원하시면 '1'을 눌러주세요");
                    choice = scanner.nextInt();

                    if(choice == 1)
                    {
                        Game a = new Game();

                        choice = scanner.nextInt();
                        if(choice == 1)
                        {
                            continue Loop1;
                        }
                    }
                }
            }
            else if (choice == 5)//취조하기
            {
                if(PC.progress >= 30)
                {
                    PC.용의자_취조하다(PC, 김아내, 윤아빠, profileLog);
                }
                else
                {
                    System.out.println("증거를 더 모으세요");
                }
            }
            else if (choice == 6)//검거하기
            {
                if(PC.progress >= 30)
                {
                    PC.용의자_검거하다(PC, 김아내, 윤아빠, profileLog);
                }
                else
                {
                    System.out.println("증거를 더 모으세요");
                }
            }
        }
    }
    static void loading(String s) // 타이핑
    {
        try{
            for (int i = 0; i < s.length(); i++) { // 로딩 효과 스레드
                Thread.sleep(10);
                System.out.print( s.charAt(i) );
            }
        }catch(InterruptedException e) {}
    }
}
