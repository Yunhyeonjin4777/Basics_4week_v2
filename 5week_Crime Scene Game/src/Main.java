import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Music introMusic = new Music("추리intro.mp3", true);
        Music typing = new Music("typing.mp3", true);

        int choice;
        String name;

        introMusic.start();
        System.out.println("이름을 입력해주세요");
        System.out.println("☞ ");
        name = scanner.next();

        while(true)
        {
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


////////////////////////////////////////////////////////////


class Episode implements Runnable
{
    static boolean effDown = false;
    static void epi1()
    {
        Thread T = new Thread(new Episode());
        T.setDaemon(true);

        Scanner scanner = new Scanner(System.in);
        Player PC = new Player("형사", 500, 60, 0, 10, 10, 10,10, 10);
        Music introMusic = new Music("introMusic.mp3", true);
        Music typing = new Music("typing.mp3", true);
        Evidence[] evidence = new Evidence[10];

        Random random = new Random();

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

        Date dTimer = new Date();
        과거로문 door = new 과거로문();

        System.out.println(" ");
        System.out.println("               ╭────────────────────<알림>────────────────────╮");
        System.out.println("                             ❝ 증거가 부족합니다.");
        System.out.println("                     현장에서 증거를 찾아 사건 경위를 파악하세요 ❞");
        System.out.println("               ╰─────────────────────────────────────────────╯");
        System.out.println(" ");

        //인터페이스
        while(true)
        {
            if(dTimer.day() == 0) //게임오버
            {
                System.out.println("공소시효 7일이 지났습니다.");
                System.out.println("범인검거실패...");
                break;
            }

            PC.mainshowInfo();

            System.out.println("☞ [1] 메뉴  [2] 수사일지  [3] 현장가기  [4] 현장외부 가기  [5] 26년전 과거 [6] 취조하러가기  [7] 검거하기");
            choice = scanner.nextInt();

            if(choice == 1) //메뉴로 가기
            {
                System.out.println("☞ [1] 내정보  [2] 팀원고용하기");
                choice = scanner.nextInt();

                if(choice == 1)
                {
                    PC.showInfo();
                }
                else if(choice == 2)
                {

                }
                else
                {
                    System.out.println("잘못입력하셨습니다");
                }
            }
            else if (choice == 2)//수사일지로 가기
            {
//                System.out.println(evidence);
                PC.show_Log();
            }
            else if (choice == 3)//현장가기
            {
                System.out.println(" ");
                System.out.println("               ╭────────────────────<알림>────────────────────╮");
                System.out.println("                        ❝ 돋보기와 증거를 얻을 수 있습니다");
                System.out.println("                          확률) 🔍돋보기100%  증거30%");
                System.out.println("                          체력) '5'소모");
                System.out.println(" ");
                System.out.println("                          [현재 체력 : " + PC.hp + "]");
                System.out.println(" ");
                System.out.println("                     현장에서 증거를 찾아 사건 경위를 파악하세요 ❞");
                System.out.println("               ╰─────────────────────────────────────────────╯");
                System.out.println(" ");
                System.out.println("☞ [1] 거실🔍     [2] 안방🔍    [3] 피해자🔍    [4] 화장실🔍    [5] 부엌🔍");
                choice = scanner.nextInt();

                //[1] 거실🔍
                if (choice == 1) //중복없이 단서 가져오기
                {
                    PC.hp -= 5;
                    int i = random.nextInt(10);
                    if(i < 1)
                    {
                        PC.돋보기 += 10;
                        PC.progress += 5;
                        System.out.println("증거는 얻지 못하였지만, 돋보기는 100개 얻었습니다");
                    }
                    else
                    {
                        evidence[0] = new Evidence("혈흔", "여러 군데 뿌려진 혈흔, 살해 당시 싸움 추정", 5);
                        evidence[1] = new Evidence("물색흔", "물색흔적은 있지만, 금품이 사라지지는 않음", 5);
                        PC.돋보기 += 100;
                        PC.get현장증거(evidence[0]);
                        PC.get현장증거(evidence[1]);
                    }
                }
            }
            else if (choice == 4)//현장외부 가기
            {
                System.out.println("☞ [1] 목격자찾기    [2] CCTV 확보");
                choice = scanner.nextInt();

                if(choice == 1)//목격자찾기
                {
                    Evidence[] 증언 = new Evidence[10];
                    effEvidence[] 정황증거 = new effEvidence[10];

                    증언[0] = new Evidence("보험내역", "사망보험 4개, 사망시 보험금 8억원 상단", 5);
                    NpcCharacter Npc_1 = new NpcCharacter("보험설계사", 100, 100, new Evidence[]{증언[0]}, new effEvidence[]{});

                    정황증거[0] = new effEvidence("사건당시 소리", "5 ~ 5:30 사이 거울 깨지는 소리를 들었다", 100, 5);
                    NpcCharacter Npc_2 = new NpcCharacter("이웃집 A씨", 100, 100, new Evidence[]{}, new effEvidence[]{정황증거[0]});
                    if(PC.돋보기 <= 0)
                    {
                        System.out.println("돋보기가 부족합니다 [현재 돋보기 : " + PC.돋보기 + "]");
                    }

                    System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
                    System.out.println("             증언을 구하기 위해서는 상대방의 경계도를 깨부숴야 합니다");
                    System.out.println("               한번 접근할 때마다 돋보기가 줄어드니 주의하세요!");
                    System.out.println("                         [현재 돋보기 : " + PC.돋보기 + "]");
                    System.out.println("╰────────────────────────────────────────────────────────────────────╯");
                    System.out.println("☞ [1] 보험설계사🔍    [2] 이웃집 A씨🔍    [3] 식당 이모🔍    [4] 건너편 빵공장 사장🔍");
                    choice = scanner.nextInt();

                    if(choice == 1)
                    {
                        battle :
                        while(true)
                        {
                            PC.돋보기 -= 1;
                            PC.Attack(Npc_1);
                            choice = scanner.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    if(Npc_1.def <= 0)
                                    {
                                        PC.get현장증거(증언[0]);
                                        PC.progress += 5;
                                        System.out.println("수사일지에서 증거에 대한 정보를 확인하세요");
                                        break battle;
                                    }
                                    continue battle;
                                case 2:
                            }
                        }
                    }
                    else if(choice == 2)
                    {
                        battle :
                        while(true)
                        {
                            PC.돋보기 -= 1;
                            PC.Attack(Npc_2);
                            choice = scanner.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    if(Npc_2.def <= 0)
                                    {
                                        Thread th = new Thread(new effEvidence("사건당시 소리", "5 ~ 5:30 사이 거울 깨지는 소리를 들었다", 100, 5));
                                        th.setDaemon(true);
                                        th.start();
                                        PC.geteffEvidence(정황증거[0]);
                                        PC.progress += 5;
                                        System.out.println("수사일지에서 증거에 대한 정보를 확인하세요");
                                        break battle;
                                    }
                                    continue battle;
                                case 2:
                            }
                        }
                    }
                }
                else if(choice == 2)//CCTV 확보
                {
                }
                else
                {
                    System.out.println("잘못입력하셨습니다");
                }
            }
            else if (choice == 5)//26년전 과거
            {
                if(PC.progress < 50)
                {
                    System.out.println("수사진행율이 50%이상이 되어야 과거로 갈 수 있습니다");
                    System.out.println("다른 곳에서 먼저 증거를 더 찾아보세요");
                }
                if(door.check != true)
                {
                    System.out.println("과거로 가는 문이 열리지 않았습니다");
                    System.out.println("시간이 되면 다시 도전해 보세요");
                }
                else if(door.check == true)
                {
                    System.out.println("과거로 가는 문이 열렸습니다");
                    System.out.println("과거로 입장합니다");
//                        Game game = new Game("증거쫒기");
                }
            }
            else if (choice == 6)//취조하러가기
            {
                if(PC.돋보기 > 5000 && PC.progress >= 50)
                {
//                hunt(PC);
                }
                else
                {
                    System.out.println("증거를 더 모으세요");
                }
            }
            else if (choice == 7)//검거하기
            {
                if(PC.progress >= 90)
                {

                }
                else
                {
                    System.out.println("수사진행율이 90% 되어야 검거를 할 수 있습니다");
                    System.out.println("증거를 더 모으세요");
                }
            }
            else
            {
                System.out.println("잘못 입력하셨습니다");
                System.out.println("선택지에서 안에서 선택해주십시오");
            }
        }
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(5 * 1000); //3초마다
            } catch (InterruptedException e) {}

//            T.eff -= 1;
//            System.out.println("데몬쓰레드가 실행중입니다." + this.eff);
////            if (effDown) effDown();
        }
    }
    static void hunt(Player PC)
    {
        Evidence[] 용의자증거 = new Evidence[10];

        용의자증거[0] = new Evidence("미다졸람", "4시경 미다졸람먹음", 10);

        TheSuspect TS[] = new TheSuspect[2];
        TS[1] = new TheSuspect("김아내", 100,5, 40, new Evidence[]{용의자증거[0]});
        TS[2] = new TheSuspect("윤아빠", 100,5, 70, new Evidence[]{용의자증거[0]});

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        battle : while(true)
        {
            System.out.println("☞ [1] 김아내 취조하기    [2] 윤아빠 취조하기");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:

                    PC.attack(TS[1]);
                    if(TS[1].hp <= 0)
                    {
                        System.out.println(TS[1].name + "의 정보를 얻었습니다");
                        PC.getexp(20);
                        PC.getEvidence(TS[1].evidenceDrop());
                        break battle;
                    }
//                    TS[1].attack(PC);
                    break;

                case 2:
                    break battle;
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