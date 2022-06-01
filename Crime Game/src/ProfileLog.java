public class ProfileLog {

    private int size = 0;
    private String[] ProfileData = new String[50];

    public boolean add (String delimiter)
    {
        ProfileData[size] = delimiter;
        size++;
        return true;
    }

    public String toString()
    {
        String str;
        str =   "                 '검거에 필요한 핵심증거는 노트에 따로 정리합니다'\n " +
                "╔════════════════════════════════ 검거노트 ═══════════════════════════════╗\n" +
                "\n";
        for(int i = 0; i < size; i++) //모든 리스트값을 순회
        {
            str += ProfileData[i];
            if(i < size-1)
            {
                str += "\n";
            }
        }
        return str +
                "\n" +
                "╚════════════════════════════════════════════════════════════════════════╝";
    }

}