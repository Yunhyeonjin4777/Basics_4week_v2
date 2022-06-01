import java.util.Objects;
import java.util.Scanner;

public class Player extends Character{

    ProfileLog profileLog = new ProfileLog();

    용의자 용의자 = new 용의자("김아내", 10,10,10);

    public Thread 쿨타임;
    public Boolean 스킬사용 = true;
    int 최대체력 = 100;

    int att;
    int progress;
    int 돋보기;
    int gcount;
    effEvidence[] eff_evidences;
    //    boolean 팀원[];

    Player(String name, int hp, int def, int exp, int att, int progress, int 돋보기, int gcount)
    {
        this.name = name;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.def = def;
        this.exp = exp;
        this.att = att;
        this.progress = progress;
        this.돋보기 = 돋보기;
        this.gcount = gcount;
        this.evidences = new Evidence[50];
        this.eff_evidences = new effEvidence[50];
//        팀원 = new boolean[10];
//        for(int i = 0; i < 10; i++)
//            팀원[i] = false;
//        팀원[0] = true;
    }

    void mainshowInfo()//메인정보
    {
        System.out.println("          수사 진행율\ud83d\udcdc " + this.progress + "%   돋보기\ud83d\udd0d " + this.돋보기
                + "    체력 " + this.hp + "    검거횟수\ud83e\uddb0" + this.gcount);
    }

    void showInfo()//나의상세정보
    {
        System.out.println("이름 : " + name);
        System.out.println("체력 : " + maxHP);
        System.out.println("방어 : " + def);
        System.out.println("경험치 : " + exp);
        System.out.println("공격 : " + att);
        System.out.println("수사진행율 : " + progress);
        System.out.println("검거횟수 : " + gcount);
    }

    void show_Log()//수사일지
    {
        System.out.println("╔════════════════════════════════ 수사 일지 ═══════════════════════════════╗");
        System.out.println("                                  \uD83D\uDCDC 물증\n");
        //일반증거
        for(int i = 0; i < evidences.length; i++)
        {
            if(evidences[i] != null)
            {
                System.out.println(evidences[i].evidenceInfo());
            }
        }
        System.out.println(" ");
        System.out.println(" ━━━━━ 정황증거(증거효력감소) ━━━━━");
        //효력감소증거
        for(int i = 0; i < eff_evidences.length; i++)
        {
            if(eff_evidences[i] != null)
            {
                System.out.println(eff_evidences[i].effEvidenceInfo());
            }
        }

        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        System.out.println(" ");

    }

    void Attack(NpcCharacter Npc)
    {
        int damage = this.exp - Npc.def;
        damage = damage <= 0 ? this.exp : damage;
        Npc.def = Npc.def < damage ? Npc.def - Npc.def : Npc.def - damage;
        System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
        System.out.println("                          경계도 : " + Npc.def);
        System.out.println("             상대방에게 " + damage + "만큼의 신뢰도를 쌓을 수 있습니다");
        System.out.println(" ");
        System.out.println("                   [현재 돋보기 : " + this.돋보기 + "]" );
        System.out.println("                 [1] 접근하겠습니까?     [2] 돌아가기");
        System.out.println("╰────────────────────────────────────────────────────────────────────╯");
    }

    public void 용의자_취조하다(Player PC, 용의자 김아내, 용의자 윤아빠, ProfileLog profileLog)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println(" ");
        System.out.println("               ╭──────────────────────<알림>──────────────────────╮");
        System.out.println("                  ❝사건에 적절한 [키워드]를 선택해서 용의자를 취조합니다❞");
        System.out.println(" ");
        System.out.println("                       주의) 대화가 길어질수록 상대방의 공격으로");
        System.out.println("                            당신의 체력이 줄어드니 주의하세요");
        System.out.println("               ╰─────────────────────────────────────────────────╯");
        System.out.println(" ");
        System.out.println("☞ [1] 돌아가기     [2] 김아내취조하기    [3] 윤아빠취조하기");
        choice = scanner.nextInt();

//        용의자.용의자상태창();

        if(choice == 1)
        {
            System.out.println("지금은 이만 물러가겠습니다");
        }
        else if(choice == 2)//김아내취조하기
        {
            //용의자 자동공격
            Thread 졸개공격 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int damage = 김아내.공격력 - PC.def;
                    try{
                        while(김아내.체력 >= 0 || PC.hp >= 0)
                        {
                            if(김아내.체력 >= 0)
                            {
                                Thread.sleep(3000);//5초 단위로 공격
                                damage = damage <= 0 ? 1 : damage;
                                PC.def = PC.def < damage ? 0 : PC.def - damage;
                                PC.hp = PC.hp - damage;
                                System.out.println("당신의 남은 hp : " + PC.hp);
                            }

                            if(김아내.체력 <= 0)
                            {
                                김아내.용의자취조성공(PC, 김아내);
                                break;
                            }
                            else if(PC.hp <= 0)
                            {
                                PC.사망(PC, 김아내);
                                break;
                            }
                        }
                    }catch (InterruptedException e) {}
                }
            });
            졸개공격.setDaemon(true);
            졸개공격.start();

            battle:
            while(PC.hp != 0 && 김아내.체력 > 0)
            {
                System.out.println("☞ [1] 돌아가기  [2] 직업  [3] 알리바이  [4] 왼/오른손잡이");
                choice = scanner.nextInt();

                if(choice == 1)//돌아가기
                {
                    System.out.println("이만 물러가겠습니다");
                    System.out.println(" ");
                    System.out.println(" ");
                    졸개공격.interrupt();
                    break;
                }

                else if(choice == 2)//직업
                {
                    System.out.println("'근처 '이모네' 식당 요리사입니다'");
                    System.out.println(" ");

                    continue battle;
                }
                else if(choice == 3)//알리바이
                {
                    System.out.println("'피해자의 사망시간 오전 4시에서 7시경, 당신은 뭘하고 있었죠?'");
                    System.out.println("'새벽 4시경 인슐린 주사를 놓고 잠이 쏟아져 그대로 잤습니다'");
                    System.out.println("'증언해줄 사람이 있습니까?'");
                    System.out.println("'그날 저와 아들밖에 없어서 잘모르겠네요..'");
                    System.out.println(" ");
                    profileLog.add("[인슐린주사] - 사건 발생전 인슐린 주사를 놓았다");
                    continue battle;
                }
                else if(choice == 4)//왼/오른손잡이
                {
                    System.out.println("'저는 오른손잡이입니다'");
                    System.out.println(" ");
                    profileLog.add("[아내오른손잡이] - 자상의 위치는 피해자 왼쪽");
                    continue battle;
                }
            }
            if(PC.hp == 0)
            {
                졸개공격.interrupt();
                PC.사망(PC, 김아내);
            }
        }
        else if(choice == 3)//윤아빠취조하기
        {
            //용의자 자동공격
            Thread 졸개공격 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int damage = 윤아빠.공격력 - PC.def;
                    try{
                        while(윤아빠.체력 >= 0 || PC.hp >= 0)
                        {
                            if(윤아빠.체력 >= 0)
                            {
                                Thread.sleep(3000);//5초 단위로 공격
                                damage = damage <= 0 ? 1 : damage;
                                PC.def = PC.def < damage ? 0 : PC.def - damage;
                                PC.hp = PC.hp - damage;
                                System.out.println("당신의 남은 hp : " + PC.hp);
                            }

                            if(윤아빠.체력 <= 0)
                            {
                                윤아빠.용의자취조성공(PC, 윤아빠);
                                break;
                            }
                            else if(PC.hp <= 0)
                            {
                                PC.사망(PC, 윤아빠);
                                break;
                            }
                        }
                    }catch (InterruptedException e) {}
                }
            });
            졸개공격.setDaemon(true);
            졸개공격.start();

            battle:
            while(PC.hp != 0 && 윤아빠.체력 > 0)
            {
                System.out.println("☞ [1] 돌아가기  [2] 직업  [3] 알리바이  [4] 왼/오른손잡이  [5] 방문이유");
                choice = scanner.nextInt();

                if(choice == 1)//돌아가기
                {
                    System.out.println("이만 물러가겠습니다");
                    System.out.println(" ");
                    System.out.println(" ");
                    졸개공격.interrupt();
                    break;
                }
                else if(choice == 2)//직업
                {
                    System.out.println("'빵공장 앞 '새일' 약국 약사입니다'");
                    continue battle;
                }
                else if(choice == 3)//알리바이
                {
                    System.out.println("'피해자의 사망시간 오전 4시에서 7시경, 당신은 뭘하고 있었죠?'");
                    System.out.println("'6시 반쯤 약국으로 출근해서 8시까지 업무를 보다가 개인적인 일로 돌아오는 길이었습니다'");
                    System.out.println("'증언해줄 사람이 있습니까?'");
                    System.out.println("'평소 혼자 다니는 편이라 모르겠네요'");
                    profileLog.add("[아빠알리바이] - 사건 발생당시 약국으로 출근");
                    continue battle;
                }
                else if(choice == 4)//왼/오른손잡이
                {
                    System.out.println("'저는 오른손잡이입니다'");
                    profileLog.add("[아빠오른손잡이] - 자상의 위치는 피해자 왼쪽");
                    continue battle;
                }
                else if(choice == 5)//방문이유
                {
                    System.out.println("'어떤 이유로 집으로 오신거죠?'");
                    System.out.println("'지극히 개인적인 거에요. 말하고 싶지 않아요.'");
                    profileLog.add("[아빠방문이유회피]");
                    continue battle;
                }
            }
            if(PC.hp == 0)
            {
                졸개공격.interrupt();
                PC.사망(PC, 윤아빠);
            }
        }
        else
        {
            System.out.println("잘못입력하였습니다");
        }

    }

    public void 용의자_검거하다(Player PC, 용의자 김아내, 용의자 윤아빠, ProfileLog profileLog)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("                             당신의 현재 hp : " + PC.hp);
        System.out.println(" ");
        System.out.println("               ╭────────────────────<알림>────────────────────╮");
        System.out.println("                     ❝ 획득한 증거로 상대방의 '자백을 유도' 하세요");
        System.out.println("                           증거에 따라 압박강도가 다르며");
        System.out.println("                   제시 횟수가 제한되어 있으니 신중히 생각하십시오 ❞");
        System.out.println(" ");
        System.out.println("                     주의) 상대방 또한 당신의 압박에 회피하며");
        System.out.println("                          당신을 공격할 수 있으니 주의하세요");
        System.out.println("               ╰─────────────────────────────────────────────╯");
        System.out.println(" ");
        System.out.println("☞ [1] 수사일지로 돌아가기     [2] 김아내검거하기    [3] 윤아빠검거하기");
        choice = scanner.nextInt();


        if(choice == 1)
        {
            System.out.println("다음번에 검거하지");
        }
        else if (choice == 2)//김아내검거하기
        {
            //용의자 자동공격
            Thread 졸개공격 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int damage = 김아내.공격력 - PC.def;
                    try{
                        while(김아내.체력 >= 0 || PC.hp >= 0)
                        {
                            if(김아내.체력 >= 0)
                            {
                                Thread.sleep(10000);//10초 단위로 공격
                                damage = damage <= 0 ? 1 : damage;
                                PC.def = PC.def < damage ? 0 : PC.def - damage;
                                PC.hp = PC.hp - damage;

                                System.out.println("                                            당신의 남은 hp : " + PC.hp);
                            }

                            if(김아내.체력 <= 0)
                            {
                                김아내.용의자검거성공(PC, 김아내);
                                break;
                            }
                            else if(PC.hp <= 0)
                            {
                                PC.사망(PC, 김아내);
                                break;
                            }
                        }
                    }catch (InterruptedException e) {}
                }
            });
            졸개공격.setDaemon(true);
            졸개공격.start();

            System.out.println(profileLog);
            System.out.println(" ");
            System.out.println("☞ 돌아가길 원하시면 [ 돌아가기 ] 를 입력하세요");

            battle:
            while(PC.hp != 0 && 김아내.체력 > 0)
            {
                if(PC.hp <= 0)
                {
                    졸개공격.interrupt();
                    PC.사망(PC, 김아내);
                    break;
                }
                if(김아내.체력 <= 0)
                {
                    김아내.용의자검거성공(PC, 김아내);
                    break;
                }
                String s = scanner.nextLine();

                if (Objects.equals(s, "돌아가기"))
                {
                    System.out.println(" ");
                    System.out.println(" ");
                    졸개공격.interrupt();
                    break;
                }
                else if (Objects.equals(s, "미다졸람"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 20;
                    System.out.println("<김아내> : '쓸데없는 소리는 그만두세요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "보험내역"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 50;
                    System.out.println("매달내는 보험료가 부담스러우셨을텐데요?");
                    System.out.println("<김아내> : '앗..!그건..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "사건당시소리"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -=30;
                    System.out.println(
                            "아드님 살해당시,\n" +
                            "이웃집 A씨도 들었을 정도의 꽤나 큰 소리가 났는데\n" +
                            "정말로 아무론 소리도 못들었나요?");
                    System.out.println("<김아내> : '저..정말 못들었어요!..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "피해자와엄마관계"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 30;
                    System.out.println("평소 아드님과 관계가 좋지 않으셨다고요?");
                    System.out.println("<김아내> : '앗..!그건..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "피해자와아빠관계"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '쓸데없는 소리는 그만두세요'");
                    continue battle;
                }
                else if (Objects.equals(s, "인슐린주사"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '네 그날따라 잠이 쏟아졌어요. 그게 사건과 무슨상관이죠?'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아내오른손잡이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("피해자의 자상은 왼쪽! 범인은 오른손잡이야!");
                    System.out.println("<김아내> : '그게 저와 무슨 상관이죠? 멍청한 형사같으니..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠알리바이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '쓸데없는 소리는 그만두세요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠오른손잡이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '쓸데없는 소리는 그만두세요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠방문이유회피"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '쓸데없는 소리는 그만두세요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "CCTV확인결과"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            김아내의 남은 hp : " + 김아내.체력);
                    김아내.체력 -= 5;
                    System.out.println("<김아내> : '저랑은 상관이 없는 내용입니다..'");
                    System.out.println(" ");
                    continue battle;
                }
            }
        }
        else if(choice == 3)//윤아빠검거하기
        {
            //용의자 자동공격
            Thread 졸개공격 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int damage = 윤아빠.공격력 - PC.def;
                    try{
                        while(윤아빠.체력 >= 0 || PC.hp >= 0)
                        {
                            if(윤아빠.체력 >= 0)
                            {
                                Thread.sleep(15000);//15초 단위로 공격
                                damage = damage <= 0 ? 1 : damage;
                                PC.def = PC.def < damage ? 0 : PC.def - damage;
                                PC.hp = PC.hp - damage;

                                System.out.println("                                            당신의 남은 hp : " + PC.hp);
                            }

                            if(윤아빠.체력 <= 0)
                            {
                                윤아빠.용의자검거성공(PC, 윤아빠);
                                break;
                            }
                            else if(PC.hp <= 0)
                            {
                                PC.사망(PC, 윤아빠);
                                break;
                            }
                        }
                    }catch (InterruptedException e) {}
                }
            });
            졸개공격.setDaemon(true);
            졸개공격.start();

            System.out.println(profileLog);
            System.out.println(" ");
            System.out.println("☞ 돌아가길 원하시면 [ 돌아가기 ] 를 입력하세요");

            battle:
            while(PC.hp != 0 && 윤아빠.체력 > 0)
            {
                if(PC.hp <= 0)
                {
                    졸개공격.interrupt();
                    PC.사망(PC, 윤아빠);
                    break;
                }
                if(윤아빠.체력 <= 0)
                {
                    윤아빠.용의자검거성공(PC, 윤아빠);
                    break;
                }
                String s = scanner.nextLine();

                if (Objects.equals(s, "돌아가기"))
                {
                    System.out.println(" ");
                    System.out.println(" ");
                    졸개공격.interrupt();
                    break;
                }
                else if (Objects.equals(s, "미다졸람"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 30;
                    System.out.println("기면 상태를 유도하는 이 약, 당신 집 화장실에서 발견했어!");
                    System.out.println("<윤아빠> : '앗..그건..그게..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "보험내역"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 5;
                    System.out.println("<윤아빠> : '저랑 상관없는 일입니다'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "사건당시소리"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 5;
                    System.out.println("<윤아빠> : '저는 그 자리에 있지도 않았다고요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "피해자와엄마관계"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 10;
                    System.out.println("<윤아빠> : '저랑 상관없는 일입니다'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "피해자와아빠관계"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 10;
                    System.out.println("'당신이 양부라는 증언이 있습니다 사실인가요?'");
                    System.out.println("<윤아빠> : '네...맞습니다..김아내가 이혼한 뒤 1년 후에 만났어요'");
                    continue battle;
                }
                else if (Objects.equals(s, "인슐린주사"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 30;
                    System.out.println("'김아내가 주사를 놓는다는 것을 알지? 거기에 뭔가 아는게 있나?'");
                    System.out.println("<윤아빠> : '아...저는...아무것도 모릅니다..!'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아내오른손잡이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 5;
                    System.out.println("피해자의 자상은 왼쪽! 당신 아내는 오른손잡이야!");
                    System.out.println("<윤아빠> : '그게 저와 무슨 상관이죠? 멍청한 형사같으니..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠알리바이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 20;
                    System.out.println("<윤아빠> : '저는 그 시간에 근무 중이라고 말씀드렸잖아요'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠오른손잡이"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 5;
                    System.out.println("피해자의 자상은 왼쪽! 범인은 오른손잡이야!");
                    System.out.println("<윤아빠> : '그게 저와 무슨 상관이죠? 멍청한 형사같으니..'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "아빠방문이유회피"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 20;
                    System.out.println("방문이유를 회피하면 당신만 불리해진건 알텐데?");
                    System.out.println("<윤아빠> : '하..사실 휴..휴대폰을 두고와서!!'");
                    System.out.println(" ");
                    continue battle;
                }
                else if (Objects.equals(s, "CCTV확인결과"))
                {
                    PC.gcount -= 1;
                    System.out.println("                                            윤아빠의 남은 hp : " + 윤아빠.체력);
                    윤아빠.체력 -= 40;
                    System.out.println("CCTV를 확인하니 당신의 알리바이는 거짓이군.! 왜 거짓말을 했지!!!?");
                    System.out.println("<윤아빠> : '큼...그건...그걸 들키다니..!!'");
                    System.out.println(" ");
                    continue battle;
                }
            }
        }
    }

    public void 사망(Player Player, 용의자 김아내)
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
        System.out.println("헉...검거에 실패했습니다..다음 기회에..");
    }

    void get현장증거(Evidence evi)
    {
        System.out.println("[" + evi.name + "] 에 대한 증거를 얻었습니다.");
        for(int i = 0; i < evidences.length; i++)
        {
            if(evidences[i] == null)
            {
                evidences[i] = evi;
                break;
            }
        }
        progress += evi.progress;
    }

    void geteffEvidence(effEvidence effEvi)
    {
        System.out.println("[" + effEvi.name + "] 에 대한 증거를 얻었습니다.");
        for(int i = 0; i < eff_evidences.length; i++)
        {
            if(eff_evidences[i] == null)
            {
                eff_evidences[i] = effEvi;
                break;
            }
        }
        progress += effEvi.progress;
    }

    public void effDown(effEvidence effEvi)
    {
        쿨타임 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                while(true){
                    try
                    {
                        Thread.sleep(5 * 1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    if (effEvi.eff > 0)
                    {
                        effEvi.eff --;
                    }
                    if (effEvi.eff == 50)
                    {
                        System.out.println(effEvi.name + "증거효력이 " + effEvi.eff + "% 남았습니다");
                    }
                    if (effEvi.eff == 0)
                    {
                        System.out.println(effEvi.name + "증거 효력이 소실되었습니다");
                    }
                }
            }
        });
        쿨타임.start();
    }

    public void 현장감식원고용(Player PC)
    {
        PC.돋보기 = PC.돋보기 - 200;
    }
    public void 프로파일러고용(Player PC)
    {
        PC.돋보기 = PC.돋보기 - 300;
    }
    public void 법의학자고용(Player PC)
    {
        PC.돋보기 = PC.돋보기 - 400;
    }
    public void 허둥지둥조수고용(Player PC)
    {
        PC.돋보기 = PC.돋보기 - 100;
    }
    public void 영상분석가고용(Player PC)
    {
        PC.돋보기 = PC.돋보기 - 500;
    }

}
