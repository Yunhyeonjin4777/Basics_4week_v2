public class Log {

    private int size = 0;
    private String[] EvidenceData = new String[50];

    public boolean add(String delimiter)
    {
        EvidenceData[size] = delimiter;
        size++;
        return true;
    }

}
