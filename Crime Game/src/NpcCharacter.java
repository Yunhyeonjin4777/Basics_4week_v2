public class NpcCharacter extends Character{

    effEvidence[] eff_evidences;

    NpcCharacter(String name, int hp, int def, Evidence[] evidences,  effEvidence[] eff_evidences)
    {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.evidences = evidences;
        this.eff_evidences = eff_evidences;
    }

}
