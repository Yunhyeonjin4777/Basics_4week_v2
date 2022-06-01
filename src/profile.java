public class profile {

    public String name;
    public int height;
    public int weight;
    public String job;

    public profile(String name, int height, int weight, String job)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.job = job;
    }
    public void showInfo()
    {
        System.out.println("[1] 수사일지로 돌아가기");
        System.out.println("<기본정보>");
        System.out.println("이름 : " + name);
        System.out.println("키 : " + height);
        System.out.println("몸무게 : " + weight);
        System.out.println("직업 : " + job);
    }
}