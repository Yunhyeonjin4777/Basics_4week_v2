public class Evidence {

    String name;
    String Description;
    int progress;

    private int size = 0;
    private String[] EvidenceData = new String[50];

    Evidence(String name, String Des, int progress)
    {
        this.name = name;
        this.Description = Des;
        this.progress = progress;
    }

    String evidenceInfo()
    {
        String info = Description;
        return info;
    }

    public boolean add(String delimiter)
    {
        EvidenceData[size] = delimiter;
        size++;
        return true;
    }

    public String toString()
    {
        String str;
        str = "╔════════════════════════════════ 수사 일지 ═══════════════════════════════╗\n" +
                "                                  \uD83D\uDCDC 물증\n";

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
                " ━━━━━ 정황증거(증거효력감소) ━━━━━\n" +
                "\n" +
                "╚═════════════════════════════════════════════════════════════════════════╝\n" +
                "\n" +
                "\n" +
                "\n" +
                "☞ [1] 현장가기     [2] 돋보기 모으러 가기";

    }


//    String evidenceInfo()
//    {
//        System.out.println("블라블라");
//    }
}
