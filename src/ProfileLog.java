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
        str =   "              '취재를 통해 더욱 디테일한 내용을 알 수 있습니다'\n " +
                "╔════════════════════════════════ 심문결과 ═══════════════════════════════╗\n" +
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
                "╚═════════════════════════════════════════════════════════════════════════╝";
    }

}
