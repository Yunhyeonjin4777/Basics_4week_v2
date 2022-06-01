import java.util.Scanner;

public class 장소 {
    public static Scanner scanner = new Scanner(System.in);

    int choice;
    String name;

    public 장소(String name)
    {
        super();
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
