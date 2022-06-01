public class Character {

    public String name;
    public int hp; // 체력
    public int level;
    public int def;
    public int exp; // 경험치
    public int maxHP; // 공격력
    public int point; // 포인트
    public Evidence[] evidences; //보유 아이템

//    // 공격하기
//    public int attack()
//    {
//        return power;R
//    }

    // 공격받기
    public void attacked(int sum) {

        // 방어력이 받은 데미지보다 큰 경우
        if(def >= sum)
            hp = hp - 0;
        else
            hp = hp + def - sum;
    }
}
