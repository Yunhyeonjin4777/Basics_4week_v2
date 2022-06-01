public class THEsuspect extends NpcCharacter{

    THEsuspect(String name, String Description, int def, int hp, int att, Evidence[] evidences)
    {
        super(name, Description, def, hp, att, evidences);
    }


    void attack(Player3 PC) {

        int damage = exp - PC.def;
        //(공격력에서 - 방어력 뺴기)
        damage = damage <= 0 ? 1 : damage;
        PC.hp = PC.hp < damage ? 0 : PC.hp - damage;
        System.out.println(name + "는 " + "당신의 신문에 " + damage + "만큼 훼방을 놓고 도망갔습니다");
        System.out.println("당신의 남은 체력 : " + PC.hp);
    }


}
