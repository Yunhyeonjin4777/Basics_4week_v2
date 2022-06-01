public class TheSuspect {

    String name;
    int maxHP; //최대 체력
    int hp; //체력
    int att; //공격력
    int def; //방어력
    Evidence[] evidences;

    TheSuspect(String name, int hp, int att, int def, Evidence[] evidences)
    {
        this.name = name;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.att = att;
        this.def = def;
        this.evidences = evidences;
    }

    void attack(Player PC)
    {
        int damage = att - PC.def;
        damage = damage <= 0 ? 1 : damage;
        PC.hp = PC.hp < damage ? 0 : damage;
        System.out.println(name + "가 공격으로" + PC.name + "에게" + damage + "만큼 데미지를 주었습니다. ");
        System.out.println(PC.name + "의 남은 hp : " + PC.hp);
    }

    Evidence evidenceDrop()
    {
        return evidences[(int)(Math.random() * evidences.length)];
    }
}

