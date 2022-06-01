public class 전문가 extends NpcCharacter{

    int deposit;

    전문가(String name, int hp, int deposit, Evidence[] evidences)
    {
        this.name = name;
        this.maxHP = hp;
        this.hp = this.maxHP;
        this.deposit = deposit;
        this.evidences = evidences;
    }

//    public int purchase(int money, int number) // 포인트 계산
//    {
//        System.out.println("고용을 시도하는 중입니다.");
//        if(number == 1)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 2)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 3)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 4)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 5)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 6)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        if(number == 7)
//        {
//            if(.deposit <= money)
//                return money - .deposit;
//        }
//        // 돈이 부족할 때
//        return -1;
//    }


}
