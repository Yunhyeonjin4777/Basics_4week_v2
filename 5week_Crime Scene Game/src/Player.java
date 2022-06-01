public class Player extends Character{

//    public String name;
//    public int hp; // 체력
//    public int def;
//    public int exp; // 경험치
//    public Evidence[] evidences; //보유 아이템

    int att;
    int progress;
    int 돋보기;
//    boolean 팀원[];
    int gcount;
    Evidence[] MyEvidences;
    effEvidence[] eff_evidences;
    //    boolean 팀원[];

    Player(String name, int 돋보기, int progress, int gcount, int point, int hp, int att, int def, int exp)
    {
        this.name = name;
        this.돋보기 = 돋보기;
        this.progress = progress;
//        팀원 = new boolean[10];
//        for(int i = 0; i < 10; i++)
//            팀원[i] = false;
//        팀원[0] = true;
        this.gcount = gcount;
        this.point = point;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.att = att;
        this.def = def;
        this.exp = exp;
        this.level = 1;
        this.MyEvidences = new Evidence[50];
        this.eff_evidences = new effEvidence[50];
    }
    void mainshowInfo() //player메인정보
    {
        System.out.println("    수사 진행율\ud83d\udcdc " + this.progress + "%   돋보기\ud83d\udd0d " + this.돋보기
                + "    체력 " + this.hp + "    검거횟수\ud83e\uddb0" + this.gcount);
    }

    void show_Log()
    {
        System.out.println("╔════════════════════════════════ 수사 일지 ═══════════════════════════════╗");
        System.out.println("                                  \uD83D\uDCDC 물증\n");
        //일반증거
        for(int i = 0; i < MyEvidences.length; i++)
        {
            if(MyEvidences[i] != null)
            {
                System.out.println(MyEvidences[i].evidenceInfo());
            }
        }

        System.out.println(" ━━━━━ 정황증거(증거효력감소) ━━━━━");
        //효력감소증거
        for(int i = 0; i < eff_evidences.length; i++)
        {
            if(eff_evidences[i] != null)
            {
                System.out.println(eff_evidences[i].effEvidenceInfo());
            }
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════╝");
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
        System.out.println("           [1] 한번 더 접근하겠습니까?     [2] 수사일지로 돌아가기");
        System.out.println("╰────────────────────────────────────────────────────────────────────╯");
    }

    void get현장증거(Evidence evi)
    {
        System.out.println("[" + evi.name + "] 에 대한 증거를 얻었습니다.");
        for(int i = 0; i < MyEvidences.length; i++)
        {
            if(MyEvidences[i] == null)
            {
                MyEvidences[i] = evi;
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

    void attack(TheSuspect TS){
        int damage = att - TS.def;
        damage = damage <= 0 ? 1 : damage;
        TS.hp = TS.hp < damage ? 0 : damage;
        System.out.println(name + "가 공격으로" + TS.name + "에게" + damage + "만큼 데미지를 주었습니다. ");
        System.out.println(TS.name + "의 남은 hp : " + TS.hp);
    }

    void showInfo(){
        System.out.println("이름 : " + name);
        System.out.println("돋보기 : " + 돋보기);
        System.out.println("수사진행율 : " + progress);
        System.out.println("포인트 : " + point);
        System.out.println("레벨 : " + level + "(" + exp + "/100)");
        System.out.println("체력 : " + maxHP);
        System.out.println("공격 : " + att);
        System.out.println("경험치 : " + exp);
        System.out.println("방어 : " + def);
    }

    void getexp(int exp)
    {
        System.out.println(exp + "의 경험치를 획득하셨습니다");
        this.exp += exp;
        while(100 <= this.exp)
        {
            levelUp();
            this.exp -= 100;
        }
    }

    void levelUp() {
        level++;
        maxHP += 10;
        att += 2;
        def += 2;
        System.out.println("레벨업!!!");
    }

    void getEvidence(Evidence evidence){
        System.out.println(evidence.name + "을 획득하였습니다");
        for(int i = 0; i < evidences.length; i++)
        {
            if(evidences[i] == null)
            {
                evidences[i] = evidence;
                break;
            }
        }
        progress += evidence.progress;
    }



    void make돋보기(int a)
    {
        돋보기 += a;
    }

    boolean use돋보기 (int 돋)
    {
        if( 돋 > 돋보기)
            return false;
        돋보기 -= 돋;
        return true;
    }

    public int get돋보기()
    {
        return 돋보기;
    }

    void progressUP(int progress)
    {
        this.progress += progress;
    }

//    void Get돋보기(int 돋보기)
//    {
//        this.돋보기 += 돋보기;
//    }


}
