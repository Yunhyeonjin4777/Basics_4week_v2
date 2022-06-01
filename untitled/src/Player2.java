/*
public class Player2 extends 캐릭터{

    int att;
    int progress;

    Player2(String name, int point, int hp, int att, int def, int exp)
    {
        this.name = name;
        this.point = point;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.att = att;
        this.def = def;
        this.exp = exp;
        this.level = 1;
        this.progress = 0;
        this.evidences = new Evidence[50];
    }

    void showInfo(){
        System.out.println("이름 : " + name);
        System.out.println("포인트 : " + point);
        System.out.println("레벨 : " + level + "(" + exp + "/100)");
        System.out.println("체력 : " + maxHP);
        System.out.println("공격 : " + att);
        System.out.println("경험치 : " + exp);
        System.out.println("방어 : " + def);
        System.out.println("수사진행율 : " + progress);
    }
    void show_Log(){
        System.out.println("수사일지");
        for(int i = 0; i < evidences.length; i++)
        {
            if(evidences[i] != null)
            {
                System.out.println(evidences[i].evidenceInfo());
            }
        }
    }
    void attack(용의자 suspect){
        int damage = att - suspect.def;
        damage = damage <= 0 ? 1 : damage;
        suspect.hp = suspect.hp < damage ? 0 : damage;
        System.out.println(name + "가 공격으로" + suspect.name + "에게" + damage + "만큼 데미지를 주었습니다. ");
        System.out.println(suspect.name + "의 남은 hp : " + suspect.hp);
    }
    void getexp(){
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
}

*/