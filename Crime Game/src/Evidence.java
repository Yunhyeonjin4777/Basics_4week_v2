public class Evidence {

    String name;
    String Description;
    int progress;

    private int size = 0;
    private String[] EvidenceData = new String[50];

    public Evidence(String name, String Des, int progress)
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


}
