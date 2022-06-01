/*import java.util.Random;
import java.util.Scanner;

public class cat {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        고양이그림 img = new 고양이그림();
        생선가게 store_img = new 생선가게();
        cat = new 고양이();
        냥이상점 store = new 냥이상점();
        인벤토리 item = new 인벤토리();
        글자 text = new 글자();

        int[] cnt= {0,0,0,0,0,0,0}; // 아이템 갯수 세기
        int get =0;

        int leg=0;
        int tail=0;
        int scales=0;

        Music introMusic = new Music("introMusic.mp3",true); // 배경음악

        Music typing = new Music("typing.mp3",true); // 타이핑 효과
        Music fight = new Music("fight.mp3",true);

        introMusic.start();

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("				가장냥이의 생선가게 털러가기 								");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        Thread.sleep(2000);
        img.show_cat(); // 고양이 그림 출력

        String s = "길고양이인 가장냥이는 자식냥이들을 먹여살리기 위해  생선을 털어 자식냥이들을 키워야한다.\n\n"
                + "생선가게를 털기 위해서는 Level 4 이상이 되어야한다.\n\n"
                + "사냥과 구걸하기를 통해 경험치를 획득하여 레벨업을 하고 \n\n"
                + "생선가게 사장님의 눈을 피해 최종미션인 생선가게를 털어 생선을 확보하면 Mission Complete!!\n\n"
                + "(단, 생선가게는 밤에는 문을 닫아 미션을 수행할 수 없다. )\n\n"
                + "7일 안에 생선가게를 털어 집으로 돌아가지 못한다면 자식 냥이들이 죽어 미션 실패이다.\n\n"
                + "1. 흰고양이(날쌔서 파워가 높다.)   2. 검은 고양이 (은둔 능력이 뛰어나 방어력이 높다.)\n\n"
                + "가장 냥이의 종류를 입력해주세요\n\n";

        typing.start();

        for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
            Thread.sleep(25);
            System.out.print( s.charAt(i) );
        }
        typing.close();

        int number = scanner.nextInt();


        if(number==1) {
            System.out.println("[ 흰고양이 ] 가 선택되었습니다. \n");
            cat = new 흰고양이();
            cat.hp = 200;
            cat.level = 1;
            cat.power = 20;
            cat.defense = 15;
            cat.money = 0;
            cat.experience = 0;
            //cat.fish=1;
        }
        else if(number==2) {
            System.out.println("[ 검은고양이 ] 가 선택되었습니다. \n");
            cat = new 검은고양이();
            cat.hp = 200;
            cat.level = 4;
            cat.power = 15;
            cat.defense = 20;
            cat.money = 0;
            cat.experience = 0;
        }
        System.out.print("가장 냥이의 이름을 입력해주세요 : \n");
        cat.name= scanner.next();

        Thread.sleep(1000);
        System.out.println("");
        System.out.println("이름이 입력되었습니다.\n");
        System.out.println("캐릭터를 생성합니다.\n");
        s ="██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n";

        for (int i = 0; i < s.length(); i++) { // 로딩 효과 스레드
            Thread.sleep(10);
            System.out.print( s.charAt(i) );
        }
        Thread.sleep(100);
        System.out.println("\n");
        System.out.println("게임을 시작합니다!!");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Thread.sleep(1000);


        ThreadTimerEx timer = new ThreadTimerEx(); // 시간 표시

        //상태창 state = new 상태창();
        introMusic.close();
        cat.show();

        while(true)
        {
            Music introMusic1 = new Music("introMusic.mp3",true); // 배경음악
            introMusic1.start();

            if(timer.day()==7) {
                System.out.println("\n\n\n");
                System.out.println("7일이 지났습니다.\n\n");
                Thread.sleep(1000);
                System.out.println("미션 실패..\n\n");
                Thread.sleep(1000);
                System.out.println("자식 냥이들이 가장냥이를 기다리다가 죽었습니다.\n\n");
                Thread.sleep(1000);
                text.show_end();
                System.exit(0);

            }
            // 이동 경로 선택
            System.out.println("- - - - - - - - - - - - - - - - - - 메뉴 창 - - - - - - - - - - - - - - - - - - - - - - - -\n");
            System.out.println("                 (1) 인벤토리           (2) 냥이 상점           (3) 사냥하기          (4) 생선가게 털러가기 ");
            System.out.println("                 (5) 구걸하기           (6) 상태 확인하기      (7) 종료하기 \n");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
//		   System.out.println("1. 인벤토리");
//		   System.out.println("2. 냥이 상점");
//		   System.out.println("3. 사냥하기");
//		   System.out.println("4. 생선가게 털러가기");
//		   System.out.println("5. 구걸하기");
//		   System.out.println("6. 상태 확인하기");
//		   System.out.println("7. 종료하기");
            System.out.println("");
            System.out.print("원하시는 번호를 입력하세요 : ");
            int number_menu = scanner.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            if(number_menu==1) { // 인벤토리
                Music button = new Music("button_click.mp3",false);  // 버튼 클릭
                button.start();

                int sum = item.inventory_show(cnt); // 인벤토리 띄우기

                if(sum!=0) {
                    System.out.println("어떤 아이템을 사용하시겠습니까?(0. 돌아가기) : ");
                    number = scanner.nextInt();

                    cat.hp = item.inventory_use_hp(number,cnt, cat.hp);
                    // 아이템 사용 (hp 아이템)
                    cat.power = item.inventory_use_power(number,cnt,cat.power);
                    // 아이템 사용 (power 아이템)
                    cat.defense = item.inventory_use_defense(number,cnt,cat.defense);
                    // 아이템 사용 (defense 아이템)
                }
                introMusic1.close();

            }
            if(number_menu==2) { // 냥이 상점

                Music button1 = new Music("button_click.mp3",false);  // 버튼 클릭
                button1.start();

                store.choice();
                int choice_num = scanner.nextInt();

                if(choice_num ==0) {

                }
                if(choice_num==1) {
                    Music button2 = new Music("button_click.mp3",false);  // 버튼 클릭
                    button2.start();

                    store.show(); // 냥이 상점 메뉴 보여주기
                    number = scanner.nextInt();

                    if(number==0) {
                        continue;
                    }
                    int temp = cat.money;
                    if((cat.money = store.purchase(cat.money, number)) != -1) // 물품 구매
                    {
                        Thread.sleep(1000);
                        System.out.println("");
                        System.out.println("구입이 완료되었습니다.\n");
                        Music acheive6 = new Music("acheive.mp3",false);  // 버튼 클릭
                        acheive6.start();

                        Thread.sleep(1000);
                        System.out.println("구입한 물품을 사용/확인하려면 인벤토리 창으로 이동하세요.\n");
                        Thread.sleep(1000);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                        if (number == 1) cnt[0]+=1; // 물품 담기
                        if (number == 2) cnt[1]+=1;
                        if (number == 3) cnt[2]+=1;
                        if (number == 4) cnt[3]+=1;
                        if (number == 5) cnt[4]+=1;
                        if (number == 6) cnt[5]+=1;
                        if (number == 7) cnt[6]+=1;
                    }
                    else{
                        Thread.sleep(1000);
                        System.out.println("");
                        System.out.println("돈이 부족합니다.\n");
                        Thread.sleep(1000);
                        cat.money= temp;
                        System.out.println("현재 보유한 돈은 "+ temp + " 입니다\n" );
                        Thread.sleep(1000);
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    }
                }
                if(choice_num==2) {
                    Music button3 = new Music("button_click.mp3",false);  // 버튼 클릭
                    button3.start();

                    int sum = store.show_booty(leg, tail, scales);
                    if(sum==0) {

                    }
                    if(sum!=0) {
                        number = scanner.nextInt();

                        if(number==1) {
                            if(leg==0) {
                                System.out.println("번호를 잘못 입력하셨습니다.");
                                System.out.println("");
                            }
                            else {
                                System.out.println("판매할 전리품 [바퀴벌레의 다리] 의 수량을 입력해 주세요.");
                                int sell_count = scanner.nextInt();
                                if(leg<sell_count) {
                                    System.out.println("보유한 전리품의 갯수보다 많은 수량을 판매할 수 없습니다.\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                }
                                else {
                                    System.out.println(sell_count +"개를 판매합니다.\n");
                                    cat.money+=sell_count*10;
                                    leg-=sell_count;
                                    Thread.sleep(1000);
                                    System.out.println("판매를 완료합니다." + sell_count*10 +"원을 획득하였습니다.\n");
                                    Music acheive6 = new Music("acheive.mp3",false);  // 버튼 클릭
                                    acheive6.start();
                                    Thread.sleep(1000);
                                    System.out.println("보유한 돈 : "+cat.money+"\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                }
                            }
                        }

                        if(number==2) {
                            if(tail==0) {
                                System.out.println("번호를 잘못 입력하셨습니다.");
                                System.out.println("");
                            }
                            else {
                                System.out.println("판매할 전리품 [쥐의 꼬리] 의 수량을 입력해 주세요.");
                                int sell_count = scanner.nextInt();
                                if(tail<sell_count) {
                                    System.out.println("보유한 전리품의 갯수보다 많은 수량을 판매할 수 없습니다.\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                }
                                else {
                                    System.out.println(sell_count +"개를 판매합니다.\n");
                                    cat.money+=sell_count*15;
                                    tail-=sell_count;
                                    Thread.sleep(1000);
                                    System.out.println("판매를 완료합니다." + sell_count*15 +"원을 획득하였습니다.\n");
                                    Music acheive7 = new Music("acheive.mp3",false);  // 버튼 클릭
                                    acheive7.start();
                                    Thread.sleep(1000);
                                    System.out.println("보유한 돈 : "+cat.money+"\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                }
                            }
                        }

                        if(number==3) {
                            if(scales==0) {
                                System.out.println("번호를 잘못 입력하셨습니다.");
                                System.out.println("");
                            }
                            else {
                                System.out.println("판매할 전리품 [뱀의 비늘] 의 수량을 입력해 주세요.");
                                int sell_count = scanner.nextInt();
                                if(scales<sell_count) {
                                    System.out.println("보유한 전리품의 갯수보다 많은 수량을 판매할 수 없습니다.\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                }
                                else {
                                    System.out.println(sell_count +"개를 판매합니다.\n");
                                    cat.money+=sell_count*20;
                                    scales-=sell_count;
                                    Thread.sleep(1000);
                                    System.out.println("판매를 완료합니다." + sell_count*20 +"원을 획득하였습니다.\n");
                                    Music acheive8 = new Music("acheive.mp3",false);  // 버튼 클릭
                                    acheive8.start();
                                    Thread.sleep(1000);
                                    System.out.println("보유한 돈 : "+cat.money+"\n\n\n\n\n");
                                    Thread.sleep(2000);
                                    System.out.println("");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                }
                            }
                        }

                    }
                }
                introMusic1.close();


            }
            if(number_menu==3) { // 사냥하기

                //Music button4 = new Music("button_click.mp3",false);  // 버튼 클릭
                //button4.start();

                introMusic1.close(); // 인트로 음악 끄기
                Music fight1 = new Music("fight.mp3",true); // 사냥터 배경음악
                fight1.start(); // 사냥터 배경음악 on

                //fight.start();
                몬스터 monster = new 몬스터();

                System.out.println("사냥터에 입장하였습니다.");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("         1. 바퀴벌레                      ");
                System.out.println("         2. 쥐                              " );
                System.out.println("         3. 뱀                                ");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

                System.out.println("");
                System.out.print("싸울 상대를 입력하세요 : ");
                number = scanner.nextInt();

                if(number==1) {
                    monster = new 바퀴벌레();
                    monster.booty = "바퀴벌레의 다리";
                    monster.name = "바퀴벌레";
                    monster.hp = 300;
                    monster.level = 1;
                    monster.power = 20;
                    monster.defense = 5;
                    monster.money = 10;
                    monster.experience = 20;
                }
                if(number==2) {
                    monster = new 쥐();
                    monster.booty = "쥐의 꼬리";
                    monster.name = "쥐";
                    monster.hp = 500;
                    monster.level = 2;
                    monster.power = 60;
                    monster.defense = 15;
                    monster.money = 30;
                    monster.experience = 30;
                }
                if(number==3) {
                    monster = new 뱀();
                    monster.booty = "뱀의 비늘";
                    monster.name = "뱀";
                    monster.hp = 800;
                    monster.level = 3;
                    monster.power = 100;
                    monster.defense = 25;
                    monster.money = 50;
                    monster.experience = 50;
                }

                System.out.println("");
                System.out.println("싸움을 시작합니다!\n");
                System.out.println("제한시간 10초안에 적을 사냥하세요!\n");


                fight_time = new fight_time(); // 제한시간 10초 생성
                fight_time.start();// 제한시간 10초 시작
                monster.start(); // 몬스터 자동공격 시작
                //cat.start();

                while(true) {

                    if(fight_time.time()==10) { // 제한시간이 지났을 때
                        fight1.close(); // 사냥터 배경음악 끄기
                        monster.Stop(true); // 몬스터 자동공격 중단
                        break;
                    }
                    else {

                        int cat_punch = cat.attack(); // 고양이 공격

                        int a;
                        if(monster.defense>=cat_punch)
                            a=0;
                        else
                            a=monster.defense - cat_punch;

                        monster.attacked(cat_punch); // 몬스터 데미지 깍임
                        //System.out.println("실 데미지 : "+a);
                        //System.out.println("몬스터의 잔여 hp : " + monster.hp);

                        //Music cat_voice = new Music("cat_voice.mp3",true);
                        //cat_voice.start();
                        //cat_voice.close();

                        if(monster.hp>0) {
                            // System.out.println("                 몬스터의 잔여 hp : " + monster.hp);
                        }
                        System.out.println("");


                        if(monster.hp <= 0) 			// 몬스터가  죽었을 때
                        {
                            fight_time.threadStop(true); // 제한시간 중단
                            monster.Stop(true); // 몬스터 자동공격 중단
                            cat.experience += monster.experience;
                            cat.money += monster.money;

                            if(monster.name=="바퀴벌레") {
                                leg++;
                            }
                            if(monster.name=="쥐") {
                                tail++;
                            }
                            if(monster.name=="뱀") {
                                scales++;
                            }

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("[ " + monster.name + " ] 가 죽었습니다.\n");
                            Thread.sleep(1000);
                            System.out.println("[ 돈   +" + monster.money + " ] 을 획득합니다.\n");
                            Music acheive = new Music("acheive.mp3",false);  // 버튼 클릭
                            acheive.start();
                            Thread.sleep(1000);

                            System.out.println("[ 경험치   +" + monster.experience + " ] 을 획득합니다.\n");
                            Music acheive1 = new Music("acheive.mp3",false);  // 버튼 클릭
                            acheive1.start();
                            Thread.sleep(1000);

                            System.out.println("[ 전리품   " + monster.booty + " ] 을 획득합니다.\n");
                            Music acheive3 = new Music("acheive.mp3",false);  // 버튼 클릭
                            acheive3.start();
                            Thread.sleep(1000);

                            if(cat.experience >= cat.level * 50)//100
                            {
                                cat.level += 1;
                                System.out.println("가장냥이의 레벨이 " + cat.level + "이 되었습니다.\n");
                                Music acheive4 = new Music("acheive.mp3",false);  // 버튼 클릭
                                acheive4.start();

                                cat.money += cat.level * 50;
                                System.out.println("레벨업 기념으로 돈이" + cat.level * 50 + "원 증가했습니다.\n");
                                Music acheive5 = new Music("acheive.mp3",false);  // 버튼 클릭
                                acheive5.start();
                                cat.experience = 0;
                            }

                            cat.show_fight();
                            fight1.close();
                            //introMusic1.start();

                            break;
                        }

                    }
                }// while문 끝

            }// 사냥하기 끝
            if(number_menu==4) { // 생선가게 털러가기
                if(cat.level<4) {
                    Music button5 = new Music("button_click.mp3",false);  // 버튼 클릭
                    button5.start();

                    System.out.println("\n\n\n\n");
                    System.out.println("level 4가 되어야 생선가게를 털러갈수 있습니다.\n");
                    Thread.sleep(1000);
                    System.out.println("사냥을 통해  레벨업을 해보세요\n");
                    System.out.println("");
                    Thread.sleep(2000);
                }
                else {
                    if(timer.time()==0) {
                        Music button6 = new Music("button_click.mp3",false);  // 버튼 클릭
                        button6.start();

                        System.out.println("");
                        System.out.println(" ※  낮 - 생선가게 운영시간입니다.\n");
                        Thread.sleep(1000);

                        Random random = new Random();
                        int random_ceo = random.nextInt(3);
                        if(random_ceo == 0 || random_ceo == 1) {

                            System.out.println("다행히 생선가게 사장님이 없습니다.\n");
                            System.out.println("가게로 입장합니다.\n");
                            s ="██████████████████████████████████████████████████████████████\n";
                            for (int i = 0; i < s.length(); i++) { // 로딩 효과 스레드
                                Thread.sleep(10);
                                System.out.print( s.charAt(i) );
                            }
                            System.out.println("");

                            store_img.show_store();
                            System.out.println("");
                            System.out.println("       ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                            System.out.println("                                      화면에 출력되는 생선을 빠르게 클릭하세요\n");
                            System.out.println("             제한시간 10초 동안 10번을 실수 없이 연속으로 맞추면 미션 성공, 아니면 미션 실패 입니다\n");
                            System.out.println("                         게임을 시작할 준비가 되었다면 1번을 돌아가려면 0번을 입력하세요\n");
                            System.out.println("       ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                            int number2 = scanner.nextInt();
                            if(number2==1) {

                                fishgame2  game = new fishgame2("생선잡기");


                                //fishgame game = new fishgame("생선잡기");
                                //get = game.random(0,cat.fish);
                                //int count = game.get();
                                //System.out.println(get); 1
                                //System.out.println(count); 1

                            }

                            if(number2==0) {
                            }
                        }
                        else {
                            System.out.println("생선가게 사장님이 눈을 부릅뜨고 보초를 서고 있습니다.\n");
                            System.out.println("다음 기회를 노려보세요\n");
                        }

                    }
                    else if(timer.time()==1) {

                        Music button7 = new Music("button_click.mp3",false);  // 버튼 클릭
                        button7.start();

                        System.out.println("");
                        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                        System.out.println("");
                        System.out.println("                    ※  밤 - 생선가게가 문을 닫았습니다.");
                        System.out.println("                         생선을 훔칠 수 없습니다.");
                        System.out.println("                        낮이 되면 다시 도전해 보세요");
                        System.out.println("");
                        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                        System.out.println("");
                    }

                }
                introMusic1.close();
            }
            if(number_menu==5) { // 구걸하기

                Music button8 = new Music("button_click.mp3",false);  // 버튼 클릭
                button8.start();

                int remeber = cat.beg();
                if(remeber==1) {
                    cat.hp +=20;
                }
                if(remeber==2) {
                    cat.hp -=10;
                }
                if(remeber==3) {
                    cat.hp -=15;
                }
                introMusic1.close();
            }
            if(number_menu==6) { // 상태확인하기
                Music button9 = new Music("button_click.mp3",false);  // 버튼 클릭
                button9.start();

                cat.show();
                introMusic1.close();
            }
            if(number_menu==7) {// 종료하기
                Music button10 = new Music("button_click.mp3",false);  // 버튼 클릭
                button10.start();
                Thread.sleep(1000);

                text.show_end();
                System.exit(0);
            }

        }

    }
}
*/