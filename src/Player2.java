public class Player2 {

    String name;
    int maxHP; //최대 체력
    int hp; //체력
    int att; //공격력
    int def; //방어력
    int exp; //경험치
    int level; //레벨
    int progress;
    Evidence2[] evidence2s;

    Player2(String name, int hp, int att, int def, int exp)
    {
        this.name = name;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.att = att;
        this.def = def;
        this.level = 1;
        this.exp = exp;
//        int progress = 0;
        this.evidence2s = new Evidence2[10];
    }

    void showInfo2()
    {
        System.out.println("이름 : " + name);
        System.out.println("레벨 : " + level + "(" + exp + "/100)");
        System.out.println("체력 : " + maxHP);
        System.out.println("공격 : " + att);
        System.out.println("경험치 : " + exp);
        System.out.println("방어 : " + def);
        System.out.println("수사진행율 : " + progress);
        System.out.println("수사일지");
        for(int i = 0; i < evidence2s.length; i++)
        {
            if(evidence2s[i] != null)
            {
                System.out.println(evidence2s[i].evidenceInfo());
            }
        }
    }

    void attack(thesuspect2 suspect)
    {
        int damage = att - suspect.def;
        damage = damage <= 0 ? 1 : damage;
        suspect.hp = suspect.hp < damage ? 0 : damage;
        System.out.println(name + "가 공격으로" + suspect.name + "에게" + damage + "만큼 데미지를 주었습니다. ");
        System.out.println(suspect.name + "의 남은 hp : " + suspect.hp);
    }


    //경험치 획득
    void getexp2(int exp)
    {
        System.out.println(exp + "의 경험치를 획득하셨습니다");
        this.exp += exp;
        while(100 <= this.exp)
        {
            levelUp();
            this.exp -= 100;
        }
    }

    void levelUp()
    {
        level++;
        maxHP += 10;
        att += 2;
        def += 2;
        System.out.println("레벨업!!!");
    }

    void getevidence(Evidence2 evidence2)
    {
        System.out.println(evidence2.name + "을 획득하였습니다");
        for(int i = 0; i < evidence2s.length; i++)
        {
            if(evidence2s[i] == null)
            {
                evidence2s[i] = evidence2;
                break;
            }
        }
        progress += evidence2.progress;
    }
}
