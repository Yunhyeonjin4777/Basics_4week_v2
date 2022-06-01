public class NpcCharacter extends 캐릭터{

    int time_count = 0;

//    int count() {
//
//    }

    Evidence evidencedrop(){
        return evidences[(int)(Math.random() * evidences.length)];
    }
}
