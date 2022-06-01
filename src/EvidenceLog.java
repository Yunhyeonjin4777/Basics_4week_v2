public class EvidenceLog {

    private int size = 0;
    private String[] EvidenceData = new String[50];

    public boolean add(String delimiter)
    {
        EvidenceData[size] = delimiter;
        size++;
        return true;
    }

    public String toString()
    {
        String str;
        str =  "╔════════════════════════════════ 수사 일지 ═══════════════════════════════╗\n" +
                "                             \uD83D\uDCDC 피해자 김아들(16)\n" +
                "                1995-09-08 오전 8시 45분경 서울 금천구에 소재한\n" +
                "             단독주택에서 자신의 아들이 살해된 채 발견되었다는 신고 접수.\n" +
                " \n" +
                " ━━━━━ 증거 ━━━━━\n";

        for(int i = 0; i < size; i++) //모든 리스트값을 순회
        {
            str += EvidenceData[i];
            if(i < size-1)
            {
                str += "\n";
            }
        }
        return str +
                "\n" +
                "╚═════════════════════════════════════════════════════════════════════════╝\n" +
                "\n" +
                "\n" +
                "\n" +
                "☞ [1] 현장가기     [2] 돋보기 모으러 가기    [3] 용의자수첩    [4] 주변탐문하기  [5] 취조하기  [6] 검거하기";
    }


}
