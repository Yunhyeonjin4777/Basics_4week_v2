public class Player3 extends Character{

    public int progress;
    public int magnifier;
    public int gcount;

    Player3(String name, String Description, int att, int hp, int exp, int progress, int gcount, int magnifier, Evidence[] evidences)
    {
        this.name = name;
        this.Description = Description;
        this.hp = hp;
        this.att = att;
        this.exp = exp;
        this.progress = progress;
        this.magnifier = magnifier;
        this.gcount = gcount;
        this.evidences = evidences;
    }

    void showInfo1() {
        System.out.println(this.name +" '"+ this.Description + "' 취조기회 : " + this.hp + "   경험치 : " + exp + "   돋보기\ud83d\udd0d : " + this.magnifier + "(돋보기로 증거를 찾을 수 있다)");
    }

    void showInfo2() {
        System.out.println("         경험치 " + this.exp + "    수사 진행율\ud83d\udcdc " + this.progress + "%   돋보기\ud83d\udd0d " + this.magnifier + "  검거횟수\ud83e\uddb0 " + this.gcount);
    }

    void GetExp(int exp)
    {
        this.exp += exp;
    }

    void ProgressUP(int progress)
    {
        this.progress += progress;
    }

    void change (int magnifier, int exp, int progress)
    {
        this.magnifier -= magnifier;
        this.exp += exp;
        this.progress += progress;
    }




    void Minus(int gcount)
    {
        this.gcount -= gcount;
    }
    void MagnifierUP(int magnifier)
    {
        this.magnifier += magnifier;
    }
//    void MagnifierDown(int Magnifier)
//    {
//        this.magnifier -= Magnifier;
//    }

//    void showInfo3() {
//        System.out.println("상태");
//        System.out.println("이름 : " + name);
//        System.out.println("체력 : " + Hp);
//        System.out.println("공격 : " + att);
//        System.out.println("방어 : " + def);
//    }

    void attack (THEsuspect TS) {
        int damage = exp -  TS.def;
        damage = damage <= 0 ? 1 : damage;
        TS.hp =  TS.hp < damage ? 0 :  TS.hp - damage;
        System.out.println("당신은 " +  TS.name + "에게 " + damage + "만큼 데미지를 주었습니다!");
        System.out.println( TS.name + "의 남은 방어력 : " +  TS.hp);
        System.out.println(" ");
    }



    void Attack(NpcCharacter NPC)
    {
        int damage = this.exp - NPC.def;
        damage = damage <= 0 ? this.exp : damage;
        NPC.def = NPC.def < damage ? NPC.def - NPC.def : NPC.def - damage;
        System.out.println("╭────────────────────────────────<알림>───────────────────────────────╮");
        System.out.println("                          경계도 : " + NPC.def);
        System.out.println("             상대방에게 " + damage + "만큼의 신뢰도를 쌓을 수 있습니다");
        System.out.println(" ");
        System.out.println("   [1] 한번 더 접근하겠습니까?[돋보기 1개 차감]     [2] 수사일지로 돌아가기");
        System.out.println("╰────────────────────────────────────────────────────────────────────╯");
    }


}
