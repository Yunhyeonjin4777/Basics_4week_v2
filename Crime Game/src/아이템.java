public class 아이템 {
    String 아이템name;
    int 가격;
    int 돋보기증가;
    int 체력UP;
    int 공격력UP;
    int 방어력UP;

    public 아이템(String 아이템name, int 가격, int 돋보기증가, int 체력UP, int 공격력UP, int 방어력UP)
    {
        this.아이템name = 아이템name;
        this.가격 = 가격;
        this.돋보기증가 = 돋보기증가;
        this.체력UP = 체력UP;
        this.공격력UP = 공격력UP;
        this.방어력UP = 방어력UP;
    }

    //아이템name
    public String get아이템name()
    {
        return 아이템name;
    }
    public void set아이템name(String 아이템name)
    {
        this.아이템name = 아이템name;
    }

    //가격
    public int get가격()
    {
        return 가격;
    }
    public void set가격(int 가격)
    {
        this.가격 = 가격;
    }

    //돋보기증가
    public int get돋보기증가()
    {
        return 돋보기증가;
    }
    public void set돋보기증가(int 돋보기증가)
    {
        this.돋보기증가 = 돋보기증가;
    }

    //체력UP
    public int get체력UP()
    {
        return 체력UP;
    }
    public void set체력UP(int 체력UP)
    {
        this.체력UP = 체력UP;
    }

    //공격력UP
    public int get공격력UP()
    {
        return 공격력UP;
    }
    public void set공격력UP(int 공격력UP)
    {
        this.공격력UP = 공격력UP;
    }

    //방어력UP
    public int get방어력UP()
    {
        return 방어력UP;
    }
    public void set방어력UP(int 방어력UP)
    {
        this.방어력UP = 방어력UP;
    }
}
