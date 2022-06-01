public class thesuspect2 {

    String name;
    int maxHP; //최대 체력
    int hp; //체력
    int att; //공격력
    int def; //방어력
    Evidence2[] evidence2s;

    thesuspect2(String name, int hp, int att, int def, Evidence2[] evidence2s)
    {
        this.name = name;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.att = att;
        this.def = def;
        this.evidence2s = evidence2s;
    }

    void attack(Player2 PC2)
    {
        int damage = att - PC2.def;
        damage = damage <= 0 ? 1 : damage;
        PC2.hp = PC2.hp < damage ? 0 : damage;
        System.out.println(name + "가 공격으로" + PC2.name + "에게" + damage + "만큼 데미지를 주었습니다. ");
        System.out.println(PC2.name + "의 남은 hp : " + PC2.hp);
    }

    Evidence2 evidence2drop()
    {
        return evidence2s[(int)(Math.random() * evidence2s.length)];
    }


}
