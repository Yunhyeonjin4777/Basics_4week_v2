public class 타이핑 {
    public static void main(String[] args)
    {
        //String s ="안녕하세요안녕하세요 만나서 반갑습니다 오늘은 무조건 전반적으로 다 구현을 하자 다른 사람들 거의 4개이상씩 쓰레드 완성시켰다███████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n";
        String s = """
                출근을 위해 잠시 집을 비운 아버지
                몇 시간 후 돌아온 집에선,
                코를 찌르는 피냄새와 함께 거실에서 살해된 아들이 발견되는데...
                15세의 아들 시신 주변은 마치 강도가 들이닥친 듯 난장판이다
                급히 함께 집에 있던 아내를 확인하기 위해 안방을 들어가니
                아내는 태연하게 잠을 자고 있었다
                쉽게 이해되지 않는 사건현장,
                과연 사건의 진실은 무엇일까?
                
                ──────────────────────────────────────────────────────────────────────────────────────────────────────
                ☞ 게임을 시작하려면 [ 1 ] 를 누르시오.
                """;
        loading(s);
    }
    static void loading(String s)
    {
        try{
            for (int i = 0; i < s.length(); i++) { // 로딩 효과 스레드
                Thread.sleep(10);
                System.out.print( s.charAt(i) );
            }
        }catch(InterruptedException e) {}
    }
}
