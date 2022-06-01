public class effEvidence extends Evidence{

    int eff;

    private int size = 0;
    private String[] 심문증거 = new String[50];

    effEvidence(String name, String Description, int progress, int eff)
    {
        super(name,Description,progress);
        this.eff = eff;
    }

    String effEvidenceInfo()
    {
        String info = Description;
        if(0<eff)
            info += " (증거효력 : " + this.eff + ")";
        return info;
    }

    public boolean add(String delimiter)
    {
        심문증거[size] = delimiter;
        size++;
        return true;
    }

    public String toString()
    {
        String str;
        str =   "              '취재를 통해 더욱 디테일한 내용을 알 수 있습니다'\n " +
                "╔════════════════════════════════ 심문결과 ═══════════════════════════════╗\n" +
                "\n";
        for(int i = 0; i < size; i++) //모든 리스트값을 순회
        {
            str += 심문증거[i];
            if(i < size-1)
            {
                str += "\n";
            }
        }
        return str +
                "\n" +
                "╚═════════════════════════════════════════════════════════════════════════╝";
    }
}
