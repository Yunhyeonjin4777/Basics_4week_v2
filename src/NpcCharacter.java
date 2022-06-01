public class NpcCharacter extends Character{

    NpcCharacter(String name, String Description, int def, int hp, int att, Evidence[] evidences)
    {
        this.name = name;
        this.Description = Description;
        this.def = def;
        this.hp = hp;
        this.att = att;
        this.evidences = evidences;
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
