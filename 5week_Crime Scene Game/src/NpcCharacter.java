public class NpcCharacter extends Character{

    int time_count = 0;
    effEvidence[] eff_evidences;

    NpcCharacter(String name, int hp, int def, Evidence[] evidences,  effEvidence[] eff_evidences)
    {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.evidences = evidences;
        this.eff_evidences = eff_evidences;
    }

    Evidence evidenceDrop(){
        return evidences[(int)(Math.random() * evidences.length)];
    }
}
